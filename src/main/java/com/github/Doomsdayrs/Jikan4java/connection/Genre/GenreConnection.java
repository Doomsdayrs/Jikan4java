package com.github.Doomsdayrs.Jikan4java.connection.Genre;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.connection.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Anime.GenreSearchAnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga.GenreSearchMangaPage;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.AnimeGenres;
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
public class GenreConnection extends Retriever {
    /**
     * Constructor
     */
    public GenreConnection() {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
    }

    /**
     * Searches for manga by ID, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchMangaPage> searchMangaGenre(MangaGenres genreID) {
        return searchMangaGenre(genreID, 1);
    }

    /**
     * Searches for anime by ID, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
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
    public CompletableFuture<GenreSearchAnimePage> searchAnimeGenre(AnimeGenres genreID, int page) {
        return retrieve(GenreSearchMangaPage.class, baseURL + "/genre/manga/" + genreID.getId() + "/" + page);
    }

}
