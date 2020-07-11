package com.github.doomsdayrs.jikan4java.core.search

import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.core.Retriever
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
class GenreSearch : Retriever() {
	/**
	 * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
	 *
	 * @param genreID The genre ID
	 * @param page    The page number to go to, 0 should be the default unless you know else wise
	 * @return GenreSearchAnimePage
	 */
	@JvmOverloads
	fun searchGenre(genreID: AnimeGenres, page: Int = 0): CompletableFuture<GenreSearchAnimePage> {
		return searchGenrePage(genreID, page, GenreSearchAnimePage::class.java)
	}

	/**
	 * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
	 *
	 * @param genreID The genre ID
	 * @param page    The page number to go to, 0 should be the default unless you know else wise
	 * @return GenreSearchAnimePage
	 */
	@JvmOverloads
	fun searchGenre(genreID: MangaGenres, page: Int = 0): CompletableFuture<GenreSearchMangaPage> {
		return searchGenrePage(genreID, page, GenreSearchMangaPage::class.java)
	}

	/**
	 * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
	 *
	 * @param genreID The genre ID
	 * @param page    The page number to go to, 0 should be the default unless you know else wise
	 * @return GenreSearchAnimePage
	 */
	inline fun <reified T> searchGenrePage(genreID: Genres, page: Int, c: Class<T>): CompletableFuture<T> =
			retrieve(jikanURL + "/genre/" + genreID.type + "/" + genreID.id + "/" + page)
}