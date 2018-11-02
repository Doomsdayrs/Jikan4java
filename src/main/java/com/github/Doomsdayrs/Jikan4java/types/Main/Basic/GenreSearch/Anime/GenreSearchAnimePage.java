package com.github.Doomsdayrs.Jikan4java.types.Main.Basic.GenreSearch.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.GenreSearch.MalURL;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Schedule.SubAnime;

import java.util.ArrayList;

/**
 * Jikan4java
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
 /*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
*/public class GenreSearchAnimePage {
    @JsonProperty("request_hash")
    private String request_hash;
    @JsonProperty("request_cached")
    private boolean request_cached;
    @JsonProperty("request_cache_expiry")
    private int request_cache_expiry;
    @JsonProperty("mal_url")
    private MalURL malURL;
    @JsonProperty("item_count")
    private int item_count;
    @JsonProperty("anime")
    private ArrayList<SubAnime> animes;

    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public MalURL getMalURL() {
        return malURL;
    }

    public int getItem_count() {
        return item_count;
    }

    public ArrayList<SubAnime> getAnimes() {
        return animes;
    }

    @Override
    public String toString() {
        return "GenreSearchAnimePage{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", malURL=" + malURL +
                ", item_count=" + item_count +
                ", animes=" + animes +
                '}';
    }
}
