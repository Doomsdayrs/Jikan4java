package com.github.doomsdayrs.jikan4java.data.model.main.genresearch.manga

import com.github.doomsdayrs.jikan4java.data.base.genreSearch.GenreSearchPageResult
import com.github.doomsdayrs.jikan4java.data.base.type.MyAnimeListMangaType
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListPublishingStart
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Authors
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
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
 * ====================================================================
 * Jikan4java
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class GenreSearchManga(
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("url") override val url: String,
	@SerialName("title") override val title: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("synopsis") override val synopsis: String = "",
	@SerialName("type") override val type: String = "",
	@SerialName("publishing_start") override val publishingStart: String = "",
	@SerialName("volumes") val volumes: Int = 0,
	@SerialName("members") override val members: Int = 0,
	@SerialName("genres") override val genres: List<Genre>,
	@SerialName("authors") val authors: List<Authors>,
	@SerialName("score") override val score: Double,
	@SerialName("serialization") val serialization: List<String>
) : GenreSearchPageResult, MyAnimeListPublishingStart, MyAnimeListMangaType