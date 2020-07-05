package com.github.doomsdayrs.jikan4java.model.support.userupdate.manga

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.model.support.userupdate.UserUpdate

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
		@JsonProperty("username") override var username: String?,
		@JsonProperty("url") override var url: String?,
		@JsonProperty("image_url") override var image_url: String?,
		@JsonProperty("score") override var scores: Int,
		@JsonProperty("status") override var status: String?,
		@JsonProperty("chapters_read") var chapters_seen: Int,
		@JsonProperty("volumes_read") var volumes_seen: Int,
		@JsonProperty("chapters_total") var episodes_total: Int,
		@JsonProperty("volumes_total") var volumes_total: Int,
		@JsonProperty("date") override val date: String?
) : UserUpdate