package com.github.Doomsdayrs.Jikan4java.types.Main.Magazine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Authors;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;

import java.util.ArrayList;

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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Magazine {
    @JsonProperty("mal_id")
    private int mal_id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("title")
    private String title;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("synopsis")
    private String synopsis;

    @JsonProperty("type")
    private String type;

    @JsonProperty("publishing_start")
    private String publishing_start;

    @JsonProperty("volumes")
    private int volumes;

    @JsonProperty("members")
    private int members;

    @JsonProperty("genres")
    private ArrayList<Genre> genres;

    @JsonProperty("authors")
    private ArrayList<Authors> authors;

    @JsonProperty("score")
    private float score;

    @JsonProperty("serialization")
    private ArrayList<String> serializations;

    /**
     * Gets mal id
     *
     * @return mal id
     */
    public int getMal_id() {
        return mal_id;
    }

    /**
     * Gets url
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets image url
     * @return image url
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * Get synopsis
     * @return synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Get type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Get start date
     * @return date
     */
    public String getPublishing_start() {
        return publishing_start;
    }

    /**
     * Get count of volumes
     * @return count
     */
    public int getVolumes() {
        return volumes;
    }

    /**
     * Get count of members
     * @return count
     */
    public int getMembers() {
        return members;
    }

    /**
     * Get genres
     * @return genres
     */
    public ArrayList<Genre> getGenres() {
        return genres;
    }

    /**
     * Get authors
     * @return authors
     */
    public ArrayList<Authors> getAuthors() {
        return authors;
    }

    /**
     * Get score
     * @return scores
     */
    public float getScore() {
        return score;
    }

    /**
     * Get serializations
     * @return serializations
     */
    public ArrayList<String> getSerializations() {
        return serializations;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
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
