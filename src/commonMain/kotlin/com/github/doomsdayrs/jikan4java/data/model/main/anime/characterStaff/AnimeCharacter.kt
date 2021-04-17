@file:Suppress("unused", "unused", "unused", "unused")

package com.github.doomsdayrs.jikan4java.data.model.main.anime.characterStaff

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListName
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.model.support.VoiceActors
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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class AnimeCharacter(
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("name") override val name: String,
	@SerialName("role") val role: String? = null,
	@SerialName("voice_actors") val voiceActors: List<VoiceActors> = arrayListOf()
) : MyAnimeListID, MyAnimeListURL, MyAnimeListImageURL, MyAnimeListName {

	@Suppress("PropertyName")
	@Deprecated("Changed to proper naming format", ReplaceWith("voiceActors"))
	val voice_actors: List<VoiceActors>
		get() = voiceActors
}