package com.github.doomsdayrs.jikan4java.core.userlisting;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.enums.SortBy;
import com.github.doomsdayrs.jikan4java.enums.userlistings.filters.UserListFilters;
import com.github.doomsdayrs.jikan4java.enums.userlistings.orderby.ListOrderBy;
import com.github.doomsdayrs.jikan4java.enums.userlistings.status.ListingStati;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

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
 * 21 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
class UserListingSearch<T> extends Retriever {
    protected String username;
    protected String query = null;
    protected int page = 0;
    protected ListOrderBy orderBy = null;
    private UserListFilters userListFilters = null;
    private SortBy sortBy = null;
    private ListOrderBy orderBy2 = null;
    /** @noinspection FieldCanBeLocal*/
    private ListingStati listingStati = null;

    UserListingSearch(String username) {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
        this.username = username;
    }

    UserListingSearch(OkHttpClient client, String username) {
        super(client);
        this.username = username;
    }

    UserListingSearch(ObjectMapper objectMapper, String username) {
        super(objectMapper);
        this.username = username;
    }

    UserListingSearch(JSONParser jsonParser, String username) {
        super(jsonParser);
        this.username = username;
    }

    UserListingSearch(Request.Builder builder, String username) {
        super(builder);
        this.username = username;
    }
    protected int[] from = null;
    protected int[] to = null;

    public UserListingSearch<T> setQuery(String query) {
        this.query = query;
        return this;
    }

    public UserListingSearch<T> setPage(int page) {
        this.page = page;
        return this;
    }

    public UserListingSearch<T> setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public UserListingSearch<T> setOrderBy(ListOrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public UserListingSearch<T> setOrderBy2(ListOrderBy orderBy2) {
        this.orderBy2 = orderBy2;
        return this;
    }

    public UserListingSearch<T> setFrom(int yyyy, int mm, int dd) {
        this.from = new int[]{yyyy, mm, dd};
        return this;
    }

    public UserListingSearch<T> setTo(int yyyy, int mm, int dd) {
        this.to = new int[]{yyyy, mm, dd};
        return this;
    }

    public UserListingSearch<T> setFrom(int[] from) {
        this.from = from;
        return this;
    }

    public UserListingSearch<T> setTo(int[] to) {
        this.to = to;
        return this;
    }

    UserListingSearch<T> setListingStati(ListingStati listingStati) {
        this.listingStati = listingStati;
        return this;
    }

    /**
     * This must be set, or will return null on getList
     *
     * @param userListFilters The type of list you wish, and what filtering. Default with all
     * @return this
     */
    public UserListingSearch<T> setUserListFilters(UserListFilters userListFilters) {
        this.userListFilters = userListFilters;
        return this;
    }


    public UserListingSearch<T> setUsername(String username) {
        this.username = username;
        return this;
    }


    protected StringBuilder createURL() {
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
        return options;
    }
}