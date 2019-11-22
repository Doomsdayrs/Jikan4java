package com.github.doomsdayrs.jikan4java.core.search;

import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.enums.genres.AnimeGenres;
import com.github.doomsdayrs.jikan4java.enums.genres.Genres;
import com.github.doomsdayrs.jikan4java.enums.genres.MangaGenres;
import com.github.doomsdayrs.jikan4java.types.main.genresearch.anime.GenreSearchAnimePage;
import com.github.doomsdayrs.jikan4java.types.main.genresearch.manga.GenreSearchMangaPage;

import java.util.concurrent.CompletableFuture;

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
public class GenreSearch extends Retriever {
    /**
     * Searches for Anime/manga by genre, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    public CompletableFuture<GenreSearchAnimePage> searchGenre(AnimeGenres genreID) {
        return searchGenrePage(genreID, 1,GenreSearchAnimePage.class);
    }

    /**
     * Searches for Anime/manga by genre, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID) {
        return searchGenrePage(genreID, 1,GenreSearchMangaPage.class);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchAnimePage> searchGenre(AnimeGenres genreID, int page) {
        return searchGenrePage(genreID, page,GenreSearchAnimePage.class);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID, int page) {
        return searchGenrePage(genreID, page,GenreSearchMangaPage.class);

    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture searchGenrePage(Genres genreID, int page, Class c) {
        return retrieve(c, baseURL + "/genre/" + genreID.getType() + "/" + genreID.getId() + "/" + page);
    }
}
