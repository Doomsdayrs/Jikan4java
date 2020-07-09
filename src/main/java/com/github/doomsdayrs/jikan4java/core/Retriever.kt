package com.github.doomsdayrs.jikan4java.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.doomsdayrs.jikan4java.data.exceptions.RequestError
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException
import java.io.IOException
import java.net.URL
import java.util.*
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
 */
/**
 * Jikan4java
 * 11 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
open class Retriever(
		protected val client: OkHttpClient = OkHttpClient(),
		protected val objectMapper: ObjectMapper = ObjectMapper(),
		protected val jsonParser: JSONParser = JSONParser(),
		protected val builder: Request.Builder = Request.Builder()
) {
	companion object {
		val baseURL = "https://api.jikan.moe/v3"

		var debugMode = false

		@JvmStatic
		val errorMessages = ArrayList<Array<String?>>()
	}

	/**
	 * Request builder
	 *
	 * @param url data to request
	 * @return response from jikan
	 * @throws IOException something went wrong
	 */
	@Throws(IOException::class)
	protected fun request(url: String?): ResponseBody? = client.newCall(builder.url(URL(url)).build()).execute().body()

	/**
	 * Connects to the jikan API and parses incoming data
	 *
	 * @param target what to parse into
	 * @param url    apiURL
	 * @return A completable future of the parsed response
	 */
	inline fun <reified T> retrieve(url: String): CompletableFuture<T> {
		return CompletableFuture.supplyAsync<T> {
			var response = ""
			try {
				println("Retrieving: $url")
				val responseBody = request(url)
				if (responseBody != null) {
					response = responseBody.string()
					if (debugMode) println("RAWJSON: $response")
					val jsonObject = jsonParser.parse(response) as JSONObject
					if (debugMode) println("JSONOBJECT: " + jsonObject.toJSONString())

					if (!jsonObject.containsKey("error")) {
						return@supplyAsync objectMapper.readValue(jsonObject.toJSONString(), T::class.java)
					} else {
						throw CompletionException(RequestError(jsonObject["error"].toString()))
					}
				} else {
					println("Response body is null")
					return@supplyAsync null
				}
			} catch (e: IOException) {
				if (debugMode) errorMessages.add(arrayOf(e.message, response, url))
				e.printStackTrace()
				return@supplyAsync null
			} catch (e: ParseException) {
				if (debugMode) errorMessages.add(arrayOf(e.message, response, url))
				e.printStackTrace()
				return@supplyAsync null
			}
		}
	}

}