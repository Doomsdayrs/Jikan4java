package com.github.doomsdayrs.jikan4java.types.support.reviews.anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.reviews.Reviewer;
import com.github.doomsdayrs.jikan4java.types.support.reviews.Scores;

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
 * ====================================================================*/

/**
 * Jikan4java
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
public class AnimeReviewer extends Reviewer {
    public AnimeScore scores;

    public AnimeReviewer(@JsonProperty("url") String url,
                         @JsonProperty("image_url") String image_url,
                         @JsonProperty("username") String username,
                         @JsonProperty("episodes_seen") int seen,
                         @JsonProperty("scores") AnimeScore scores) {
        super(url, image_url, username, seen, scores);
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "AnimeReviewer{" +
                "url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", username='" + username + '\'' +
                ", seen=" + seen +
                ", scores=" + scores +
                '}';
    }
}
