package com.github.Doomsdayrs.Jikan4java.types.Main.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Friends.Friends;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.History.HistoryPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.AnimeList.AnimeList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

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

public class User {

    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3/user/";
    private final ObjectMapper objectMapper = new ObjectMapper();

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
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<HistoryPage> getHistory(String type) throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + username + "/history/" + type.toLowerCase()).build()).execute().body()).string())).toJSONString(), HistoryPage.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });
    }


    /**
     * Returns friends of the person
     *
     * @param page Page to call for
     * @return Friends object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<Friends> getFriends(int page) throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + username + "/friends/" + page).build()).execute().body()).string())).toJSONString(), Friends.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });
    }


    public CompletableFuture<AnimeList> getAnimelist(int page) throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (page == 0) {
                    return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + username + "/animelist/all").build()).execute().body()).string())).toJSONString(), AnimeList.class);
                } else
                    return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + username + "/animelist/all/" + page).build()).execute().body()).string())).toJSONString(), AnimeList.class);

            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }

        });
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
