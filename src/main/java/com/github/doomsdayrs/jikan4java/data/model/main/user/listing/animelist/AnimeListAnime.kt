package com.github.doomsdayrs.jikan4java.data.model.main.user.listing.animelist

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
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
		@field:JsonProperty("mal_id") var mal_id: Int = 0,
		@field:JsonProperty("title") var title: String? = null,
		@field:JsonProperty("video_url") var video_url: String? = null,
		@field:JsonProperty("url") var url: String? = null,
		@field:JsonProperty("image_url") var image_url: String? = null,
		@field:JsonProperty("type") var type: String? = null,
		@field:JsonProperty("watching_status") var watching_status: Int = 0,
		@field:JsonProperty("score") var score: Int = 0,
		@field:JsonProperty("watched_episodes") var watched_episodes: Int = 0,
		@field:JsonProperty("total_episodes") var total_episodes: Int = 0,
		@field:JsonProperty("airing_status") var airing_status: Int = 0,
		@field:JsonProperty("season_name") var season_name: String? = null,
		@field:JsonProperty("season_year") var season_year: String? = null,
		@field:JsonProperty("has_episode_video") var has_episode_video: Boolean = false,
		@field:JsonProperty("has_promo_video") var has_promo_video: Boolean = false,
		@field:JsonProperty("has_video") var has_video: Boolean = false,
		@field:JsonProperty("is_rewatching") var is_rewatching: Boolean = false,
		@field:JsonProperty("tags") var tags: String? = null,
		@field:JsonProperty("rating") var rating: String? = null,
		@field:JsonProperty("start_date") var start_date: String? = null,
		@field:JsonProperty("end_date") var end_date: String? = null,
		@field:JsonProperty("watch_start_date") var watch_start_date: String? = null,
		@field:JsonProperty("watch_end_date") var watch_end_date: String? = null,
		@field:JsonProperty("days") var days: String? = null,
		@field:JsonProperty("storage") var storage: String? = null,
		@field:JsonProperty("priority") var priority: String? = null,
		@field:JsonProperty("added_to_list") var added_to_list: Boolean = false,
		@field:JsonProperty("studios") var studios: ArrayList<Studios>? = null,
		@field:JsonProperty("licensors") var licensors: ArrayList<Licensors>? = null
) : Retriever() {

	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	val anime by lazy { retrieve<Anime>("$baseURL/anime/$mal_id") }
}