package com.github.doomsdayrs.jikan4java.data.model.main.anime.episodes

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListEpisodes
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class EpisodesPage(
	@SerialName("request_hash") override val requestHash: String? = null,
	@SerialName("request_cached") override val requestCached: Boolean = false,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int = 0,
	@SerialName("episodes_last_page") val episodesLastPage: Int = 0,
	@SerialName("episodes") override val episodes: ArrayList<Episode>
) : RequestHashing, MyAnimeListEpisodes<Episode> {

	@Deprecated(
		"Changed to proper naming format",
		ReplaceWith("episodesLastPage")
	)
	@Suppress("PropertyName", "unused")
	val episodes_last_page
		get() = episodesLastPage
}
