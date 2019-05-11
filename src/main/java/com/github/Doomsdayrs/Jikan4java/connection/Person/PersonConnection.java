package com.github.Doomsdayrs.Jikan4java.connection.Person;

import com.github.Doomsdayrs.Jikan4java.connection.Connection;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.Person;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.PersonPage.PersonPage;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class PersonConnection extends Connection {

    /**
     * Constructor
     */
    public PersonConnection() {
        super();
    }

    /**
     * Searches for a person, and returns first result
     *
     * @param title Name of person
     * @return Person object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<Person> search(String title) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return objectMapper.readValue(this.searchSite(title).toJSONString(), Person.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }

    /**
     * Searches and returns search result page
     *
     * @param title title to search for
     * @param page  page number
     * @return PersonPage
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<PersonPage> searchPage(String title, int page) throws IOException, ParseException {
        return retrieve(PersonPage.class, baseURL + "/search/person?q=" + title + "&page=" + page);
    }

    /**
     * Searches Jikan api for a person
     *
     * @param search The name of what you are searching for
     * @return Returns an JSON object of the first result
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    private JSONObject searchSite(String search) throws IOException, ParseException {
        Request request = new Request.Builder().url(baseURL + "/search/person?q=" + search + "&page=1").build();
        Response response = client.newCall(request).execute();

        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.body().string());
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        // Gets anime ID then goes to it's page
        request = new Request.Builder().url(baseURL + "/person/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
        response = client.newCall(request).execute();

        return (JSONObject) jsonParser.parse(response.body().string());
    }

}
