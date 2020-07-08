package com.github.doomsdayrs.jikan4java.model.main.anime.characterStaff

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.model.support.VoiceActors
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
 * ====================================================================
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
class AnimeCharacter(
		@field:JsonProperty("mal_id") val mal_id: Int = 0,
		@field:JsonProperty("url") val url: String? = null,
		@field:JsonProperty("image_url") val image_url: String? = null,
		@field:JsonProperty("name") val name: String? = null,
		@field:JsonProperty("role") val role: String? = null,
		@field:JsonProperty("voice_actors") val voice_actors: ArrayList<VoiceActors>? = null
)