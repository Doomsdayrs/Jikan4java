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
    public Manga search(String title) throws IOException, ParseException {
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


        String mal_id,url,image_url,trailer_url,
                animeTitle,title_english,title_japanese,
                type,source,episodes,
                status,duration,rating,
                score,scored_by,rank,
                members,favorites,synopsis,
                background,premiered;
        try {
            mal_id = animeJSON.get("mal_id").toString();
        }
        catch (NullPointerException e)
        {
            mal_id = "";
        }
        try {
            url = animeJSON.get("url").toString();
        }
        catch (NullPointerException e)
        {
            url = "";
        }
        try {
            image_url = animeJSON.get("image_url").toString();
        }
        catch (NullPointerException e)
        {
            image_url = "";
        }
        try {
            trailer_url = animeJSON.get("trailer_url").toString();
        }
        catch (NullPointerException e)
        {
            trailer_url = "";
        }
        try {
            animeTitle = animeJSON.get("animeTitle").toString();
        }
        catch (NullPointerException e)
        {
            animeTitle = "";
        }
        try {
            title_english = animeJSON.get("title_english").toString();
        }
        catch (NullPointerException e)
        {
            title_english = "";
        }
        try {
            title_japanese = animeJSON.get("title_japanese").toString();
        }
        catch (NullPointerException e)
        {
            title_japanese = "";
        }
        try {
            type = animeJSON.get("type").toString();
        }
        catch (NullPointerException e)
        {
            type = "";
        }
        try {
            source = animeJSON.get("source").toString();
        }
        catch (NullPointerException e)
        {
            source = "";
        }
        try {
            episodes = animeJSON.get("episodes").toString();
        }
        catch (NullPointerException e)
        {
            episodes = "0";
        }
        try {
            status = animeJSON.get("status").toString();
        }
        catch (NullPointerException e)
        {
            status = "";
        }

        try {
            duration = animeJSON.get("duration").toString();
        }
        catch (NullPointerException e)
        {
            duration = "";
        }
        try {
            rating = animeJSON.get("rating").toString();
        }
        catch (NullPointerException e)
        {
            rating = "0";
        }
        try {
            score = animeJSON.get("score").toString();
        }
        catch (NullPointerException e)
        {
            score = "0";
        }
        try {
            scored_by = animeJSON.get("scored_by").toString();
        }
        catch (NullPointerException e)
        {
            scored_by = "0";
        }
        try {
            rank = animeJSON.get("rank").toString();
        }
        catch (NullPointerException e)
        {
            rank = "0";
        }
        try {
            members = animeJSON.get("members").toString();
        }
        catch (NullPointerException e)
        {
            members = "0";
        }
        try {
            favorites = animeJSON.get("favorites").toString();
        }
        catch (NullPointerException e)
        {
            favorites = "0";
        }
        try {
            synopsis = animeJSON.get("synopsis").toString();
        }
        catch (NullPointerException e)
        {
            synopsis = "";
        }
        try {
            background = animeJSON.get("background").toString();
        }
        catch (NullPointerException e)
        {
            background = "";
        }
        try {
            premiered = animeJSON.get("premiered").toString();
        }
        catch (NullPointerException e)
        {
            premiered = "";
        }

        return new Manga(
                mal_id,
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

