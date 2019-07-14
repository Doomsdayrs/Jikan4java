package com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Review;

/*
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
public class MangaReview extends Review {
    @JsonProperty("mal_id")
    public int mal_id;

    @JsonProperty("url")
    public String url;

    @JsonProperty("helpful_count")
    public int helpful_count;

    @JsonProperty("date")
    public String date;

    @JsonProperty("reviewer")
    public MangaReviewer reviewer;

    @JsonProperty("content")
    public String content;
    

    @Override
    public String toString() {
        return "MangaReview{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", helpful_count=" + helpful_count +
                ", date='" + date + '\'' +
                ", reviewer=" + reviewer +
                ", content='" + content + '\'' +
                '}';
    }
}
