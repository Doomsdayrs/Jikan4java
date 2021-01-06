package com.github.doomsdayrs.jikan4java.data.model.main.character.characterPage

import com.github.doomsdayrs.jikan4java.data.base.type.MyAnimeListCharacterType
import com.github.doomsdayrs.jikan4java.data.model.support.searchResults.IndividualsPage
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
 * ====================================================================*/
/**
 * Jikan4java
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class CharacterPageCharacter(
	@SerialName("mal_id") override val malID: Int,
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("name") override val name: String,
	@SerialName("alternative_names") override val alternativeNames: List<String>,
	@SerialName("anime") val animes: List<PageCharacterAnime>,
	@SerialName("manga") val mangas: List<PageCharacterManga>
) : IndividualsPage(), MyAnimeListCharacterType