package com.github.doomsdayrs.jikan4java.core.search

import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.genreSearch.GenreSearchPage
import com.github.doomsdayrs.jikan4java.data.base.genreSearch.GenreSearchPageResult
import com.github.doomsdayrs.jikan4java.data.enums.genres.AnimeGenres
import com.github.doomsdayrs.jikan4java.data.enums.genres.Genres
import com.github.doomsdayrs.jikan4java.data.enums.genres.MangaGenres
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.anime.GenreSearchAnimePage
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.manga.GenreSearchMangaPage
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
 * 21 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
@Deprecated("Use the methods a genre provides")
class GenreSearch(
	val retriever: Retriever
) {
	@Suppress("MemberVisibilityCanBePrivate")
	@Deprecated(
		"Moved to extension function",
		ReplaceWith("genreID.search(retriever,page)")
	)
	@JvmOverloads
	fun searchGenre(
		genreID: AnimeGenres,
		page: Int = 1
	): CompletableFuture<JikanResult<GenreSearchAnimePage>> =
		genreID.search(retriever, page)

	@Suppress("MemberVisibilityCanBePrivate")
	@Deprecated(
		"Moved to extension function",
		ReplaceWith("genreID.search(retriever,page)")
	)
	@JvmOverloads
	fun searchGenre(
		genreID: MangaGenres,
		page: Int = 1
	): CompletableFuture<JikanResult<GenreSearchMangaPage>> =
		genreID.search(retriever, page)

	@Suppress("MemberVisibilityCanBePrivate", "unused")
	@Deprecated(
		"Moved to extension function",
		ReplaceWith(
			"genreID.search(retriever,page)",
			"com.github.doomsdayrs.jikan4java.data.enums.genres.search"
		)
	)
	inline fun <reified R : GenreSearchPageResult, reified T : GenreSearchPage<R>> searchGenre(
		genreID: Genres<R, T>,
		page: Int
	): CompletableFuture<JikanResult<T>> =
		genreID.search(retriever, page)
}