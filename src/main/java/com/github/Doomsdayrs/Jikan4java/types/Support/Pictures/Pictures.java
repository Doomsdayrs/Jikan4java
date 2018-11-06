package com.github.Doomsdayrs.Jikan4java.types.Support.Pictures;
/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.JikanRequests;

import java.util.ArrayList;

/**
 * Jikan4java
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Pictures implements JikanRequests {
    @JsonProperty("pictures")
    private ArrayList<Picture> pictures;

    @Override
    public String getRequest_hash() {
        return request_hash;
    }

    @Override
    public boolean isRequest_cached() {
        return request_cached;
    }

    @Override
    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public ArrayList<Picture> getPictures() {
        return pictures;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pictures=" + pictures +
                ", request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                '}';
    }
}
