package com.github.doomsdayrs.jikan4java.data.model.main.magazine

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.base.*
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Authors
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre

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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
class Magazine(
		@field:JsonProperty("mal_id") override val malID: Int = 0,
		@field:JsonProperty("url") override val url: String,
		@field:JsonProperty("title") override val title: String,
		@field:JsonProperty("image_url") override val imageURL: String = "",
		@field:JsonProperty("synopsis") val synopsis: String = "",
		@field:JsonProperty("type") override val type: String = "",
		@field:JsonProperty("publishing_start") override val publishingStart: String = "",
		@field:JsonProperty("volumes") val volumes: Int = 0,
		@field:JsonProperty("members") val members: Int = 0,
		@field:JsonProperty("genres") override val genres: List<Genre>,
		@field:JsonProperty("authors") val authors: List<Authors>,
		@field:JsonProperty("score") override val score: Double,
		@field:JsonProperty("serialization") val serializations: List<String>
) :
		MyAnimeListID,
		MyAnimeListURL,
		MyAnimeListTitle,
		MyAnimeListImageURL, MyAnimeListType, MyAnimeListPublishingStart, MyAnimeListScore, MyAnimeListGenres