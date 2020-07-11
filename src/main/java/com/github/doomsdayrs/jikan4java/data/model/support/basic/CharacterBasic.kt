package com.github.doomsdayrs.jikan4java.data.model.support.basic

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.data.model.main.character.Character

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
 * 07 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
class CharacterBasic(
		@JsonProperty("mal_id") mal_id: Int,
		@JsonProperty("url") url: String,
		@JsonProperty("image_url") image_url: String?,
		@JsonProperty("name") name: String
) : BasicObject(mal_id, url, image_url, name) {
	/**
	 * Returns the Character object of this object
	 *
	 * @return Character Object
	 */
	val character by lazy { retrieve<Character>("$jikanURL/character/$mal_id") }
}