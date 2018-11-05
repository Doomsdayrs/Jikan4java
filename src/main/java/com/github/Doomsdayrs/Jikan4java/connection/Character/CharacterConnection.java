package com.github.Doomsdayrs.Jikan4java.connection.Character;
/**
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
/*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
*/

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class CharacterConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";

    /**
     * Constructor
     */
    public CharacterConnection() {
    }

    /**
     * Searches for a character
     *
     * @param name The name of the character
     * @return A character object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Character search(String name) throws IOException, ParseException {
        JSONObject characterJSON = this.searchSite(name);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(characterJSON.toJSONString(), Character.class);
    }

    /**
     * Searches and returns search result page
     *
     * @param title title to search for
     * @param page  page number
     * @return CharacterPage
     * @throws IOException                           IOException
     * @throws org.json.simple.parser.ParseException ParseException
     */
    public CharacterPage searchPage(String title, int page) throws IOException, org.json.simple.parser.ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url(baseURL + "/search/character?q=" + title + "&page=" + page).build()).execute().body().string())).toJSONString(), CharacterPage.class);
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

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().string());
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        // Gets anime ID then goes to it's page
        request = new Request.Builder().url(baseURL + "/character/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
        response = client.newCall(request).execute();

        return (JSONObject) parser.parse(response.body().string());
    }

    /**
     * Test method
     *
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public void test() throws IOException, ParseException {
        System.out.println(this.searchSite("Caster").toJSONString());
    }
}
