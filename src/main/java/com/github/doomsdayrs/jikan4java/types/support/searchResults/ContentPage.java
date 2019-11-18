package com.github.doomsdayrs.jikan4java.types.support.searchResults;

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

/**
 * Jikan4java
 * com.github.doomsdayrs.jikan4java.types.support.searchResults
 * 18 / November / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ContentPage extends ObjectPage {
    public String title;
    public String synopsis;
    public String type;
    public double score;
    public String start_date;
    public String end_date;
    public int members;

    public ContentPage(@JsonProperty("mal_id") int mal_id,
                       @JsonProperty("url") String url,
                       @JsonProperty("image_url") String image_url,
                       @JsonProperty("title") String title,
                       @JsonProperty("synopsis") String synopsis,
                       @JsonProperty("type") String type,
                       @JsonProperty("score") double score,
                       @JsonProperty("start_date") String start_date,
                       @JsonProperty("end_date") String end_date,
                       @JsonProperty("members") int members) {
        super(mal_id, url, image_url);
        this.title = title;
        this.synopsis = synopsis;
        this.type = type;
        this.score = score;
        this.start_date = start_date;
        this.end_date = end_date;
        this.members = members;
    }
}
