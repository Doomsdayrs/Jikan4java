package com.github.doomsdayrs.jikan4java.model.main.top.model.character

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.model.main.manga.Manga
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
 * ====================================================================
 * Jikan4java
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class TopCharacterManga(
		@field:JsonProperty("mal_id") var mal_id: Int,
		@field:JsonProperty("type") var type: String?,
		@field:JsonProperty("name") var name: String?,
		@field:JsonProperty("url") var url: String?
) : Retriever() {

	/**
	 * Returns the Manga object of this object
	 *
	 * @return Manga Object
	 */
	val manga: CompletableFuture<Manga> by lazy { retrieve<Manga>("$baseURL/manga/$mal_id") }
}