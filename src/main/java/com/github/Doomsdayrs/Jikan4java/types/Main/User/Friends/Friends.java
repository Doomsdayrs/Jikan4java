package com.github.Doomsdayrs.Jikan4java.types.Main.User.Friends;

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Friends {
    @JsonProperty("url")
    public String url;
    @JsonProperty("username")
    public String username;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("last_online")
    public String last_online;
    @JsonProperty("friends_since")
    public String friends_since;
    

    @Override
    public String toString() {
        return "Friends{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", image_url='" + image_url + '\'' +
                ", last_online='" + last_online + '\'' +
                ", friends_since='" + friends_since + '\'' +
                '}';
    }
}
