package Jikan4java.connection.Manga;
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

import Jikan4java.types.Main.Manga.Manga;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class MangaConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";

    /**
     * Constructor
     */
    public MangaConnection() {
    }

    /**
     * Searches for an anime--------
     *
     * @param title Manga to be searched
     * @return an Manga object
     */
    public Manga search(String title) throws IOException, ParseException {
        JSONObject mangaJSON = this.searchSite(title);
        ObjectMapper mapper = new ObjectMapper();
        Manga manga = mapper.readValue(mangaJSON.toJSONString(),Manga.class);
        return manga;
    }

    /**
     * searches Jikan api for anime
     *
     * @param search The name of what you are searching for
     * @return Returns an JSON object of the first result
     */
    private JSONObject searchSite(String search) throws IOException, ParseException {
        Request request = new Request.Builder().url(baseURL + "/search/manga?q=" + search + "&page=1").build();
        Response response = client.newCall(request).execute();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().string());
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        // Gets anime ID then goes to it's page
        request = new Request.Builder().url(baseURL + "/manga/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
        response = client.newCall(request).execute();

        return (JSONObject) parser.parse(response.body().string());
    }

    /**
     * Test method
     */
    public void test() throws IOException, ParseException {
        System.out.println(this.searchSite("ASSASSIN DE ARU ORE NO SUTETASU GA YUUSHA YORI MO AKIRAKA NI TSUYOI NODAGA"));
    }
}

