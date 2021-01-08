package com.github.doomsdayrs.jikan4java.core

import com.github.doomsdayrs.jikan4java.common.*
import com.github.doomsdayrs.jikan4java.data.exceptions.RequestError
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import java.io.IOException
import java.util.*
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
class Retriever(
	private val client: OkHttpClient = getDefaultOkHttpClient(),
	@Suppress("MemberVisibilityCanBePrivate")
	private val builder: Request.Builder = getDefaultRequestBuilder(),
	private val format: Json = getDefaultJSONParser(),
) {

	/**
	 * Request builder
	 *
	 * @param url data to request
	 * @return response from jikan
	 * @throws IOException something went wrong
	 */
	internal fun request(url: String): ResponseBody? {
		println(url)
		val request: Request = builder.url(url).build()
		val call = client.newCall(request)
		return call.execute().body
	}

	internal inline operator fun <reified T> invoke(url: String) =
		retrieve<T>(url)

	internal inline fun <reified T> retrieve(
		url: String
	): JCompletableFuture<T> = GlobalScope.future {
		var response = ""
		try {
			val responseBody = request(url)
			if (responseBody != null) {
				response = responseBody.string()
				if (debugMode)
					println("RAWJSON: $response")

				val jsonElement: JsonElement =
					format.parseToJsonElement(response)

				if (debugMode)
					println(
						"JSONOBJECT:\n${format.encodeToString(jsonElement)}"
					)

				val jsonObject: JsonObject = jsonElement.jsonObject

				if (!jsonObject.containsKey("error")) {
					return@future successResult(
						format.decodeFromJsonElement<T>(
							jsonElement
						)
					)
				} else return@future errorResult(
					CompletionException(
						RequestError(jsonObject["error"].toString())
					)
				) as JikanResult<T>
			} else {
				println("Response body is null")
				return@future emptyResult() as JikanResult<T>
			}
		} catch (e: IOException) {
			return@future errorResult(e) as JikanResult<T>
		} catch (e: SerializationException) {
			return@future errorResult(e) as JikanResult<T>
		}
	}

}