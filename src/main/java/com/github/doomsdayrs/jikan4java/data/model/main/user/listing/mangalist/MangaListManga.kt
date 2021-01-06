package com.github.doomsdayrs.jikan4java.data.model.main.user.listing.mangalist

import com.github.doomsdayrs.jikan4java.data.base.type.MyAnimeListMangaType
import com.github.doomsdayrs.jikan4java.data.base.values.*
import com.github.doomsdayrs.jikan4java.data.model.main.magazine.Magazine
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
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class MangaListManga(
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("title") override val title: String,
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("type") override val type: String = "",
	@SerialName("reading_status") val reading_status: Int = 0,
	@SerialName("score") val score: Int = 0,
	@SerialName("read_chapters") val read_chapters: Int = 0,
	@SerialName("read_volumes") val read_volumes: Int = 0,
	@SerialName("total_chapters") val total_chapters: Int = 0,
	@SerialName("total_volumes") val total_volumes: Int = 0,
	@SerialName("publishing_status") val publishing_status: Int = 0,
	@SerialName("is_rereading") val is_rereading: Boolean = false,//This will become an error in the future, well. Ill be given a user tag that i can use
	@SerialName("tags") val tags: List<String>,
	@SerialName("start_date") override val startDate: String = "",
	@SerialName("end_date") override val endDate: String = "",
	@SerialName("read_start_date") val read_start_date: String = "",
	@SerialName("read_end_date") val read_end_date: String = "",//Not sure of this
	@SerialName("days") val days: Int = 0,//Also unsure
	@SerialName("retail") val retail: String = "",
	@SerialName("priority") val priority: String = "",
	@SerialName("added_to_list") val added_to_list: Boolean = false,//This will become an error in the future, well. Ill be given a user tag that i can use
	@SerialName("magazines") val magazines: List<Magazine>?
) :
	MyAnimeListID,
	MyAnimeListTitle,
	MyAnimeListURL,
	MyAnimeListImageURL,
	MyAnimeListType,
	MyAnimeListStartEndDate, MyAnimeListMangaType