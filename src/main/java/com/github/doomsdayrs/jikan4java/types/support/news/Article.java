package com.github.doomsdayrs.jikan4java.types.support.news;

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
 * ====================================================================
 * Jikan4java
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Article {
    @JsonProperty("url")
    public String url;

    @JsonProperty("title")
    public String title;

    @JsonProperty("date")
    public String date;

    @JsonProperty("author_name")
    public String author_name;

    @JsonProperty("author_url")
    public String author_url;

    @JsonProperty("forum_url")
    public String forum_url;

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("comments")
    public int comments;

    @JsonProperty("intro")
    public String intro;

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_url='" + author_url + '\'' +
                ", forum_url='" + forum_url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", comments=" + comments +
                ", intro='" + intro + '\'' +
                '}';
    }
}
