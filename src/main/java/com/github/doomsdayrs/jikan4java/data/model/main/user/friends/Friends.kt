package com.github.doomsdayrs.jikan4java.data.model.main.user.friends

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL
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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class Friends(
	@SerialName("url") override val url: String,
	@SerialName("username") val username: String = "",
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("last_online") val last_online: String = "",
	@SerialName("friends_since") val friends_since: String = ""
) : MyAnimeListURL, MyAnimeListImageURL