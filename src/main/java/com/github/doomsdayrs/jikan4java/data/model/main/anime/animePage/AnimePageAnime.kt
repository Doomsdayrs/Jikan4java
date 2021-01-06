package com.github.doomsdayrs.jikan4java.data.model.main.anime.animePage

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListEpisodeCount
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListScore
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListSource
import com.github.doomsdayrs.jikan4java.data.model.support.searchResults.ContentPage
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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class AnimePageAnime(
	@SerialName("mal_id") override val malID: Int,
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("title") override val title: String,
	@SerialName("synopsis") override val synopsis: String?,
	@SerialName("type") override val type: String?,
	@SerialName("score") override val score: Double,
	@SerialName("start_date") override val startDate: String?,
	@SerialName("end_date") override val endDate: String?,
	@SerialName("members") override val members: Int,
	@SerialName("airing") val airing: Boolean,
	@SerialName("episodes") override val episodeCount: Int,
	@SerialName("source") override val source: String?,
	@SerialName("rated") val rated: String
) : ContentPage(), MyAnimeListSource, MyAnimeListEpisodeCount,
	MyAnimeListScore