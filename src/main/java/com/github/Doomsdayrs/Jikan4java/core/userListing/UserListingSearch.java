package com.github.Doomsdayrs.Jikan4java.core.userListing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.status.Stati;
import com.github.Doomsdayrs.Jikan4java.enums.user.userListings.filters.UserListFilters;
import com.github.Doomsdayrs.Jikan4java.enums.user.userListings.orderBy.ListOrderBy;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.AnimeList.AnimeList;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.MangaList.MangaList;
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


    protected UserListFilters userListFilters = null;

    protected String query = null;
    protected int page = 0;
    protected SortBy sortBy = null;

    protected ListOrderBy orderBy = null;
    protected ListOrderBy orderBy2 = null;

    protected int[] from = null;
    protected int[] to = null;

    protected Stati stati = null;
    //AnimeValues


    public UserListingSearch setQuery(String query) {
        this.query = query;
        return this;
    }

    public UserListingSearch setPage(int page) {
        this.page = page;
        return this;
    }

    public UserListingSearch setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public UserListingSearch setOrderBy(ListOrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public UserListingSearch setOrderBy2(ListOrderBy orderBy2) {
        this.orderBy2 = orderBy2;
        return this;
    }


    /**
     * This must be set, or will return null on getList
     *
     * @param userListFilters The type of list you wish, and what filtering. Default with all
     * @return this
     */
    public UserListingSearch setUserListFilters(UserListFilters userListFilters) {
        this.userListFilters = userListFilters;
        return this;
    }


    public UserListingSearch setUsername(String username) {
        this.username = username;
        return this;
    }

    public CompletableFuture<AnimeList> getAnimeList() {
        if (userListFilters.getaClass().equals(AnimeList.class))
            return getList();
        else return null;
    }

    public CompletableFuture<MangaList> getMangaList() {
        if (userListFilters.getaClass().equals(MangaList.class))
            return getList();
        return null;
    }


    /**
     * Gets an Anime/Manga list from user
     *
     * @return CompletableFuture
     */
    private CompletableFuture getList() {
        StringBuilder options = new StringBuilder();

        if (userListFilters != null)
            options.append("/").append(userListFilters.getForm()).append("/").append(userListFilters);
        else return null;
        if (page != 0)
            options.append("/").append(page);
        if (query != null)
            options.append("?q=").append(query);

        boolean ordering = false;
        if (orderBy != null) {
            options.append("&order_by").append(orderBy);
            ordering = true;
        }
        if (orderBy2 != null) {
            options.append("&order_by2").append(orderBy2);
            ordering = true;
        }
        if (ordering)
            if (sortBy != null)
                options.append("&sort=").append(sortBy);


        return retrieve(userListFilters.getaClass(), baseURL + "/user/" + username + options);
    }
}

