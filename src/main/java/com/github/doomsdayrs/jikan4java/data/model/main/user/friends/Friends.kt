package com.github.doomsdayrs.jikan4java.data.model.main.user.friends

import com.fasterxml.jackson.annotation.JsonProperty

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class Friends(
		@field:JsonProperty("url") var url: String? = null,
		@field:JsonProperty("username") var username: String? = null,
		@field:JsonProperty("image_url") var image_url: String? = null,
		@field:JsonProperty("last_online") var last_online: String? = null,
		@field:JsonProperty("friends_since") var friends_since: String? = null
)