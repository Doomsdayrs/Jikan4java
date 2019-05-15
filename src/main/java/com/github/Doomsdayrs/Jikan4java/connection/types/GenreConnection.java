package com.github.Doomsdayrs.Jikan4java.connection.types;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.connection.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Anime.GenreSearchAnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga.GenreSearchMangaPage;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.AnimeGenres;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.Genres;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.MangaGenres;

import java.util.concurrent.CompletableFuture;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class GenreConnection<T> extends Retriever {


    /**
     * Constructor, Use GenreSearchMangaPage or GenreSearchAnimePage as type parameters
     */
    public GenreConnection() {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
    }


    /**
     * Searches for Anime/manga by genre, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    public CompletableFuture<GenreSearchAnimePage> searchGenre(AnimeGenres genreID) {
        return (CompletableFuture<GenreSearchAnimePage>) searchGenrePage(genreID, 1);
    }

    /**
     * Searches for Anime/manga by genre, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID) {
        return (CompletableFuture<GenreSearchMangaPage>) searchGenrePage(genreID, 1);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchAnimePage> searchGenre(AnimeGenres genreID, int page) {
        return (CompletableFuture<GenreSearchAnimePage>) searchGenrePage(genreID, page);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID, int page) {
        return (CompletableFuture<GenreSearchMangaPage>) searchGenrePage(genreID, page);

    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<T> searchGenrePage(Genres genreID, int page) {
        return retrieve(GenreSearchAnimePage.class, baseURL + "/genre/" + genreID.getType() + "/" + genreID.getId() + "/" + page);
    }




    /**
     * Searches for manga by ID, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchAnimePage
     */
    @Deprecated
    public CompletableFuture<GenreSearchMangaPage> searchMangaGenre(MangaGenres genreID) {
        return searchMangaGenre(genreID, 1);
    }

    /**
     * Searches for anime by ID, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    @Deprecated
    public CompletableFuture<GenreSearchAnimePage> searchAnimeGenre(AnimeGenres genreID) {
        return searchAnimeGenre(genreID, 1);
    }


    /**
     * Searches for manga by ID, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    @Deprecated
    public CompletableFuture<GenreSearchMangaPage> searchMangaGenre(MangaGenres genreID, int page) {
        return retrieve(GenreSearchAnimePage.class, baseURL + "/genre/anime/" + genreID.getId() + "/" + page);
    }

    /**
     * Searches for anime by ID, there are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    the page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchMangaPage
     */
    @Deprecated
    public CompletableFuture<GenreSearchAnimePage> searchAnimeGenre(AnimeGenres genreID, int page) {
        return retrieve(GenreSearchMangaPage.class, baseURL + "/genre/manga/" + genreID.getId() + "/" + page);
    }

}
