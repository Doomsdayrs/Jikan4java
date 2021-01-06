package com.github.doomsdayrs.jikan4java.common

import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request


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

internal fun getDefaultOkHttpClient() = OkHttpClient().let {
	val builder = it.newBuilder()
	builder.addInterceptor @Throws(InterruptedException::class) { chain: Interceptor.Chain ->
		val request = chain.request()
		rateLimit()
		if (debugMode)
			println("$PROJECT_NAME: $LOADING_MESSAGE:\t ${request.url}")
		chain.proceed(request)
	}
	builder.build()
}

internal fun getDefaultJSONParser() = Json {
	encodeDefaults = true
	coerceInputValues = true
}

internal fun getDefaultRequestBuilder() = Request.Builder()