package com.github.doomsdayrs.jikan4java.common

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.simple.parser.JSONParser


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
 */
/**
 * Jikan4java
 * 10 / 07 / 2020
 *
 * @author github.com/doomsdayrs
 */

fun getDefaultObjectMapper() =
		ObjectMapper()
				.apply {
					configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
				}
				.registerModule(KotlinModule(
						nullIsSameAsDefault = true
				))

fun getDefaultOkHttpClient() = OkHttpClient().let {
	val builder = it.newBuilder()
	builder.addInterceptor { chain: Interceptor.Chain ->
		val request = chain.request()
		rateLimit()
		println("$jikan4JavaName: $loadingMessage:\t ${request.url()}")
		chain.proceed(request)
	}
	builder.build()
}

fun getDefaultJSONParser() = JSONParser()

fun getDefaultRequestBuilder() = Request.Builder()