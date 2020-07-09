package com.github.doomsdayrs.jikan4java.data.model.main.user.listing.mangalist

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
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
		@field:JsonProperty("mal_id") var mal_id: Int = 0,
		@field:JsonProperty("title") var title: String? = null,
		@field:JsonProperty("url") var url: String? = null,
		@field:JsonProperty("image_url") var image_url: String? = null,
		@field:JsonProperty("type") var type: String? = null,
		@field:JsonProperty("reading_status") var reading_status: Int = 0,
		@field:JsonProperty("score") var score: Int = 0,
		@field:JsonProperty("read_chapters") var read_chapters: Int = 0,
		@field:JsonProperty("read_volumes") var read_volumes: Int = 0,
		@field:JsonProperty("total_chapters") var total_chapters: Int = 0,
		@field:JsonProperty("total_volumes") var total_volumes: Int = 0,
		@field:JsonProperty("publishing_status") var publishing_status: Int = 0,
		@field:JsonProperty("is_rereading") var is_rereading: Boolean = false,//This will become an error in the future, well. Ill be given a user tag that i can use
		@field:JsonProperty("tags") var tags: ArrayList<String>? = null,
		@field:JsonProperty("start_date") var start_date: String? = null,
		@field:JsonProperty("end_date") var end_date: String? = null,
		@field:JsonProperty("read_start_date") var read_start_date: String? = null,
		@field:JsonProperty("read_end_date") var read_end_date: String? = null,//Not sure of this
		@field:JsonProperty("days") var days: Int = 0,//Also unsure
		@field:JsonProperty("retail") var retail: String? = null,
		@field:JsonProperty("priority") var priority: String? = null,
		@field:JsonProperty("added_to_list") var added_to_list: Boolean = false,//This will become an error in the future, well. Ill be given a user tag that i can use
		@field:JsonProperty("magazines") var magazines: ArrayList<Magazine>? = null
) : Retriever() {

	/**
	 * Returns the Manga object of this object
	 *
	 * @return Manga Object
	 */
	val manga by lazy { retrieve<Manga>("$baseURL/manga/$mal_id") }
}