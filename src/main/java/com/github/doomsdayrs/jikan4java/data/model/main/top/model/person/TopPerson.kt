package com.github.doomsdayrs.jikan4java.data.model.main.top.model.person

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.model.main.person.Person
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.TopListingBeing
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
data class TopPerson(
		@JsonProperty("mal_id") override val malID: Int,
		@JsonProperty("rank") override val rank: Int,
		@JsonProperty("title") override val title: String,
		@JsonProperty("url") override val url: String,
		@JsonProperty("favorites") override val favorites: Int,
		@JsonProperty("name_kanji") override val nameKanji: String,
		@JsonProperty("image_url") override val imageURL: String,
		@JsonProperty("birthday") val birthday: String? = null
) : TopListingBeing() {
	/**
	 * Returns the Person object of this object
	 *
	 * @return Person Object
	 */
	val person: CompletableFuture<Person> by lazy { retrieve<Person>("$baseURL/person/$malID") }
}