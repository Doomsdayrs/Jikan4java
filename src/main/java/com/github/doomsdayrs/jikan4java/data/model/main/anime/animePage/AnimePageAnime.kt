package com.github.doomsdayrs.jikan4java.data.model.main.anime.animePage

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
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
		@JsonProperty("mal_id") override val mal_id: Int,
		@JsonProperty("url") override val url: String?,
		@JsonProperty("image_url") override val image_url: String?,
		@JsonProperty("title") override val title: String?,
		@JsonProperty("synopsis") override val synopsis: String?,
		@JsonProperty("type") override val type: String?,
		@JsonProperty("score") override val score: Double,
		@JsonProperty("start_date") override val start_date: String?,
		@JsonProperty("end_date") override val end_date: String?,
		@JsonProperty("members") override val members: Int,
		@JsonProperty("airing") val airing: Boolean,
		@JsonProperty("episodes") val episodes: Int,
		@JsonProperty("source") val source: String,
		@JsonProperty("rated") val rated: String
) : ContentPage() {
	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	val anime by lazy { retrieve<Anime>(baseURL + "anime/" + mal_id) }
}