package com.github.doomsdayrs.jikan4java.model.main.top;/*
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

/**
 * Jikan4java
 * 18 / 11 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class TopListingMedia extends TopListing {

    public final String type;
    public final float score;
    public final int members;
    public final String start_date;

    public final String end_date;


    public TopListingMedia(@JsonProperty("mal_id") int mal_id, @JsonProperty("rank") int rank, @JsonProperty("title") String title, @JsonProperty("url") String url, @JsonProperty("image_url") String image_url, @JsonProperty("type") String type, @JsonProperty("score") float score, @JsonProperty("members") int members, @JsonProperty("start_date") String start_date, @JsonProperty("end_date") String end_date) {
        super(mal_id, rank, title, url, image_url);
        this.type = type;
        this.score = score;
        this.members = members;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
