package com.github.doomsdayrs.jikan4java.types.main.top.objects.manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.main.manga.Manga;
import com.github.doomsdayrs.jikan4java.types.main.top.TopListingMedia;

import java.util.concurrent.CompletableFuture;

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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class TopManga extends TopListingMedia {
    @JsonProperty("volumes")
    public int volumes;

    public TopManga(@JsonProperty("mal_id") int mal_id, @JsonProperty("rank") int rank, @JsonProperty("title") String title, @JsonProperty("url") String url, @JsonProperty("image_url") String image_url, @JsonProperty("type") String type, @JsonProperty("score") float score, @JsonProperty("members") int members, @JsonProperty("start_date") String start_date, @JsonProperty("end_date") String end_date) {
        super(mal_id, rank, title, url, image_url, type, score, members, start_date, end_date);
    }


    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     */
    public CompletableFuture<Manga> getManga() {
        return retrieve(Manga.class, baseURL + "/manga/" + mal_id);
    }

    @Override
    public String toString() {
        return "TopManga{" +
                "mal_id=" + mal_id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", subType='" + type + '\'' +
                ", volumes=" + volumes +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                ", score=" + score +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
