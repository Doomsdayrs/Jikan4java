package com.github.doomsdayrs.jikan4java.data.model.main.user.listing.animelist

import com.github.doomsdayrs.jikan4java.data.base.type.MyAnimeListAnimeType
import com.github.doomsdayrs.jikan4java.data.base.values.*
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Licensors
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Studios
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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class AnimeListAnime(
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("title") val title: String = "",
	@SerialName("video_url") val video_url: String = "",
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("type") override val type: String = "",
	@SerialName("watching_status") val watching_status: Int = 0,
	@SerialName("score") val score: Int = 0,
	@SerialName("watched_episodes") val watched_episodes: Int = 0,
	@SerialName("total_episodes") val total_episodes: Int = 0,
	@SerialName("airing_status") val airing_status: Int = 0,
	@SerialName("season_name") val season_name: String = "",
	@SerialName("season_year") val season_year: String = "",
	@SerialName("has_episode_video") val has_episode_video: Boolean = false,
	@SerialName("has_promo_video") val has_promo_video: Boolean = false,
	@SerialName("has_video") val has_video: Boolean = false,
	@SerialName("is_rewatching") val is_rewatching: Boolean = false,
	@SerialName("tags") val tags: String = "",
	@SerialName("rating") val rating: String = "",
	@SerialName("start_date") override val startDate: String = "",
	@SerialName("end_date") override val endDate: String = "",
	@SerialName("watch_start_date") val watch_start_date: String = "",
	@SerialName("watch_end_date") val watch_end_date: String = "",
	@SerialName("days") val days: String = "",
	@SerialName("storage") val storage: String = "",
	@SerialName("priority") val priority: String = "",
	@SerialName("added_to_list") val added_to_list: Boolean = false,
	@SerialName("studios") val studios: List<Studios>,
	@SerialName("licensors") val licensors: List<Licensors>
) : MyAnimeListID, MyAnimeListURL, MyAnimeListImageURL, MyAnimeListType,
	MyAnimeListStartEndDate, MyAnimeListAnimeType