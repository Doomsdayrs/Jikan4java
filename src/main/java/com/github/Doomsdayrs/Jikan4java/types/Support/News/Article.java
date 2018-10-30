package com.github.Doomsdayrs.Jikan4java.types.Support.News;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jikan4java
 * 29 / October / 2018
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
public class Article {
    @JsonProperty("url")
    private String url;

    @JsonProperty("title")
    private String title;

    @JsonProperty("date")
    private String date;

    @JsonProperty("author_name")
    private String author_name;

    @JsonProperty("author_url")
    private String author_url;

    @JsonProperty("forum_url")
    private String forum_url;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("comments")
    private int comments;

    @JsonProperty("intro")
    private String intro;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public String getForum_url() {
        return forum_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getComments() {
        return comments;
    }

    public String getIntro() {
        return intro;
    }

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
