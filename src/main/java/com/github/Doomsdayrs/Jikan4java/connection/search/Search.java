package com.github.Doomsdayrs.Jikan4java.connection.search;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.connection.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.search.Types;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
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
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Search<T> extends Retriever {
    protected final Types type;
    protected T t;
    protected Class aClass;
    protected String query = null;
    private int limit = 0;

    /**
     * Constructor of search object
     *
     * @param type type of object that should be searched for
     */
    public Search(Types type) {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
        this.type = type;
        this.aClass = type.getA();
    }

    /**
     * Constructor of search object, with ability to have custom mapper
     *
     * @param type   Type of object that should be searched for
     * @param mapper CustomMapper to be used
     */
    public Search(Types type, ObjectMapper mapper) {
        super(mapper);
        this.type = type;
        this.aClass = type.getA();
    }

    /**
     * Creates the URL to be used to retrieve the Object
     *
     * @return StringBuilder of the URL so far
     */
    protected StringBuilder createURL() {
        StringBuilder builder = new StringBuilder();
        builder.append(baseURL + "/search/");
        builder.append(type);
        builder.append("?q=").append(query.replaceAll(" ", "%20"));
        if (limit != 0) builder.append("&limit=").append(limit);
        System.out.println(builder.toString());
        return builder;
    }

    /**
     * Set how many result to be listed per page, limit > 0
     *
     * @param limit how many entries
     * @return This
     * @throws IndexOutOfBoundsException incase you input a 0
     */
    public Search<T> setLimit(int limit) {
        if (limit != 0)
            this.limit = limit;
        else throw new IndexOutOfBoundsException("This program does not accept 0s");
        return this;
    }

    /**
     * Set the title that will be queried
     *
     * @param title Title or name of what you want
     * @return This
     */
    public Search<T> setQuery(String title) {
        this.query = title;
        return this;
    }

    /**
     * Gets the first result in list provided as its own object:
     * AnimePage = anime,
     * MangaPage = manga,
     * CharacterPage = character,
     * PersonPage = person.
     *
     * @return Completable future of the process
     */
    public CompletableFuture getFirst() {
        if (limit > 0)
            return CompletableFuture.supplyAsync(() -> {
                try {
                    ResponseBody responseBody = super.request(createURL().toString());
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody.string());
                    JSONArray jsonArray = (JSONArray) jsonObject.get("results");
                    // Gets anime ID then goes to it's page
                    Request request = new Request.Builder().url(baseURL + "/" + type + "/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
                    Response response = client.newCall(request).execute();
                    if (response.body() != null)
                        return objectMapper.readValue(((JSONObject) jsonParser.parse(response.body().string())).toJSONString(), type.getB());
                    else return null;
                } catch (IOException | ParseException e) {
                    throw new CompletionException(e);
                }
            });
        else return null;
    }

    /**
     * Gets the page
     *
     * @return Completable future of the process
     */
    public CompletableFuture<T> get() {
        return retrieve(aClass, createURL().toString());
    }
}
