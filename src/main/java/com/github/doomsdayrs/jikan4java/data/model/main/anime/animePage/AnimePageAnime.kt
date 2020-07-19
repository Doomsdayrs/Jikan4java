package com.github.doomsdayrs.jikan4java.data.model.main.anime.animePage

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListEpisodeCount
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListScore
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListSource
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.data.model.support.searchResults.ContentPage

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
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
data class AnimePageAnime(
		@JsonProperty("mal_id") override val malID: Int,
		@JsonProperty("url") override val url: String,
		@JsonProperty("image_url") override val imageURL: String = "",
		@JsonProperty("title") override val title: String,
		@JsonProperty("synopsis") override val synopsis: String?,
		@JsonProperty("type") override val type: String?,
		@JsonProperty("score") override val score: Double,
		@JsonProperty("start_date") override val startDate: String?,
		@JsonProperty("end_date") override val end_date: String?,
		@JsonProperty("members") override val members: Int,
		@JsonProperty("airing") val airing: Boolean,
		@JsonProperty("episodes") override val episodeCount: Int,
		@JsonProperty("source") override val source: String,
		@JsonProperty("rated") val rated: String
) : ContentPage(), MyAnimeListSource, MyAnimeListEpisodeCount, MyAnimeListScore {
	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	val anime by lazy { retrieve<Anime>(jikanURL + "anime/" + malID) }
}