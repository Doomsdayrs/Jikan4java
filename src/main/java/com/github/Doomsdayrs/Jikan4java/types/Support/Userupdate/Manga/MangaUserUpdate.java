package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaUserUpdate {

    @JsonProperty("username")
    public String username;

    @JsonProperty("url")
    public String url;

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("score")
    public int scores;

    @JsonProperty("status")
    public String status;

    @JsonProperty("chapters_read")
    public int chapters_seen;

    @JsonProperty("volumes_read")
    public int volumes_seen;

    @JsonProperty("chapters_total")
    public int episodes_total;

    @JsonProperty("volumes_total")
    public int volumes_total;

    @JsonProperty("date")
    public String date;
    
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
