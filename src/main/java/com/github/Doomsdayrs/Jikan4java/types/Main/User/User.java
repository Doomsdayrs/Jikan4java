package com.github.Doomsdayrs.Jikan4java.types.Main.User;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Jikan4java
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
 /*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
*/
public class User {

    @JsonProperty("request_hash")
    private String request_hash;
    @JsonProperty("request_cached")
    private boolean request_cached;
    @JsonProperty("request_cache_expiry")
    private int request_cache_expiry;
    @JsonProperty("username")
    private String username;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("last_online")
    private String last_online;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("location")
    private String location;
    @JsonProperty("joined")
    private String joined;
    @JsonProperty("anime_stats")
    private ArrayList<AnimeStats> animeStats;
    @JsonProperty("manga_stats")
    private ArrayList<MangaStats> mangaStats;
    // Make favorites object
    @JsonProperty("about")
    private String about;
}
