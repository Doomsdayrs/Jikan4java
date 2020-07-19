package com.github.doomsdayrs.jikan4java.data.model.main.character.characterPage

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.data.model.main.character.Character
import com.github.doomsdayrs.jikan4java.data.model.support.searchResults.IndividualsPage
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
 * ====================================================================*/
/**
 * Jikan4java
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
data class CharacterPageCharacter(
		@JsonProperty("mal_id") override val malID: Int,
		@JsonProperty("url") override val url: String,
		@JsonProperty("image_url") override val imageURL: String = "",
		@JsonProperty("name") override val name: String,
		@JsonProperty("alternative_names") override val alternative_names: ArrayList<String>,
		@param:JsonProperty("anime") val animes: ArrayList<PageCharacterAnime>,
		@param:JsonProperty("manga") val mangas: ArrayList<PageCharacterManga>
) : IndividualsPage() {

	/**
	 * Returns the Character object of this object
	 *
	 * @return Character Object
	 */
	val character by lazy { retrieve<Character>("$jikanURL/character/$malID") }
}