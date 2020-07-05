package com.github.doomsdayrs.jikan4java.model.main.top;/*
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
 * 18 / 11 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class TopListing extends Retriever {
    public final int mal_id;
    public final int rank;
    public final String title;
    public final String url;
    public final String image_url;

    public TopListing(@JsonProperty("mal_id") int mal_id, @JsonProperty("rank") int rank, @JsonProperty("title") String title, @JsonProperty("url") String url, @JsonProperty("image_url") String image_url) {
        this.mal_id = mal_id;
        this.rank = rank;
        this.title = title;
        this.url = url;
        this.image_url = image_url;
    }
}
