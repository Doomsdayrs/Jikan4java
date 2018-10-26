package Jikan4java.connection.Anime;
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

import Jikan4java.types.Anime.Anime;
import Jikan4java.types.Manga.Manga;
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


        String mal_id = "0",url = "",image_url = "",trailer_url = "",
                animeTitle = "",title_english = "",title_japanese = "",
                type = "",source = "",episodes = "0",
                status = "",duration = "",rating = "",
                score = "0",scored_by = "0",rank = "0",
                members = "0",favorites = "0",synopsis = "",
                background = "",premiered = "";

        if(animeJSON.get("mal_id") != null){
            mal_id = animeJSON.get("mal_id").toString();
        }

        if(animeJSON.get("url") != null){
            url = animeJSON.get("url").toString();
        }

        if(animeJSON.get("image_url") != null){
            image_url = animeJSON.get("image_url").toString();
        }

        if(animeJSON.get("trailer_url") != null){
            trailer_url = animeJSON.get("trailer_url").toString();
        }

        if(animeJSON.get("animeTitle") != null){
            animeTitle = animeJSON.get("animeTitle").toString();
        }

        if(animeJSON.get("title_english") != null){
            title_english = animeJSON.get("title_english").toString();
        }

        if(animeJSON.get("title_japanese") != null){
            title_japanese = animeJSON.get("title_japanese").toString();
        }

        if(animeJSON.get("type") != null){
            type = animeJSON.get("type").toString();
        }

        if(animeJSON.get("source") != null){
            source = animeJSON.get("source").toString();
        }

        if(animeJSON.get("episodes") != null){
            episodes = animeJSON.get("episodes").toString();
        }

        if(animeJSON.get("status") != null){
            status = animeJSON.get("status").toString();
        }

        if(animeJSON.get("duration") != null){
            duration = animeJSON.get("duration").toString();
        }

        if(animeJSON.get("rating") != null){
            rating = animeJSON.get("rating").toString();
        }

        if(animeJSON.get("score") != null){
            score = animeJSON.get("score").toString();
        }

        if(animeJSON.get("scored_by") != null){
            scored_by = animeJSON.get("scored_by").toString();
        }

        if(animeJSON.get("rank") != null){
            rank = animeJSON.get("rank").toString();
        }

        if(animeJSON.get("members") != null){
            members = animeJSON.get("members").toString();
        }

        if(animeJSON.get("favorites") != null){
            favorites = animeJSON.get("favorites").toString();
        }

        if(animeJSON.get("synopsis") != null){
            synopsis = animeJSON.get("synopsis").toString();
        }

        if(animeJSON.get("background") != null){
            background = animeJSON.get("background").toString();
        }

        if(animeJSON.get("premiered") != null){
            premiered = animeJSON.get("premiered").toString();
        }


        return new Anime(
                Integer.parseInt(mal_id),
                url,
                image_url,
                trailer_url,
                animeTitle,
                title_english,
                title_japanese,
                type,
                source,
                Integer.parseInt(episodes),
                status,aired.get("string").toString(),
                duration,
                rating,
                Double.parseDouble(score),
                Integer.parseInt(scored_by),
                Integer.parseInt(rank),
                Integer.parseInt(members),
                Integer.parseInt(favorites),
                synopsis,
                background,
                premiered,
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

