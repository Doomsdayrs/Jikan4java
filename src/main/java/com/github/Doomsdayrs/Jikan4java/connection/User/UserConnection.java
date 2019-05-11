package com.github.Doomsdayrs.Jikan4java.connection.User;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.connection.Connection;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

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
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */

public class UserConnection extends Connection {
    /**
     * Constructor
     */
    public UserConnection() {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
    }

    //TODO Figure out if this causes an error with jumbled input;
    /**
     * Returns a user object
     *
     * @param name the name of the user to retrieve
     * @return User
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<User> search(String name) {
        return retrieve(User.class, baseURL + "/user/" + name);
    }
}
