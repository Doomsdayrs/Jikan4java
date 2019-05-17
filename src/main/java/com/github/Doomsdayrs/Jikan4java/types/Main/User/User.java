package com.github.Doomsdayrs.Jikan4java.types.Main.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Friends.Friends;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.History.HistoryPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.AnimeList.AnimeList;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.MangaList.MangaList;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.userListings.AnimeListTypes;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.userListings.UserListTypes;

import java.util.ArrayList;
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
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */

public class User extends Retriever {
    @JsonProperty("request_hash")
    public String request_hash;
    @JsonProperty("request_cached")
    public boolean request_cached;
    @JsonProperty("request_cache_expiry")
    public int request_cache_expiry;

    @JsonProperty("username")
    public String username;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("last_online")
    public String last_online;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("birthday")
    public String birthday;
    @JsonProperty("location")
    public String location;
    @JsonProperty("joined")
    public String joined;
    @JsonProperty("anime_stats")
    public ArrayList<AnimeStats> animeStats;
    @JsonProperty("manga_stats")
    public ArrayList<MangaStats> mangaStats;
    @JsonProperty("favorites")
    public Favorites favorites;
    @JsonProperty("about")
    public String about;

    /**
     * Returns history of the person
     *
     * @param type Anime or Manga
     * @return History object
     */
    public CompletableFuture<HistoryPage> getHistory(String type) {
        return retrieve(HistoryPage.class, baseURL + "/user/" + username + "/history" + type.toLowerCase());
    }

    /**
     * Returns friends of the person
     *
     * @param page Page to call for
     * @return Friends object
     */
    public CompletableFuture<Friends> getFriends(int page) {
        return retrieve(Friends.class, baseURL + "/user/" + username + "/friends/" + page);
    }


    //Lists
    //TODO oneday document this, im not in the mood rn
    public CompletableFuture<MangaList> getMangaList(int page) {
        return getList(page, null);
    }

    public CompletableFuture<MangaList> getMangaList(int page, AnimeListTypes types) {
        return getList(page, types);
    }

    public CompletableFuture<MangaList> getMangaList(AnimeListTypes types) {
        return getList(0, types);
    }

    public CompletableFuture<AnimeList> getAnimeList(int page) {
        return getList(page, null);
    }

    public CompletableFuture<AnimeList> getAnimeList(int page, AnimeListTypes types) {
        return getList(page, types);
    }

    public CompletableFuture<AnimeList> getAnimeList(AnimeListTypes types) {
        return getList(0, types);
    }

    /**
     * Gets an Anime/Manga list from user
     *
     * @param page if 0, returns all. if 1, returns 300 per page
     * @return CompletableFuture
     */
    private CompletableFuture getList(int page, UserListTypes userListTypes) {
        StringBuilder options = new StringBuilder();

        if (userListTypes != null)
            options.append("/").append(userListTypes.getForm()).append("/").append(userListTypes);
        if (page != 0)
            options.append("/").append(page);

        return retrieve(userListTypes.getaClass(), baseURL + "/user/" + username + options);
    }

    @Override
    public String toString() {
        return "User{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", last_online='" + last_online + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", location='" + location + '\'' +
                ", joined='" + joined + '\'' +
                ", animeStats=" + animeStats +
                ", mangaStats=" + mangaStats +
                ", favorites=" + favorites +
                ", about='" + about + '\'' +
                '}';
    }
}
