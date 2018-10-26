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
import java.util.Optional;

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
        JSONArray genres = (JSONArray) mangaJSON.get("genres");
        JSONArray serialization = (JSONArray) mangaJSON.get("serializations");
        JSONArray title_synonym = (JSONArray) mangaJSON.get("title_synonyms");
        JSONArray authors = (JSONArray) mangaJSON.get("authors");
        /*JSONArray related = (JSONArray) mangaJSON.get("related");*/

        String mal_id = "0",
                url = "", mangaTitle = "", title_english = "", title_japanese = "", status = "", image_url = "", type = "",
                volumes = "0", chapters = "0",
                publishing = "", published = "",
                rank = "0", score = "0", scored_by = "0", popularity = "0", members = "0", favorites = "0",
                synopsis = "", background = "";


        if (mangaJSON.get("mal_id") != null) {
            mal_id = mangaJSON.get("mal_id").toString();
        }
        if (mangaJSON.get("url") != null) {
            url = mangaJSON.get("url").toString();
        }
        if (mangaJSON.get("title_english") != null) {
            title_english = mangaJSON.get("title_english").toString();
        }
        ArrayList<String> title_synonyms = new ArrayList<>();
        for (int x = 0; x < title_synonym.size(); x++) {
            title_synonyms.add(
                    title_synonym.get(x).toString()
            );
        }

        if (mangaJSON.get("title_japanese") != null) {
            title_japanese = mangaJSON.get("title_japanese").toString();
        }
        if (mangaJSON.get("status") != null) {
            status = mangaJSON.get("status").toString();
        }
        if (mangaJSON.get("image_url") != null) {
            image_url = mangaJSON.get("image_url").toString();
        }
        if (mangaJSON.get("type") != null) {
            type = mangaJSON.get("type").toString();
        }
        if (mangaJSON.get("volumes") != null) {
            volumes = mangaJSON.get("volumes").toString();
        }
        if (mangaJSON.get("chapters") != null) {
            chapters = mangaJSON.get("chapters").toString();
        }
        if (mangaJSON.get("publishing") != null) {
            publishing = mangaJSON.get("publishing").toString();
        }
        if (mangaJSON.get("published") != null) {
            published = ((JSONObject) mangaJSON.get("published")).get("string").toString();
        }
        if (mangaJSON.get("rank") != null) {
            rank = mangaJSON.get("rank").toString();
        }
        if (mangaJSON.get("score") != null) {
            score = mangaJSON.get("score").toString();
        }
        if (mangaJSON.get("scored_by") != null) {
            scored_by = mangaJSON.get("scored_by").toString();
        }
        if (mangaJSON.get("popularity") != null) {
            popularity = mangaJSON.get("popularity").toString();
        }
        if (mangaJSON.get("members") != null) {
            members = mangaJSON.get("members").toString();
        }
        if (mangaJSON.get("favorites") != null) {
            favorites = mangaJSON.get("favorites").toString();
        }
        if (mangaJSON.get("synopsis") != null) {
            synopsis = mangaJSON.get("synopsis").toString();
        }

        /*ArrayList<ArrayList<String>> sideStories;
        ArrayList<String> relatedList = new ArrayList<>();
        if (genres != null) {

        }else relatedList.add("");*/

        ArrayList<String> genreList = new ArrayList<>();
        if (genres != null) {
            for (int x = 0; x < genres.size(); x++) {
            genreList.add(
                    ((JSONObject)genres.get(x)).get("name").toString()
            );
        }
        }else genreList.add("");

        ArrayList<String> authorList = new ArrayList<>();
        if (authors != null) {
            for (int x = 0; x < authors.size(); x++) {
                authorList.add(
                        ((JSONObject)authors.get(x)).get("name").toString()
                );
            }
        }else authorList.add("");

        /*ArrayList<String> authorList = new ArrayList<>();
        if (genres != null) {
            for (int x = 0; x < genres.size(); x++) {
                authorList.add(
                        ((JSONObject)genres.get(x)).get("name").toString()
                );
            }
        }else authorList.add("");*/

        ArrayList<String> serializations = new ArrayList<>();
        if (serialization != null) {
            for (int x = 0; x < serialization.size(); x++) {
                serializations.add(
                        ((JSONObject)serialization.get(x)).get("name").toString()
                );
            }
        }
        else serializations.add("");

        return new Manga(
                Integer.parseInt(mal_id), url, mangaTitle,
                title_english,title_synonyms, title_japanese, status,
                image_url, type,
                Integer.parseInt(volumes), Integer.parseInt(chapters),
                publishing, published,
                Integer.parseInt(rank),Double.parseDouble(score), Integer.parseInt(scored_by),Integer.parseInt(popularity), Integer.parseInt(members), Integer.parseInt(favorites),
                synopsis, background,
                genreList, authorList, serializations);
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

