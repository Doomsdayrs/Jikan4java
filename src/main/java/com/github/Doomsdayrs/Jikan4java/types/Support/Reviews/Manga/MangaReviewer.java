package com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Reviewer;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
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
public class MangaReviewer extends Reviewer {

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("username")
    private String username;

    @JsonProperty("chapters_read")
    private int seen;

    @JsonProperty("scores")
    private MangaScore scores;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getImage_url() {
        return image_url;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getSeen() {
        return seen;
    }

    @Override
    public MangaScore getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "MangaReviewer{" +
                "url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", username='" + username + '\'' +
                ", seen=" + seen +
                ", scores=" + scores +
                '}';
    }
}
