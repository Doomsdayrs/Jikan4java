package com.github.doomsdayrs.jikan4java.model.support.basic

import com.fasterxml.jackson.annotation.JsonProperty
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
 * ====================================================================*/
/**
 * Jikan4java
 * 07 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
class MangaBasic(
		@JsonProperty("mal_id") mal_id: Int,
		@JsonProperty("url") url: String?,
		@JsonProperty("image_url") image_url: String?,
		@JsonProperty("name") name: String?
) : BasicObject(mal_id, url, image_url, name) {
	/**
	 * Returns the Manga object of this object
	 *
	 * @return Manga Object
	 */
	val manga: CompletableFuture<Manga> by lazy { retrieve<Manga>("$baseURL/manga/$mal_id") }
}