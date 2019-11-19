package com.github.doomsdayrs.jikan4java.types.support.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.types.main.person.Person;

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class PeopleBasic extends BasicObject {
    public PeopleBasic(@JsonProperty("mal_id") int mal_id, @JsonProperty("url") String url, @JsonProperty("image_url") String image_url, @JsonProperty("name") String name) {
        super(mal_id, url, image_url, name);
    }

    /**
     * Returns the Person object of this object
     *
     * @return Person Object
     */
    public CompletableFuture<Person> getPerson() {
        return retrieve(Anime.class, baseURL + "/person/" + mal_id);
    }


}
