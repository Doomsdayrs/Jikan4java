package com.github.doomsdayrs.jikan4java.types.main.top;/*
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
public class TopListingBeing extends TopListing {
    public int favorites;
    public String name_kanji;

    public TopListingBeing(int mal_id, int rank, String title, String url, @JsonProperty("favorites") int favorites, @JsonProperty("name_kanji") String name_kanji, @JsonProperty("image_url") String image_url) {
        super(mal_id, rank, title, url, image_url);
        this.favorites = favorites;
        this.name_kanji = name_kanji;
    }


}
