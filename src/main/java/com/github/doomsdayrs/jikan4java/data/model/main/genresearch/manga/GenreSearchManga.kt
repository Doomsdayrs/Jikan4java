package com.github.doomsdayrs.jikan4java.data.model.main.genresearch.manga

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListPublishingStart
import com.github.doomsdayrs.jikan4java.data.base.genreSearch.GenreSearchPageResult
import com.github.doomsdayrs.jikan4java.data.model.main.manga.Manga
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Authors
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import java.util.*
import java.util.concurrent.CompletableFuture

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
class GenreSearchManga(
		@field:JsonProperty("mal_id") override val malID: Int = 0,
		@field:JsonProperty("url") override val url: String,
		@field:JsonProperty("title") override val title: String,
		@field:JsonProperty("image_url") override val imageURL: String = "",
		@field:JsonProperty("synopsis") override val synopsis: String = "",
		@field:JsonProperty("type") override val type: String = "",
		@field:JsonProperty("publishing_start") override val publishingStart: String = "",
		@field:JsonProperty("volumes") val volumes: Int = 0,
		@field:JsonProperty("members") override val members: Int = 0,
		@field:JsonProperty("genres") override val genres: List<Genre>,
		@field:JsonProperty("authors") val authors: ArrayList<Authors>,
		@field:JsonProperty("score") override val score: Double,
		@field:JsonProperty("serialization") val serialization: ArrayList<String>
) : Retriever(), GenreSearchPageResult, MyAnimeListPublishingStart {

	/**
	 * Returns the Manga object of this object
	 *
	 * @return Manga Object
	 */
	val manga: CompletableFuture<Manga> by lazy { retrieve<Manga>("$jikanURL/manga/$malID") }
}