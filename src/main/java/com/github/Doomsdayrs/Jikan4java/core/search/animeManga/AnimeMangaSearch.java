package com.github.Doomsdayrs.Jikan4java.core.search.animeManga;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.core.search.Search;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.genres.Genres;
import com.github.Doomsdayrs.Jikan4java.enums.search.Types;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.Ratings;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.orderBy.OrderBy;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.subType.SubTypes;
import com.github.Doomsdayrs.Jikan4java.enums.status.Stati;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

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
class AnimeMangaSearch<T> extends Search<T> {
    protected int page = 0;
    protected SubTypes subTypes = null;
    protected Stati status = null;
    protected int[] startDate = null;
    protected ArrayList<Integer> genres = null;
    protected float score = 0;
    protected int[] endDate = null;
    private Ratings rating = null;
    private boolean genreToggle = true;
    private OrderBy orderBy = null;
    private SortBy sortBy = null;

    AnimeMangaSearch(Types type) {
        super(type);
    }

    AnimeMangaSearch(Types type, ObjectMapper mapper) {
        super(type, mapper);
    }

    public AnimeMangaSearch(Types type, OkHttpClient client) {
        super(type, client);
    }

    public AnimeMangaSearch(Types type, JSONParser jsonParser) {
        super(type, jsonParser);
    }

    public AnimeMangaSearch(Types type, Request.Builder builder) {
        super(type, builder);
    }

    /**
     * Creates the URL, but with addons respective of this class
     *
     * @return StringBuilder so far
     */
    protected StringBuilder createURL() {
        StringBuilder builder = super.createURL();
        if (page != 0) builder.append("&page=").append(page);
        if (subTypes != null) builder.append("&type=").append(subTypes);
        if (status != null) builder.append("&status=").append(status);
        if (rating != null) builder.append("&rated=").append(rating);
        if (genres != null) {
            builder.append("&genre=");
            for (Integer integer : genres)
                builder.append(integer.intValue()).append(",");
            builder.replace(builder.lastIndexOf(","), builder.lastIndexOf(",") + 1, "");
            System.out.println(builder.toString());
        }
        if (!genreToggle) builder.append("&genre_exclude=").append(0);
        if (score != 0) builder.append("&score=").append(score);
        if (orderBy != null) builder.append("&order_by=").append(orderBy);
        if (sortBy != null) builder.append("&sort=").append(sortBy);
        return builder;
    }

    /**
     * Gets the first result in list provided as its own object:
     * AnimePage = anime,
     * MangaPage = manga,
     *
     * @return Completable future of the process
     */
    @Override
    public CompletableFuture getFirst() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                ResponseBody responseBody = super.request(createURL().toString());
                JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody.string());
                JSONArray jsonArray = (JSONArray) jsonObject.get("results");
                // Gets anime ID then goes to it's page
                Request request = new Request.Builder().url(baseURL + "/" + type + "/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
                Response response = client.newCall(request).execute();
                if (response.body() != null)
                    return objectMapper.readValue(((JSONObject) jsonParser.parse(response.body().string())).toJSONString(), type.getB());
                else return null;
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });
    }

    /**
     * Gets the page
     *
     * @return Completable future of the process
     */
    @Override
    public CompletableFuture<T> get() {
        return retrieve(aClass, createURL().toString());
    }

    /**
     * Returns page count
     *
     * @return page count
     */
    public int getPage() {
        return page;
    }

    /**
     * Current state of genre
     *
     * @return genre inclusion state
     */
    public boolean isGenreToggle() {
        return genreToggle;
    }

    public void removeStartDate() {
        this.startDate = null;
    }

    public void removeEndDate() {
        this.endDate = null;
    }


    /**
     * Sets query
     *
     * @param title Title or name of what you want
     * @return This
     */
    @Override
    public AnimeMangaSearch<T> setQuery(String title) {
        super.setQuery(title);
        return this;
    }

    /**
     * Set page to core through
     *
     * @param page page number
     * @return this
     */
    public AnimeMangaSearch<T> setPage(int page) {
        this.page = page;
        return this;
    }

    public AnimeMangaSearch<T> setType(SubTypes subTypes) {
        this.subTypes = subTypes;
        return this;
    }

    /**
     * What status should results have?
     *
     * @param status Status
     * @return this
     */
    public AnimeMangaSearch<T> setStatus(Stati status) {
        this.status = status;
        return this;
    }

    /**
     * What rating should results have?
     *
     * @param rating Rating
     * @return this
     */
    public AnimeMangaSearch<T> setRating(Ratings rating) {
        this.rating = rating;
        return this;
    }

    /**
     * Adds genres to queue
     *
     * @param genre Genre ID
     * @return this
     */
    protected AnimeMangaSearch<T> addGenre(Genres genre) {
        if (genres == null)
            genres = new ArrayList<>();
        genres.add(genre.getId());
        return this;
    }

    /**
     * Sets score that results will have
     *
     * @param score score, IE 5.9
     * @return this
     */
    public AnimeMangaSearch<T> setScore(float score) {
        this.score = score;
        return this;
    }

    public AnimeMangaSearch<T> setStartDate(int yyyy, int mm, int dd) {
        this.startDate = new int[]{yyyy, mm, dd};
        return this;
    }

    public AnimeMangaSearch<T> setEndDate(int yyyy, int mm, int dd) {
        this.endDate = new int[]{yyyy, mm, dd};
        return this;
    }

    /**
     * Toggles if the genres should be included or excluded. Default is included
     *
     * @return this
     */
    public AnimeMangaSearch<T> toggleGenres() {
        genreToggle = !genreToggle;
        return this;
    }

    /**
     * Limit of results per page
     *
     * @param limit how many results per page
     * @return this
     */
    @Override
    public AnimeMangaSearch<T> setLimit(int limit) {
        super.setLimit(limit);
        return this;
    }

    public AnimeMangaSearch<T> orderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public AnimeMangaSearch<T> sortBy(SortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }


}
