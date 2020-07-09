package com.github.doomsdayrs.jikan4java.data.model.main.user.listing.animelist

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListType
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Licensors
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Studios
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
 * ====================================================================*/
/**
 * Jikan4java
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class AnimeListAnime(
		@field:JsonProperty("mal_id") override val malID: Int = 0,
		@field:JsonProperty("title") val title: String? = null,
		@field:JsonProperty("video_url") val video_url: String? = null,
		@field:JsonProperty("url") override val url: String,
		@field:JsonProperty("image_url") override val imageURL: String? = null,
		@field:JsonProperty("type") override val type: String? = null,
		@field:JsonProperty("watching_status") val watching_status: Int = 0,
		@field:JsonProperty("score") val score: Int = 0,
		@field:JsonProperty("watched_episodes") val watched_episodes: Int = 0,
		@field:JsonProperty("total_episodes") val total_episodes: Int = 0,
		@field:JsonProperty("airing_status") val airing_status: Int = 0,
		@field:JsonProperty("season_name") val season_name: String? = null,
		@field:JsonProperty("season_year") val season_year: String? = null,
		@field:JsonProperty("has_episode_video") val has_episode_video: Boolean = false,
		@field:JsonProperty("has_promo_video") val has_promo_video: Boolean = false,
		@field:JsonProperty("has_video") val has_video: Boolean = false,
		@field:JsonProperty("is_rewatching") val is_rewatching: Boolean = false,
		@field:JsonProperty("tags") val tags: String? = null,
		@field:JsonProperty("rating") val rating: String? = null,
		@field:JsonProperty("start_date") val start_date: String? = null,
		@field:JsonProperty("end_date") val end_date: String? = null,
		@field:JsonProperty("watch_start_date") val watch_start_date: String? = null,
		@field:JsonProperty("watch_end_date") val watch_end_date: String? = null,
		@field:JsonProperty("days") val days: String? = null,
		@field:JsonProperty("storage") val storage: String? = null,
		@field:JsonProperty("priority") val priority: String? = null,
		@field:JsonProperty("added_to_list") val added_to_list: Boolean = false,
		@field:JsonProperty("studios") val studios: ArrayList<Studios>? = null,
		@field:JsonProperty("licensors") val licensors: ArrayList<Licensors>? = null
) : Retriever(), MyAnimeListID, MyAnimeListURL, MyAnimeListImageURL, MyAnimeListType {

	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	val anime by lazy { retrieve<Anime>("$baseURL/anime/$malID") }
}