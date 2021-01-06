package com.github.doomsdayrs.jikan4java.data.base.type

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.model.main.manga.Manga
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
 */
/**
 * jikan4java
 * 05 / 01 / 2021
 *
 * @author github.com/doomsdayrs
 *
 * A data type that is connected to an [Manga]
 */
interface MyAnimeListMangaType : MyAnimeListID {
	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	@Suppress("unused")
	fun getManga(retriever: Retriever): CompletableFuture<JikanResult<Manga>> =
		retriever("$JIKAN_URL/manga/$malID")
}