package com.github.doomsdayrs.jikan4java.types.support.searchResults;

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
 */


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.core.Retriever;

/**
 * Jikan4java
 * com.github.doomsdayrs.jikan4java.types.support.searchResults
 * 18 / November / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ObjectPage extends Retriever {
    public final int mal_id;
    public final String url;
    public final String image_url;

    public ObjectPage(@JsonProperty("mal_id") int mal_id, @JsonProperty("url") String url, @JsonProperty("image_url") String image_url) {
        this.mal_id = mal_id;
        this.url = url;
        this.image_url = image_url;
    }
}
