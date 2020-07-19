package com.github.doomsdayrs.jikan4java.data.model.main.user.listing.mangalist

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.*
import com.github.doomsdayrs.jikan4java.data.model.main.magazine.Magazine
import com.github.doomsdayrs.jikan4java.data.model.main.manga.Manga
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
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
data class MangaListManga(
		@JsonProperty("mal_id") override val malID: Int = 0,
		@JsonProperty("title") override val title: String,
		@JsonProperty("url") override val url: String,
		@JsonProperty("image_url") override val imageURL: String? = null,
		@JsonProperty("type") override val type: String? = null,
		@JsonProperty("reading_status") val reading_status: Int = 0,
		@JsonProperty("score") val score: Int = 0,
		@JsonProperty("read_chapters") val read_chapters: Int = 0,
		@JsonProperty("read_volumes") val read_volumes: Int = 0,
		@JsonProperty("total_chapters") val total_chapters: Int = 0,
		@JsonProperty("total_volumes") val total_volumes: Int = 0,
		@JsonProperty("publishing_status") val publishing_status: Int = 0,
		@JsonProperty("is_rereading") val is_rereading: Boolean = false,//This will become an error in the future, well. Ill be given a user tag that i can use
		@JsonProperty("tags") val tags: ArrayList<String>? = null,
		@JsonProperty("start_date") val start_date: String? = null,
		@JsonProperty("end_date") val end_date: String? = null,
		@JsonProperty("read_start_date") val read_start_date: String? = null,
		@JsonProperty("read_end_date") val read_end_date: String? = null,//Not sure of this
		@JsonProperty("days") val days: Int = 0,//Also unsure
		@JsonProperty("retail") val retail: String? = null,
		@JsonProperty("priority") val priority: String? = null,
		@JsonProperty("added_to_list") val added_to_list: Boolean = false,//This will become an error in the future, well. Ill be given a user tag that i can use
		@JsonProperty("magazines") val magazines: ArrayList<Magazine>? = null
) : Retriever(), MyAnimeListID, MyAnimeListTitle, MyAnimeListURL, MyAnimeListImageURL, MyAnimeListType {

	/**
	 * Returns the Manga object of this object
	 *
	 * @return Manga Object
	 */
	val manga by lazy { retrieve<Manga>("$jikanURL/manga/$malID") }
}