package com.github.Doomsdayrs.Jikan4java.types.Main.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.core.userListing.AnimeUserListingSearch;
import com.github.Doomsdayrs.Jikan4java.core.userListing.MangaUserListingSearch;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Friends.Friends;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.History.HistoryPage;

import java.util.ArrayList;
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
