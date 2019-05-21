package com.github.Doomsdayrs.Jikan4java.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.enums.user.userListings.filters.AnimeListFilters;
import com.github.Doomsdayrs.Jikan4java.enums.user.userListings.filters.MangaListFilters;
import com.github.Doomsdayrs.Jikan4java.enums.user.userListings.filters.UserListFilters;
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


    //TODO Advanced UserList parameters for anime
    //TODO Advanced userlist parameters for manga


    public CompletableFuture<MangaList> getMangaList(int page) {
        return getList(page, null);
    }

    public CompletableFuture<MangaList> getMangaList(int page, MangaListFilters types) {
        return getList(page, types);
    }

    public CompletableFuture<MangaList> getMangaList(MangaListFilters types) {
        return getList(0, types);
    }

    public CompletableFuture<AnimeList> getAnimeList(int page) {
        return getList(page, null);
    }

    public CompletableFuture<AnimeList> getAnimeList(int page, AnimeListFilters types) {
        return getList(page, types);
    }

    public CompletableFuture<AnimeList> getAnimeList(AnimeListFilters types) {
        return getList(0, types);
    }

    /**
     * Gets an Anime/Manga list from user
     *
     * @param page if 0, returns all. if 1, returns 300 per page
     * @return CompletableFuture
     */
    private CompletableFuture getList(int page, UserListFilters userListFilters) {
        StringBuilder options = new StringBuilder();

        if (userListFilters != null)
            options.append("/").append(userListFilters.getForm()).append("/").append(userListFilters);
        if (page != 0)
            options.append("/").append(page);

        return retrieve(userListFilters.getaClass(), baseURL + "/user/" + username + options);
    }
}
