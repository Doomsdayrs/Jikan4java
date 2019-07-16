package com.github.Doomsdayrs.Jikan4java.core.search;

import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.enums.genres.AnimeGenres;
import com.github.Doomsdayrs.Jikan4java.enums.genres.Genres;
import com.github.Doomsdayrs.Jikan4java.enums.genres.MangaGenres;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Anime.GenreSearchAnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga.GenreSearchMangaPage;

import java.util.concurrent.CompletableFuture;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
        return searchGenrePage(genreID, 1);
    }

    /**
     * Searches for Anime/manga by genre, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID) {
        return searchGenrePage(genreID, 1);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchAnimePage> searchGenre(AnimeGenres genreID, int page) {
        return searchGenrePage(genreID, page);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID, int page) {
        return searchGenrePage(genreID, page);

    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture searchGenrePage(Genres genreID, int page) {
        return retrieve(GenreSearchAnimePage.class, baseURL + "/genre/" + genreID.getType() + "/" + genreID.getId() + "/" + page);
    }
}
