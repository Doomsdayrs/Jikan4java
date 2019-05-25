package com.github.Doomsdayrs.Jikan4java.core.userListing;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

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
 * along with Jikan4java.  If not, see https://www.gnu.org/licenses/.
 * ====================================================================
 * Jikan4java
 * 25 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaUserListingSearch extends UserListingSearch {
    private int magazine = 0;

    public MangaUserListingSearch(String username) {
        super(username);
    }

    public MangaUserListingSearch(OkHttpClient client, String username) {
        super(client, username);
    }

    public MangaUserListingSearch(ObjectMapper objectMapper, String username) {
        super(objectMapper, username);
    }

    public MangaUserListingSearch(JSONParser jsonParser, String username) {
        super(jsonParser, username);
    }

    public MangaUserListingSearch(Request.Builder builder, String username) {
        super(builder, username);
    }
}
