package com.github.doomsdayrs.jikan4java.data.model.support.news

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListTitle
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListURL

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
data class Article(
		@JsonProperty("url") override var url: String,
		@JsonProperty("title") override var title: String,
		@JsonProperty("date") var date: String?,
		@JsonProperty("author_name") var author_name: String?,
		@JsonProperty("author_url") var author_url: String?,
		@JsonProperty("forum_url") var forum_url: String?,
		@JsonProperty("image_url") var image_url: String?,
		@JsonProperty("comments") var comments: Int,
		@JsonProperty("intro") var intro: String?
) : MyAnimeListURL, MyAnimeListTitle