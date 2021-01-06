package com.github.doomsdayrs.jikan4java.data.enums.genres

import com.github.doomsdayrs.jikan4java.common.JCompletableFuture
import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.genreSearch.GenreSearchPage
import com.github.doomsdayrs.jikan4java.data.base.genreSearch.GenreSearchPageResult

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
 * 14 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
interface Genres<R : GenreSearchPageResult, T : GenreSearchPage<R>> {
	val id: Int
	val type: String

	fun search(retriever: Retriever, page: Int): JCompletableFuture<T>
}

/**
 * Searches for Anime/manga by genre,
 * There are more than one page since each page has a hundred entries max.
 *
 * @param page    The page number to go to,
 * 1 should be the default unless you know else wise
 * @return GenreSearchAnimePage
 */
inline fun <reified R, reified T> Genres<R, T>.iSearch(
	retriever: Retriever,
	page: Int
) where R : GenreSearchPageResult, T : GenreSearchPage<R> =
	retriever<T>("$JIKAN_URL/genre/${type}/${id}/$page")