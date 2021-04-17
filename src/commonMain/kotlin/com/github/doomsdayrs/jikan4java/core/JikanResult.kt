package com.github.doomsdayrs.jikan4java.core


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
 * jikan4java
 * 05 / 01 / 2021
 *
 * @author github.com/doomsdayrs
 */
sealed class JikanResult<T> {
	class Success<T>(val data: T) : JikanResult<T>()

	object Empty : JikanResult<Nothing>()

	class JException(
		val exception: java.lang.Exception
	) : JikanResult<Nothing>()
}

fun <T> successResult(data: T): JikanResult.Success<T> =
	JikanResult.Success(data)

fun  errorResult(exception: Exception): JikanResult.JException =
	JikanResult.JException(exception)

fun  emptyResult(): JikanResult.Empty =
	JikanResult.Empty