package com.github.doomsdayrs.jikan4java.data.model.main.top.model.character

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListName
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListType
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.base.type.MyAnimeListAnimeType
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
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class TopCharacterAnime(
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("type") override val type: String? = null,
	@SerialName("name") override val name: String,
	@SerialName("url") override val url: String
) : MyAnimeListID, MyAnimeListType, MyAnimeListName, MyAnimeListURL,
	MyAnimeListAnimeType