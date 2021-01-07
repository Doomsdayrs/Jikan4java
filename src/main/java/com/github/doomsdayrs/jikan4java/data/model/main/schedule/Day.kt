package com.github.doomsdayrs.jikan4java.data.model.main.schedule

import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
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
 * ====================================================================*/
/**
 * Jikan4java
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
sealed class Day : RequestHashing {
	abstract val subAnimes: List<SubAnime>

	@Serializable
	data class Friday(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("friday") override val subAnimes: List<SubAnime>
	) : Day()


	@Serializable
	data class Monday(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("monday") override val subAnimes: List<SubAnime>
	) : Day()

	@Serializable
	data class Other(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("other") override val subAnimes: List<SubAnime>
	) : Day()

	@Serializable
	data class Saturday(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("saturday") override val subAnimes: List<SubAnime>
	) : Day()

	@Serializable
	data class Sunday(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("sunday") override val subAnimes: List<SubAnime>
	) : Day()

	@Serializable
	data class Thursday(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("thursday") override val subAnimes: List<SubAnime>
	) : Day()

	@Serializable
	data class Tuesday(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("tuesday") override val subAnimes: List<SubAnime>
	) : Day()

	@Serializable
	data class Unknown(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("unknown") override val subAnimes: List<SubAnime>
	) : Day()

	@Serializable
	data class Wednesday(
		@SerialName("request_hash") override val requestHash: String,
		@SerialName("request_cached") override val requestCached: Boolean,
		@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
		@SerialName("wednesday") override val subAnimes: List<SubAnime>
	) : Day()
}