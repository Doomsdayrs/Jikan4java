package com.github.doomsdayrs.jikan4java.data.model.main.top.model.character

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.data.model.main.character.Character
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.TopListingBeing
import java.util.*
import java.util.concurrent.CompletableFuture

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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class TopCharacter(
		@JsonProperty("mal_id") override val malID: Int,
		@JsonProperty("rank") override val rank: Int,
		@JsonProperty("title") override val title: String,
		@JsonProperty("url") override val url: String,
		@JsonProperty("favorites") override val favoritesCount: Int,
		@JsonProperty("name_kanji") override val nameKanji: String,
		@JsonProperty("image_url") override val imageURL: String = "",
		@JsonProperty("animeography") var characterAnimes: ArrayList<TopCharacterAnime>?,
		@JsonProperty("mangaography") var characterMangas: ArrayList<TopCharacterManga>?
) : TopListingBeing() {

	/**
	 * Returns the Character object of this object
	 *
	 * @return Character Object
	 */
	val character: CompletableFuture<Character> by lazy { retrieve<Character>("$jikanURL/character/$malID") }
}