package com.github.Doomsdayrs.Jikan4java.core.search.animeManga;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.genres.AnimeGenres;
import com.github.Doomsdayrs.Jikan4java.enums.search.Types;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.Ratings;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.orderBy.AnimeOrderBy;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.subType.SubTypes;
import com.github.Doomsdayrs.Jikan4java.enums.status.AnimeStati;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage.AnimePage;
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
public class AnimeSearch extends AnimeMangaSearch<AnimePage> {

    public AnimeSearch() {
        super(Types.ANIME);
    }

    public AnimeSearch(ObjectMapper mapper) {
        super(Types.ANIME, mapper);
    }

    public AnimeSearch(Types type, OkHttpClient client) {
        super(type, client);
    }

    public AnimeSearch(Types type, JSONParser jsonParser) {
        super(type, jsonParser);
    }

    public AnimeSearch(Types type, Request.Builder builder) {
        super(type, builder);
    }

    @Override
    public CompletableFuture<Anime> getFirst() {
        return super.getFirst();
    }

    @Override
    public AnimeSearch setQuery(String title) {
        super.setQuery(title);
        return this;
    }

    @Override
    public AnimeSearch setPage(int page) {
        super.setPage(page);
        return this;
    }

    public AnimeSearch setStatus(AnimeStati status) {
        super.setStatus(status);
        return this;
    }

    @Override
    public AnimeSearch setRating(Ratings rating) {
        super.setRating(rating);
        return this;
    }

    @Override
    public AnimeSearch setScore(float score) {
        super.setScore(score);
        return this;
    }

    @Override
    public AnimeSearch toggleGenres() {
        super.toggleGenres();
        return this;
    }

    @Override
    public AnimeSearch setLimit(int pages) {
        super.setLimit(pages);
        return this;
    }

    public AnimeSearch addGenre(AnimeGenres animeGenres) {
        super.addGenre(animeGenres);
        return this;
    }

    @Override
    public AnimeSearch setStartDate(int yyyy, int mm, int dd) {
        super.setStartDate(yyyy, mm, dd);
        return this;
    }

    @Override
    public AnimeSearch setEndDate(int yyyy, int mm, int dd) {
        super.setEndDate(yyyy, mm, dd);
        return this;
    }


    public AnimeSearch orderBy(AnimeOrderBy orderBy) {
        super.orderBy(orderBy);
        return this;
    }

    @Override
    public AnimeSearch sortBy(SortBy sortBy) {
        super.sortBy(sortBy);
        return this;
    }

    @Override
    public AnimeSearch setType(SubTypes subTypes) {
        super.setType(subTypes);
        return this;
    }

    @Override
    public CompletableFuture<Anime> getByID(int id) {
        return super.getByID(id);
    }
}
