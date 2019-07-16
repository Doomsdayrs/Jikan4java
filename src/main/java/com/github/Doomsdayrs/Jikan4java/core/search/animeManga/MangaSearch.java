package com.github.Doomsdayrs.Jikan4java.core.search.animeManga;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.genres.MangaGenres;
import com.github.Doomsdayrs.Jikan4java.enums.search.Types;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.Ratings;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.orderBy.MangaOrderBy;
import com.github.Doomsdayrs.Jikan4java.enums.status.MangaStati;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.MangaPage.MangaPage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

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
 * 13 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaSearch extends AnimeMangaSearch<MangaPage> {

    public MangaSearch() {
        super(Types.MANGA);
    }

    public MangaSearch(ObjectMapper mapper) {
        super(Types.MANGA, mapper);
    }

    public MangaSearch(Types type, OkHttpClient client) {
        super(type, client);
    }

    public MangaSearch(Types type, JSONParser jsonParser) {
        super(type, jsonParser);
    }

    public MangaSearch(Types type, Request.Builder builder) {
        super(type, builder);
    }


    public MangaSearch addGenre(MangaGenres mangaGenres) {
        super.addGenre(mangaGenres);
        return this;
    }

    @Override
    public CompletableFuture<Manga> getFirst() {
        return (CompletableFuture<Manga>) super.getFirst();
    }

    @Override
    public MangaSearch setPage(int page) {
        super.setPage(page);
        return this;
    }

    @Override
    public MangaSearch setQuery(String title) {
        super.setQuery(title);
        return this;
    }

    public MangaSearch setStatus(MangaStati status) {
        super.setStatus(status);
        return this;
    }

    @Override
    public MangaSearch setRating(Ratings rating) {
        super.setRating(rating);
        return this;
    }

    @Override
    public MangaSearch setScore(float score) {
        super.setScore(score);
        return this;
    }

    @Override
    public MangaSearch toggleGenres() {
        super.toggleGenres();
        return this;
    }

    @Override
    public MangaSearch setLimit(int pages) {
        super.setLimit(pages);
        return this;
    }

    @Override
    public MangaSearch setStartDate(int yyyy, int mm, int dd) {
        super.setStartDate(yyyy, mm, dd);
        return this;
    }

    @Override
    public MangaSearch setEndDate(int yyyy, int mm, int dd) {
        super.setEndDate(yyyy, mm, dd);
        return this;
    }

    public MangaSearch orderBy(MangaOrderBy orderBy) {
        super.orderBy(orderBy);
        return this;
    }

    @Override
    public MangaSearch sortBy(SortBy sortBy) {
        super.sortBy(sortBy);
        return this;
    }

    @Override
    public CompletableFuture<Manga> getByID(int id) {
        return super.getByID(id);
    }
}
