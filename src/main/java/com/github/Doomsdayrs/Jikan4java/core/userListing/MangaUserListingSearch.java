package com.github.Doomsdayrs.Jikan4java.core.userListing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.userListings.filters.UserListFilters;
import com.github.Doomsdayrs.Jikan4java.enums.userListings.orderBy.ListOrderBy;
import com.github.Doomsdayrs.Jikan4java.enums.userListings.status.MangaListingStati;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.MangaList.MangaList;
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
 * 25 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaUserListingSearch extends UserListingSearch<MangaList> {
    private int magazine = 0;

    public MangaUserListingSearch(String username) {
        super(username);
    }

    public MangaUserListingSearch(OkHttpClient client, String username) {
        super(client, username);
    }

    public MangaUserListingSearch(ObjectMapper objectMapper, String username) {
        super(objectMapper, username);
    }

    public MangaUserListingSearch(JSONParser jsonParser, String username) {
        super(jsonParser, username);
    }

    public MangaUserListingSearch(Request.Builder builder, String username) {
        super(builder, username);
    }

    public MangaUserListingSearch setMagazine(int magazine) {
        this.magazine = magazine;
        return this;
    }

    @Override
    public MangaUserListingSearch setQuery(String query) {
        super.setQuery(query);
        return this;
    }

    @Override
    public MangaUserListingSearch setPage(int page) {
        super.setPage(page);
        return this;
    }

    @Override
    public MangaUserListingSearch setSortBy(SortBy sortBy) {
        super.setSortBy(sortBy);
        return this;
    }

    @Override
    public MangaUserListingSearch setOrderBy(ListOrderBy orderBy) {
        super.setOrderBy(orderBy);
        return this;
    }

    @Override
    public MangaUserListingSearch setOrderBy2(ListOrderBy orderBy2) {
        super.setOrderBy2(orderBy2);
        return this;
    }

    @Override
    public MangaUserListingSearch setFrom(int yyyy, int mm, int dd) {
        super.setFrom(yyyy, mm, dd);
        return this;
    }

    @Override
    public MangaUserListingSearch setTo(int yyyy, int mm, int dd) {
        super.setTo(yyyy, mm, dd);
        return this;
    }

    @Override
    public MangaUserListingSearch setFrom(int[] from) {
        super.setFrom(from);
        return this;
    }

    @Override
    public MangaUserListingSearch setTo(int[] to) {
        super.setTo(to);
        return this;
    }

    public MangaUserListingSearch setListingStati(MangaListingStati listingStati) {
        super.setListingStati(listingStati);
        return this;
    }

    @Override
    public MangaUserListingSearch setUserListFilters(UserListFilters userListFilters) {
        super.setUserListFilters(userListFilters);
        return this;
    }

    @Override
    public MangaUserListingSearch setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    protected StringBuilder createURL() {
        StringBuilder stringBuilder = super.createURL();
        if (magazine != 0)
            stringBuilder.append("&magazine=").append(magazine);
        return stringBuilder;
    }

    protected CompletableFuture<MangaList> getList() {
        return retrieve(MangaList.class, baseURL + "/user/" + username + this.createURL());
    }
}
