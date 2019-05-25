package com.github.Doomsdayrs.Jikan4java.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.orderBy.OrderBy;
import com.github.Doomsdayrs.Jikan4java.enums.user.userListings.filters.UserListFilters;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

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
 * along with Jikan4java.  If not, see https://www.gnu.org/licenses/.
 * ====================================================================
 * Jikan4java
 * 21 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class UserListingSearch extends Retriever {
    private String username;

    public UserListingSearch(String username) {
        this.username = username;
    }

    public UserListingSearch(OkHttpClient client, String username) {
        super(client);
        this.username = username;
    }

    public UserListingSearch(ObjectMapper objectMapper, String username) {
        super(objectMapper);
        this.username = username;
    }

    public UserListingSearch(JSONParser jsonParser, String username) {
        super(jsonParser);
        this.username = username;
    }

    public UserListingSearch(Request.Builder builder, String username) {
        super(builder);
        this.username = username;
    }


    private UserListFilters userListFilters = null;

    private String query = null;
    private int page = 0;
    private SortBy sortBy = null;

    private OrderBy orderBy = null;
    private OrderBy orderBy2 = null;





    /**
     * Gets an Anime/Manga list from user
     *
     * @param page if 0, returns all. if 1, returns 300 per page
     * @return CompletableFuture
     */
    private CompletableFuture getList(int page, UserListFilters userListFilters, SortBy sortBy, OrderBy orderBy, OrderBy orderBy2) {
        StringBuilder options = new StringBuilder();

        if (userListFilters != null)
            options.append("/").append(userListFilters.getForm()).append("/").append(userListFilters);
        if (page != 0)
            options.append("/").append(page);

        return retrieve(userListFilters.getaClass(), baseURL + "/user/" + username + options);
    }
}

