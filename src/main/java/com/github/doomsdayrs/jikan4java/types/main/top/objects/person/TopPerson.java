package com.github.doomsdayrs.jikan4java.types.main.top.objects.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.main.person.Person;
import com.github.doomsdayrs.jikan4java.types.main.top.TopListingBeing;

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
public class TopPerson extends TopListingBeing {

    @JsonProperty("birthday")
    public String birthday;

    public TopPerson(@JsonProperty("mal_id") int mal_id, @JsonProperty("rank") int rank, @JsonProperty("title") String title, @JsonProperty("url") String url, @JsonProperty("favorites") int favorites, @JsonProperty("name_kanji") String name_kanji, @JsonProperty("image_url") String image_url) {
        super(mal_id, rank, title, url, favorites, name_kanji, image_url);
    }

    /**
     * Returns the Person object of this object
     *
     * @return Person Object
     */
    public CompletableFuture<Person> getPerson() {
        return retrieve(Person.class, baseURL + "/person/" + mal_id);
    }

    @Override
    public String toString() {
        return "TopPerson{" +
                "mal_id=" + mal_id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", name_kanji='" + name_kanji + '\'' +
                ", favorites=" + favorites +
                ", image_url='" + image_url + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
