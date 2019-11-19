package com.github.doomsdayrs.jikan4java.types.support.reviews;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Review {
    public final int mal_id;
    public final String url;
    public final int helpful_count;
    public final String date;
    public final Reviewer reviewer;
    public final String content;


    public Review(@JsonProperty("mal_id") int mal_id,
                  @JsonProperty("url") String url,
                  @JsonProperty("helpful_count") int helpful_count,
                  @JsonProperty("date") String date,
                  @JsonProperty("reviewer") Reviewer reviewer,
                  @JsonProperty("content") String content) {
        this.mal_id = mal_id;
        this.url = url;
        this.helpful_count = helpful_count;
        this.date = date;
        this.reviewer = reviewer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", helpful_count=" + helpful_count +
                ", date='" + date + '\'' +
                ", reviewer=" + reviewer +
                ", content='" + content + '\'' +
                '}';
    }
}
