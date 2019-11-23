package com.github.doomsdayrs.jikan4java.types.support;/*
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
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jikan4java
 * 18 / 11 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class RequestHashing {
    public String request_hash;
    public boolean request_cached;
    public int request_cache_expiry;

    public RequestHashing(
            @JsonProperty("request_hash") String request_hash,
            @JsonProperty("request_cached") boolean request_cached,
            @JsonProperty("request_cache_expiry") int request_cache_expiry) {
        this.request_hash = request_hash;
        this.request_cached = request_cached;
        this.request_cache_expiry = request_cache_expiry;
    }
}
