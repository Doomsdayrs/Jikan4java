package com.github.Doomsdayrs.Jikan4java.connection.Anime;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage.AnimePage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collection;

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
public class AnimeConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    /**
     * Constructor
     */
    public AnimeConnection() {
    }

    /**
     * Searches for an anime and retrieves first result
     *
     * @param title title to be searched
     * @throws IOException    IOException
     * @throws ParseException ParseException
     * @returnan Anime object
     */
    public Anime searchSimple(String title) throws IOException, ParseException {
        JSONObject animeJSON = this.searchSite(title);
        return objectMapper.readValue(animeJSON.toJSONString(), Anime.class);
    }

    /**
     * Searches and returns search result page
     *
     * @param title title to search for
     * @param page  page number
     * @return AnimePage
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public AnimePage searchPage(String title, int page) throws IOException, ParseException {
        return objectMapper.readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url(baseURL + "/search/anime?q=" + title + "&page=" + page).build()).execute().body().string())).toJSONString(), new TypeReference<Collection<AnimePage>>() {
        });
    }

    /**
     * searches Jikan api for anime
     *
     * @param search The name of what you are searching for
     * @return Returns an JSON object of the first result
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    private JSONObject searchSite(String search) throws IOException, ParseException {
        Request request = new Request.Builder().url(baseURL + "/search/anime?q=" + search + "&page=1").build();
        Response response = client.newCall(request).execute();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().string());
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        // Gets anime ID then goes to it's page
        request = new Request.Builder().url(baseURL + "/anime/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
        response = client.newCall(request).execute();

        return (JSONObject) parser.parse(response.body().string());
    }
}

