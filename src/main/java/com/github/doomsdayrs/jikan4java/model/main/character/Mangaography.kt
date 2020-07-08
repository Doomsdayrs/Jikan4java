package com.github.doomsdayrs.jikan4java.model.main.character;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.model.main.manga.Manga;

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
 * ====================================================================
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Mangaography extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("role")
    public String role;

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
        return "Mangaography{" +
                "mal_id=" + mal_id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
