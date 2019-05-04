package com.github.Doomsdayrs.Jikan4java.connection.Character;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.connection.Connection;
import com.github.Doomsdayrs.Jikan4java.types.Main.Character.Character;
import com.github.Doomsdayrs.Jikan4java.types.Main.Character.CharacterPage.CharacterPage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

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
public class CharacterConnection extends Connection {


    /**
     * Constructor
     */
    public CharacterConnection() {
        super();
    }

    /**
     * Searches for a character, gets first result from first page
     *
     * @param name The name of the character
     * @return A character object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Character search(String name) throws IOException, ParseException {
        return objectMapper.readValue(this.searchSite(name).toJSONString(), Character.class);
    }

    /**
     * Searches and returns search result page
     *
     * @param title title to search for
     * @param page  page number
     * @return CharacterPage
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CharacterPage searchPage(String title, int page) throws IOException, ParseException {
        return (CharacterPage) retrieve(CharacterPage.class,baseURL + "/search/character?q=" + title + "&page=" + page);
    }

    /**
     * Searches api for character
     *
     * @param search The name of the character to search
     * @return A json object of the first character
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    private JSONObject searchSite(String search) throws IOException, ParseException {
        Request request = new Request.Builder().url(baseURL + "/search/character?q=" + search + "&page=1").build();
        Response response = client.newCall(request).execute();

        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.body().string());
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        // Gets anime ID then goes to it's page
        request = new Request.Builder().url(baseURL + "/character/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
        response = client.newCall(request).execute();

        return (JSONObject) jsonParser.parse(response.body().string());
    }

}
