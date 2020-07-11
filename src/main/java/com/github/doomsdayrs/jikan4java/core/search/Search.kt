package com.github.doomsdayrs.jikan4java.core.search

import com.fasterxml.jackson.module.kotlin.readValue
import com.github.doomsdayrs.jikan4java.common.*
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.enums.search.Types
import okhttp3.Request
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
open class Search<PAGE, SINGLE, SET>(
		val type: Types
) : Retriever(
		client = getDefaultOkHttpClient(),
		objectMapper = getDefaultObjectMapper(),
		jsonParser = getDefaultJSONParser(),
		builder = getDefaultRequestBuilder()
) where SET : Search<PAGE, SINGLE, SET> {
	var query = ""
	var limit = 10

	/**
	 * Creates the URL to be used to retrieve the Object
	 *
	 * @return StringBuilder of the URL so far
	 */
	open fun createURL(): String = "$jikanURL/search/$type?q=${query.replace(" ".toRegex(), "%20")}${
	if (limit != 0)
		"&limit=$limit"
	else ""
	}"

	/**
	 * Set how many result to be listed per page, limit is greater then 0
	 *
	 * @param limit how many entries
	 * @return This
	 * @throws IndexOutOfBoundsException incase you input a 0
	 */
	open fun setLimit(limit: Int): SET {
		if (limit != 0) this.limit = limit else throw IndexOutOfBoundsException("This program does not accept 0s")
		return this as SET
	}

	/**
	 * Set the title that will be queried
	 *
	 * @param title Title or name of what you want
	 * @return This
	 */
	open fun setQuery(title: String): SET {
		query = title
		return this as SET
	}

	/**
	 * Gets the first result in list provided as its own object:
	 * AnimePage = anime,
	 * MangaPage = manga,
	 * CharacterPage = character,
	 * PersonPage = person.
	 *
	 * @return Completable future of the process
	 */
	@Throws(CompletionException::class)
	inline fun <reified S> getFirst(): CompletableFuture<SINGLE>? where S : SINGLE = CompletableFuture.supplyAsync {
		try {
			val responseBody = super.request(createURL())
			val jsonObject = jsonParser.parse(responseBody!!.string()) as JSONObject
			val jsonArray = jsonObject["results"] as JSONArray?
			println(jsonArray)
			// Gets anime ID then goes to it's page
			val request = Request.Builder()
					.url("$jikanURL/${type}/${(jsonArray!![0] as JSONObject)["mal_id"].toString()}").build()
			val response = client.newCall(request).execute()
			return@supplyAsync response.body()?.let {
				objectMapper.readValue<S>((jsonParser.parse(it.string()) as JSONObject).toJSONString())
			}
		} catch (e: Exception) {
			throw CompletionException(e)
		}
	}

	/**
	 * Gets the page
	 *
	 * @return Completable future of the process
	 */
	inline fun <reified P> get(): CompletableFuture<P> where P : PAGE = retrieve(createURL())

	inline fun <reified S> getByID(id: Int): CompletableFuture<S> where S : SINGLE = retrieve("$jikanURL/$type/$id")
}