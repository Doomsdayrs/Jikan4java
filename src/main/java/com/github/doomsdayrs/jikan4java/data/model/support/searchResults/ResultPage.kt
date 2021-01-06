package com.github.doomsdayrs.jikan4java.data.model.support.searchResults

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
 * com.github.doomsdayrs.jikan4java.types.support.searchResults
 * 18 / November / 2019
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class ResultPage(
	@SerialName("request_hash") val request_hash: String?,
	@SerialName("request_cached") val request_cached: Boolean,
	@SerialName("request_cache_expiry") val request_cache_expiry: Int,
	@SerialName("last_page") val last_page: Int = 0
)