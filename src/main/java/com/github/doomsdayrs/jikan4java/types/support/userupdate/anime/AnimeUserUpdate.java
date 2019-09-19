package com.github.doomsdayrs.jikan4java.types.support.userupdate.anime;

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
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class AnimeUserUpdate {

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

    @JsonProperty("episodes_seen")
    public int episodes_seen;

    @JsonProperty("episodes_total")
    public int episodes_total;

    @JsonProperty("date")
    public String date;
    

    @Override
    public String toString() {
        return "AnimeUserUpdate{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", scores=" + scores +
                ", status='" + status + '\'' +
                ", episodes_seen=" + episodes_seen +
                ", episodes_total=" + episodes_total +
                '}';
    }
}
