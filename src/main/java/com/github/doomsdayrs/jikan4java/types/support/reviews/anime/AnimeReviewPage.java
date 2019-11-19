package com.github.doomsdayrs.jikan4java.types.support.reviews.anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.reviews.Review;
import com.github.doomsdayrs.jikan4java.types.support.reviews.ReviewPage;

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
 * ====================================================================*/

/**
 * Jikan4java
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
public class AnimeReviewPage extends ReviewPage {

    public final ArrayList<AnimeReview> reviews;

    public AnimeReviewPage(@JsonProperty("request_hash") String request_hash,
                           @JsonProperty("request_cached") boolean request_cached,
                           @JsonProperty("request_cache_expiry") int request_cache_expiry,
                           @JsonProperty("reviews") ArrayList<AnimeReview> reviews) {
        super(request_hash, request_cached, request_cache_expiry);
        this.reviews = reviews;

        for (Review review : this.reviews) {
            super.reviews.add(review);
        }
    }

    @Override
    public String toString() {
        return "AnimeReviewPage{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", animeReviews=" + reviews +
                '}';
    }
}
