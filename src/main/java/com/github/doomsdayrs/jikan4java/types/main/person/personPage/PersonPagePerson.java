package com.github.doomsdayrs.jikan4java.types.main.person.personPage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.main.person.Person;
import com.github.doomsdayrs.jikan4java.types.support.searchResults.IndividualsPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
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
 * ====================================================================*//**
 * Jikan4java
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class PersonPagePerson extends IndividualsPage {

    public PersonPagePerson(@JsonProperty("mal_id") int mal_id,
                            @JsonProperty("url") String url,
                            @JsonProperty("image_url") String image_url,
                            @JsonProperty("name") String name,
                            @JsonProperty("alternative_names") ArrayList<String> alternative_names) {
        super(mal_id, url, image_url, name, alternative_names);
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
        return "PersonPagePerson{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", name='" + name + '\'' +
                ", alternative_names=" + alternative_names +
                '}';
    }
}
