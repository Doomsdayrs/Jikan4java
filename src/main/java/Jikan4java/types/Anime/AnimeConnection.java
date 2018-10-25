package Jikan4java.types.Anime;
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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class AnimeConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";

    /**
     * Constructor
     */
    public AnimeConnection() {
    }

    /**
     * Searches for an anime--------
     *
     * @param title title to be searched
     * @return an Anime object
     */
    public Anime search(String title) throws IOException, ParseException {
        JSONObject animeJSON = this.search("anime", title);
        JSONObject aired = (JSONObject) animeJSON.get("aired");

        JSONArray genres = (JSONArray) animeJSON.get("genres");
        JSONArray openings = (JSONArray) animeJSON.get("opening_themes");
        JSONArray endings = (JSONArray) animeJSON.get("ending_themes");

        ArrayList<String> genreList = new ArrayList<String>();
        for (Object genre : genres) {
            genreList.add(
                    ((JSONObject) genre).get("name").toString()
            );
        }
        ArrayList<String> openingList = new ArrayList<String>();
        for (int x = 0; x < openings.size(); x++) {
            openingList.add(
                    openings.get(x).toString()
            );
        }
        ArrayList<String> endingList = new ArrayList<String>();
        for (int x = 0; x < endings.size(); x++) {
            endingList.add(
                    endings.get(x).toString()
            );
        }
        return new Anime(
                animeJSON.get("mal_id").toString(),
                animeJSON.get("url").toString(),
                animeJSON.get("image_url").toString(),
                animeJSON.get("trailer_url").toString(),
                animeJSON.get("title").toString(),
                animeJSON.get("title_english").toString(),
                animeJSON.get("title_japanese").toString(),
                animeJSON.get("type").toString(),
                animeJSON.get("source").toString(),
                Integer.parseInt(animeJSON.get("episodes").toString()),
                animeJSON.get("status").toString(),
                aired.get("string").toString(),
                animeJSON.get("duration").toString(),
                animeJSON.get("rating").toString(),
                Double.parseDouble(animeJSON.get("score").toString()),
                Integer.parseInt(animeJSON.get("scored_by").toString()),
                Integer.parseInt(animeJSON.get("rank").toString()),
                Integer.parseInt(animeJSON.get("members").toString()),
                Integer.parseInt(animeJSON.get("favorites").toString()),
                animeJSON.get("synopsis").toString(),
                animeJSON.get("background").toString(),
                animeJSON.get("premiered").toString(),
                genreList,
                openingList,
                endingList
        );
    }

    /**
     * searches Jikan api for anime
     *
     * @param type   What kind of media are you looking for (anime/manga/character)
     * @param search The name of what you are searching for
     * @return Returns an JSON object of the first result
     */
    private JSONObject search(String type, String search) throws IOException, ParseException {
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

    /**
     * Test method
     */
    public void test() throws IOException, ParseException {
        System.out.println(this.search("anime", "Attack on titan"));
    }
}

