package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Manga;

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
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaUserUpdate {

    @JsonProperty("username")
    private String username;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("score")
    private int scores;

    @JsonProperty("status")
    private String status;

    @JsonProperty("chapters_read")
    private int chapters_seen;

    @JsonProperty("volumes_read")
    private int volumes_seen;

    @JsonProperty("chapters_total")
    private int episodes_total;

    @JsonProperty("volumes_total")
    private int volumes_total;

    @JsonProperty("date")
    private String date;

    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getScores() {
        return scores;
    }

    public String getStatus() {
        return status;
    }

    public int getVolumes_seen() {
        return volumes_seen;
    }

    public int getChapters_seen() {
        return chapters_seen;
    }

    public int getVolumes_total() {
        return volumes_total;
    }


    public int getEpisodes_total() {
        return episodes_total;
    }

    @Override
    public String toString() {
        return "MangaUserUpdate{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", scores=" + scores +
                ", status='" + status + '\'' +
                ", chapters_seen=" + chapters_seen +
                ", volumes_seen=" + volumes_seen +
                ", episodes_total=" + episodes_total +
                ", volumes_total=" + volumes_total +
                '}';
    }
}
