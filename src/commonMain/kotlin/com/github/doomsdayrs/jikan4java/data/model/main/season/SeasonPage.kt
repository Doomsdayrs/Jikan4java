package com.github.doomsdayrs.jikan4java.data.model.main.season

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.data.enums.Season
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmStatic

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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class SeasonPage(
	@SerialName("request_hash") override val requestHash: String,
	@SerialName("request_cached") override val requestCached: Boolean = false,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int = 0,
	@SerialName("season_name") val season_name: String? = null,
	@SerialName("season_year") val season_year: Int = 0,
	@SerialName("anime") val animes: List<SeasonSearchAnime> = listOf()
) : RequestHashing {

	companion object {

		/**
		 * Gets a [SeasonPage] via [year] and the [season] of that year
		 *
		 * @param retriever Retriever class
		 * @param year Which year to look at
		 * @param season Which season of the [year]
		 */
		@JvmStatic
		fun get(
			year: Int,
			season: Season
		) = "$JIKAN_URL/season/$year/$season"

		@JvmStatic
		val nextSeasonUrl by lazy { "$JIKAN_URL/season/later" }
	}
}