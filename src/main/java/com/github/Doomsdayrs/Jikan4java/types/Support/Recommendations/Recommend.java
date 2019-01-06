package com.github.Doomsdayrs.Jikan4java.types.Support.Recommendations;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * 02 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Recommend {

    @JsonProperty("mal_id")
    private int mal_id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("recommendation_url")
    private String recommendation_url;

    @JsonProperty("title")
    private String title;

    @JsonProperty("recommendation_count")
    private int recommendation_count;

    public int getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getRecommendation_url() {
        return recommendation_url;
    }

    public String getTitle() {
        return title;
    }

    public int getRecommendation_count() {
        return recommendation_count;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", recommendation_url='" + recommendation_url + '\'' +
                ", title='" + title + '\'' +
                ", recommendation_count=" + recommendation_count +
                '}';
    }
}
