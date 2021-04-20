package com.github.doomsdayrs.jikan4java.data.model.support.userupdate.manga

import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.UserUpdate
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
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class MangaUserUpdate(
	@SerialName("username") override val username: String = "",
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("score") override val scores: Int,
	@SerialName("status") override val status: String = "",
	@SerialName("chapters_read") val chapters_seen: Int,
	@SerialName("volumes_read") val volumes_seen: Int,
	@SerialName("chapters_total") val episodes_total: Int,
	@SerialName("volumes_total") val volumes_total: Int,
	@SerialName("date") override val date: String = ""
) : UserUpdate