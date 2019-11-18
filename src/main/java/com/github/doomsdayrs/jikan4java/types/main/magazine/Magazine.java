package com.github.doomsdayrs.jikan4java.types.main.magazine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.basic.meta.Authors;
import com.github.doomsdayrs.jikan4java.types.support.basic.meta.Genre;

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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */

public class Magazine {
    @JsonProperty("mal_id")
    public int mal_id;

    @JsonProperty("url")
    public String url;

    @JsonProperty("title")
    public String title;

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("synopsis")
    public String synopsis;

    @JsonProperty("type")
    public String type;

    @JsonProperty("publishing_start")
    public String publishing_start;

    @JsonProperty("volumes")
    public int volumes;

    @JsonProperty("members")
    public int members;

    @JsonProperty("genres")
    public ArrayList<Genre> genres;

    @JsonProperty("authors")
    public ArrayList<Authors> authors;

    @JsonProperty("score")
    public float score;

    @JsonProperty("serialization")
    public ArrayList<String> serializations;

    @Override
    public String toString() {
        return "Magazine{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
                ", publishing_start='" + publishing_start + '\'' +
                ", volumes=" + volumes +
                ", members=" + members +
                ", genres=" + genres +
                ", authors=" + authors +
                ", score=" + score +
                ", serializations=" + serializations +
                '}';
    }
}
