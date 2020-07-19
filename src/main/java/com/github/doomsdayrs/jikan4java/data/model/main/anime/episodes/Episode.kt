package com.github.doomsdayrs.jikan4java.data.model.main.anime.episodes

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListTitle

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
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
class Episode(
		@field:JsonProperty("episode_id") val episode_id: Int = 0,
		@field:JsonProperty("title") override val title: String,
		@field:JsonProperty("title_japanese") val title_japanese: String? = null,
		@field:JsonProperty("title_romanji") val title_romanji: String? = null,
		@field:JsonProperty("aired") val aired: String? = null,
		@field:JsonProperty("filler") val filler: Boolean = false,
		@field:JsonProperty("recap") val recap: Boolean = false,
		@field:JsonProperty("video_url") val video_url: String? = null,
		@field:JsonProperty("forum_url") val forum_url: String? = null
) : MyAnimeListTitle