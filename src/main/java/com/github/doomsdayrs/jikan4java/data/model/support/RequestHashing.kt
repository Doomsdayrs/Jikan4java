package com.github.doomsdayrs.jikan4java.data.model.support

import kotlinx.serialization.SerialName

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
 */ /**
 * Jikan4java
 * 18 / 11 / 2019
 *
 * @author github.com/doomsdayrs
 */
interface RequestHashing {
	@SerialName("request_hash")
	val requestHash: String?

	@SerialName("request_cached")
	val requestCached: Boolean

	@SerialName("request_cache_expiry")
	val requestCacheExpiry: Int


	@Suppress("PropertyName")
	@Deprecated("Changed to proper naming format", ReplaceWith("malID"))
	val request_hash: String?
		get() = requestHash

	@Suppress("PropertyName")
	@Deprecated("Changed to proper naming format", ReplaceWith("malID"))
	val request_cached: Boolean
		get() = requestCached

	@Suppress("PropertyName")
	@Deprecated("Changed to proper naming format", ReplaceWith("malID"))
	val request_cache_expiry: Int
		get() = requestCacheExpiry
}