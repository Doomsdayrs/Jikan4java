package com.github.doomsdayrs.jikan4java.types.support.reviews;

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
 */


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.reviews.manga.MangaReview;

import java.util.ArrayList;

/**
 * Jikan4java
 * com.github.doomsdayrs.jikan4java.types.support.reviews
 * 18 / November / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ReviewPage {
    public String request_hash;
    public boolean request_cached;
    public int request_cache_expiry;
    public ArrayList<Review> reviews;

    public ReviewPage(@JsonProperty("request_hash") String request_hash,
                      @JsonProperty("request_cached") boolean request_cached,
                      @JsonProperty("request_cache_expiry") int request_cache_expiry,
                      @JsonProperty("reviews") ArrayList<Review> reviews) {
        this.request_hash = request_hash;
        this.request_cached = request_cached;
        this.request_cache_expiry = request_cache_expiry;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "ReviewPage{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", reviews=" + reviews +
                '}';
    }
}
