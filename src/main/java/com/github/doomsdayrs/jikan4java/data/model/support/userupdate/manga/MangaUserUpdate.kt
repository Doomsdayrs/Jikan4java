package com.github.doomsdayrs.jikan4java.data.model.support.userupdate.manga

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.UserUpdate

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
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
data class MangaUserUpdate(
		@JsonProperty("username") override val username: String = "",
		@JsonProperty("url") override val url: String,
		@JsonProperty("image_url") override val imageURL: String = "",
		@JsonProperty("score") override val scores: Int,
		@JsonProperty("status") override val status: String = "",
		@JsonProperty("chapters_read") val chapters_seen: Int,
		@JsonProperty("volumes_read") val volumes_seen: Int,
		@JsonProperty("chapters_total") val episodes_total: Int,
		@JsonProperty("volumes_total") val volumes_total: Int,
		@JsonProperty("date") override val date: String = ""
) : UserUpdate