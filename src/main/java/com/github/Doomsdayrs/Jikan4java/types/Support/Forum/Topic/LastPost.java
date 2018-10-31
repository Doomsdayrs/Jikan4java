package com.github.Doomsdayrs.Jikan4java.types.Support.Forum.Topic;
/**
 * Jikan4java
 * 30 / October / 2018
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

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastPost {
    @JsonProperty("url")
    private String url;
    @JsonProperty("author_name")
    private String author_name;
    @JsonProperty("author_url")
    private String author_url;
    @JsonProperty("date_posted")
    private String date_posted;

    public String getUrl() {
        return url;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public String getDate_posted() {
        return date_posted;
    }

    @Override
    public String toString() {
        return "LastPost{" +
                "url='" + url + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_url='" + author_url + '\'' +
                ", date_posted='" + date_posted + '\'' +
                '}';
    }
}
