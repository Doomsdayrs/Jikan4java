package com.github.doomsdayrs.jikan4java.types.main.user.listing.mangalist;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.main.user.listing.UserListing;
import com.github.doomsdayrs.jikan4java.types.support.RequestHashing;

import java.util.ArrayList;

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
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaList extends UserListing {

    @JsonProperty("manga")
    public ArrayList<MangaListManga> mangas;

    public MangaList(@JsonProperty("request_hash") String request_hash,
                     @JsonProperty("request_cached") boolean request_cached,
                     @JsonProperty("request_cache_expiry") int request_cache_expiry) {
        super(request_hash, request_cached, request_cache_expiry);
    }

    @Override
    public String toString() {
        return "MangaList{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", mangas=" + mangas +
                '}';

    }
}
