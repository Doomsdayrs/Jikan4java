package com.github.doomsdayrs.jikan4java.core.search

import com.github.doomsdayrs.jikan4java.common.*
import com.github.doomsdayrs.jikan4java.core.*
import com.github.doomsdayrs.jikan4java.data.enums.search.Types
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import okhttp3.Request
import okio.IOException
import java.util.concurrent.CompletableFuture

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
	val type: Types,
	val retriever: Retriever
) where SET : Search<PAGE, SINGLE, SET> {
	@Suppress("MemberVisibilityCanBePrivate")
	var query = ""

	@Suppress("MemberVisibilityCanBePrivate")
	var limit = 10

	/**
	 * Creates the URL to be used to retrieve the Object
	 *
	 * @return StringBuilder of the URL so far
	 */
	open fun createURL(): String {

		return "$JIKAN_URL/search/$type?q=${
			query.replace(
				" ".toRegex(),
				"%20"
			)
		}${
			if (limit != 0)
				"&limit=$limit"
			else ""
		}"
	}

	/**
	 * Set how many result to be listed per page, limit is greater then 0
	 *
	 * @param limit how many entries
	 * @return This
	 * @throws IndexOutOfBoundsException incase you input a 0
	 */
	@Throws(IndexOutOfBoundsException::class)
	open fun setLimit(limit: Int): SET {
		if (limit != 0) this.limit = limit else throw IndexOutOfBoundsException(
			"This program does not accept 0s"
		)
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
	inline fun <reified S> getFirst(): CompletableFuture<JikanResult<SINGLE>> where S : SINGLE =
		GlobalScope.future {
			return@future try {
				retriever.request(createURL()).use { responseBody ->
					val jsonElement =
						retriever.format.parseToJsonElement(responseBody!!.string())

					val jsonObject =
						jsonElement.jsonObject

					val jsonArray = jsonObject["results"]!!.jsonArray
					if (debugMode)
						println(jsonArray)
					// Gets first entities ID
					jsonArray[0].jsonObject["mal_id"].toString()
				}.let { malID ->
					val request = Request.Builder()
						.url("$JIKAN_URL/${type}/$malID")
						.build()
					val response = retriever.client.newCall(request).execute()
					val responseBody = response.body
						?: return@future emptyResult() as JikanResult<SINGLE>

					responseBody.use {
						val responseContent = responseBody.string()
						successResult(
							retriever.format.decodeFromString<S>(
								responseContent
							)
						)
					}
				}

			} catch (e: IOException) {
				errorResult(e) as JikanResult<SINGLE>
			} catch (e: Exception) {
				errorResult(e) as JikanResult<SINGLE>
			}
		}

	/**
	 * Gets the page
	 *
	 * @return Completable future of the process
	 */
	inline fun <reified P> get(): CompletableFuture<JikanResult<P>> where P : PAGE =
		retriever(createURL())

	inline fun <reified S> getByID(id: Int): CompletableFuture<JikanResult<S>> where S : SINGLE =
		retriever("$JIKAN_URL/$type/$id")
}