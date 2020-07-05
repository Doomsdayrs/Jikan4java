package com.github.doomsdayrs.jikan4java.model.main.club;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.model.main.user.User;

import java.util.concurrent.CompletableFuture;

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
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ClubMember extends Retriever {
    @JsonProperty("username")
    public String username;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image_url")
    public String image_url;

    /**
     * Returns a user object
     *
     * @param name the name of the user to retrieve
     * @return User
     */
    public CompletableFuture<User> userRetrieve(String name) {
        return retrieve(User.class, baseURL + "/user/" + name);
    }

    @Override
    public String toString() {
        return "ClubMember{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
