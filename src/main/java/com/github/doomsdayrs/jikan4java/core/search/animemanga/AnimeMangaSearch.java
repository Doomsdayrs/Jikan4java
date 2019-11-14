package com.github.doomsdayrs.jikan4java.core.search.animemanga;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.doomsdayrs.jikan4java.core.search.Search;
import com.github.doomsdayrs.jikan4java.enums.SortBy;
import com.github.doomsdayrs.jikan4java.enums.genres.Genres;
import com.github.doomsdayrs.jikan4java.enums.search.Types;
import com.github.doomsdayrs.jikan4java.enums.search.animemanga.Ratings;
import com.github.doomsdayrs.jikan4java.enums.search.animemanga.orderby.OrderBy;
import com.github.doomsdayrs.jikan4java.enums.search.animemanga.subtype.SubTypes;
import com.github.doomsdayrs.jikan4java.enums.status.Stati;
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
        if (startDate != null) builder.append(String.format("&start_date=%02d-%02d-%02d",startDate[0],startDate[1],startDate[2]));
        if (endDate != null) builder.append(String.format("&end_date=%02d-%02d-%02d",endDate[0],endDate[1],endDate[2]));
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
