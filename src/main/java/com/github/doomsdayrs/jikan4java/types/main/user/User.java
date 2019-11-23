package com.github.doomsdayrs.jikan4java.types.main.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.core.userlisting.AnimeUserListingSearch;
import com.github.doomsdayrs.jikan4java.core.userlisting.MangaUserListingSearch;
import com.github.doomsdayrs.jikan4java.enums.HistoryTypes;
import com.github.doomsdayrs.jikan4java.types.main.user.friends.Friends;
import com.github.doomsdayrs.jikan4java.types.main.user.history.HistoryPage;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

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

    @JsonProperty("user_id")
    public int user_id;

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
    public CompletableFuture<HistoryPage> getHistory(HistoryTypes type) {
        return retrieve(HistoryPage.class, baseURL + "/user/" + username + "/history" + type);
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

    public AnimeUserListingSearch getAnimeListSearch() {
        return new AnimeUserListingSearch(username);
    }

    public MangaUserListingSearch getMangaListSearch() {
        return new MangaUserListingSearch(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", user_id=" + user_id +
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
