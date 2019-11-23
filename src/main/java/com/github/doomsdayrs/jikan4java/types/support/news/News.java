package com.github.doomsdayrs.jikan4java.types.support.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.RequestHashing;

import java.util.ArrayList;

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class News extends RequestHashing {
    @SuppressWarnings("WeakerAccess")
    @JsonProperty("articles")
    public ArrayList<Article> articles;

    public News(@JsonProperty("request_hash") String request_hash,
                @JsonProperty("request_cached") boolean request_cached,
                @JsonProperty("request_cache_expiry") int request_cache_expiry) {
        super(request_hash, request_cached, request_cache_expiry);
    }

    @Override
    public String toString() {
        return "News{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", articles=" + articles.toString() +
                '}';
    }
}
