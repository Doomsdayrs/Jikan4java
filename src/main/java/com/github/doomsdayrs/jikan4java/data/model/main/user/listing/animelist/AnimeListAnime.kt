package com.github.doomsdayrs.jikan4java.data.model.main.user.listing.animelist

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.*
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
		@JsonProperty("mal_id") override val malID: Int = 0,
		@JsonProperty("title") val title: String = "",
		@JsonProperty("video_url") val video_url: String = "",
		@JsonProperty("url") override val url: String,
		@JsonProperty("image_url") override val imageURL: String = "",
		@JsonProperty("type") override val type: String = "",
		@JsonProperty("watching_status") val watching_status: Int = 0,
		@JsonProperty("score") val score: Int = 0,
		@JsonProperty("watched_episodes") val watched_episodes: Int = 0,
		@JsonProperty("total_episodes") val total_episodes: Int = 0,
		@JsonProperty("airing_status") val airing_status: Int = 0,
		@JsonProperty("season_name") val season_name: String = "",
		@JsonProperty("season_year") val season_year: String = "",
		@JsonProperty("has_episode_video") val has_episode_video: Boolean = false,
		@JsonProperty("has_promo_video") val has_promo_video: Boolean = false,
		@JsonProperty("has_video") val has_video: Boolean = false,
		@JsonProperty("is_rewatching") val is_rewatching: Boolean = false,
		@JsonProperty("tags") val tags: String = "",
		@JsonProperty("rating") val rating: String = "",
		@JsonProperty("start_date") override val startDate: String = "",
		@JsonProperty("end_date") override val end_date: String = "",
		@JsonProperty("watch_start_date") val watch_start_date: String = "",
		@JsonProperty("watch_end_date") val watch_end_date: String = "",
		@JsonProperty("days") val days: String = "",
		@JsonProperty("storage") val storage: String = "",
		@JsonProperty("priority") val priority: String = "",
		@JsonProperty("added_to_list") val added_to_list: Boolean = false,
		@JsonProperty("studios") val studios: ArrayList<Studios>,
		@JsonProperty("licensors") val licensors: ArrayList<Licensors>
) : Retriever(), MyAnimeListID, MyAnimeListURL, MyAnimeListImageURL, MyAnimeListType, MyAnimeListStartEndDate {

	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	val anime by lazy { retrieve<Anime>("$jikanURL/anime/$malID") }
}