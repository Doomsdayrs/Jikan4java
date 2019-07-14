package com.github.Doomsdayrs.Jikan4java.core.userListing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.enums.Season;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.userListings.filters.UserListFilters;
import com.github.Doomsdayrs.Jikan4java.enums.userListings.orderBy.ListOrderBy;
import com.github.Doomsdayrs.Jikan4java.enums.userListings.status.AnimeListingStati;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.AnimeList.AnimeList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

import java.util.concurrent.CompletableFuture;

/*
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see https://www.gnu.org/licenses/.
 * ====================================================================
 * Jikan4java
 * 25 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class AnimeUserListingSearch extends UserListingSearch<AnimeList> {
    private int producer = 0;
    private int year = 0;
    private Season season = null;

    public AnimeUserListingSearch(String username) {
        super(username);
    }

    public AnimeUserListingSearch(OkHttpClient client, String username) {
        super(client, username);
    }


    public AnimeUserListingSearch(ObjectMapper objectMapper, String username) {
        super(objectMapper, username);
    }

    public AnimeUserListingSearch(JSONParser jsonParser, String username) {
        super(jsonParser, username);
    }

    public AnimeUserListingSearch(Request.Builder builder, String username) {
        super(builder, username);
    }

    public AnimeUserListingSearch setProducer(int producer) {
        this.producer = producer;
        return this;
    }

    public AnimeUserListingSearch setYear(int year) {
        this.year = year;
        return this;
    }

    public AnimeUserListingSearch setSeason(Season season) {
        this.season = season;
        return this;
    }

    @Override
    public AnimeUserListingSearch setQuery(String query) {
        super.setQuery(query);
        return this;
    }

    @Override
    public AnimeUserListingSearch setPage(int page) {
        super.setPage(page);
        return this;
    }

    @Override
    public AnimeUserListingSearch setSortBy(SortBy sortBy) {
        super.setSortBy(sortBy);
        return this;
    }

    @Override
    public AnimeUserListingSearch setOrderBy(ListOrderBy orderBy) {
        super.setOrderBy(orderBy);
        return this;
    }

    @Override
    public AnimeUserListingSearch setOrderBy2(ListOrderBy orderBy2) {
        super.setOrderBy2(orderBy2);
        return this;
    }

    @Override
    public AnimeUserListingSearch setFrom(int yyyy, int mm, int dd) {
        super.setFrom(yyyy, mm, dd);
        return this;
    }

    @Override
    public AnimeUserListingSearch setTo(int yyyy, int mm, int dd) {
        super.setTo(yyyy, mm, dd);
        return this;
    }

    @Override
    public AnimeUserListingSearch setFrom(int[] from) {
        super.setFrom(from);
        return this;
    }

    @Override
    public AnimeUserListingSearch setTo(int[] to) {
        super.setTo(to);
        return this;
    }

    public AnimeUserListingSearch setListingStati(AnimeListingStati listingStati) {
        super.setListingStati(listingStati);
        return this;
    }

    @Override
    public AnimeUserListingSearch setUserListFilters(UserListFilters userListFilters) {
        super.setUserListFilters(userListFilters);
        return this;
    }

    @Override
    public AnimeUserListingSearch setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    protected StringBuilder createURL() {
        StringBuilder stringBuilder = super.createURL();
        if (producer != 0)
            stringBuilder.append("&producer=").append(producer);
        if (year != 0)
            stringBuilder.append("&year=").append(year);
        if (season != null)
            stringBuilder.append("&season=").append(season);
        return stringBuilder;
    }

    protected CompletableFuture<AnimeList> getList() {
        return retrieve(AnimeList.class, baseURL + "/user/" + username + this.createURL());
    }
}
