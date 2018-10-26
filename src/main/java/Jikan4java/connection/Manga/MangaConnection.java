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
        JSONArray serialization = (JSONArray) mangaJSON.get("opening_themes");
        JSONArray title_synonym = (JSONArray) mangaJSON.get("genres");

        String mal_id, url, mangaTitle,
                title_english, title_japanese, status,
                image_url, volumes, chapters,
                publishing, published, rank,
                scored_by,popularity, members,
                favorites, synopsis, background;


        mal_id = Optional.ofNullable(mangaJSON.get("mal_id")).map(JSONObject::toString).orElse("0");
        url = Optional.ofNullable(mangaJSON.get("url")).map(JSONObject::toString).orElse("0");
        mangaTitle = mangaJSON.get("animeTitle").toString();
        title_english = mangaJSON.get("title_english").toString();

        ArrayList<String> title_synonyms = new ArrayList<String>();
        for (int x = 0; x < serialization.size(); x++) {
            title_synonyms.add(
                    title_synonym.get(x).toString()
            );
        }

        title_japanese = Optional.ofNullable(mangaJSON.get("title_japanese")).map(JSONObject::toString).orElse("0");
        status = Optional.ofNullable(mangaJSON.get("status")).map(JSONObject::toString).orElse("0");
        image_url = Optional.ofNullable(mangaJSON.get("image_url")).map(JSONObject::toString).orElse("0");
        volumes = Optional.ofNullable(mangaJSON.get("volumes")).map(JSONObject::toString).orElse("0");
        chapters = Optional.ofNullable(mangaJSON.get("chapters")).map(JSONObject::toString).orElse("0");
        publishing = Optional.ofNullable(mangaJSON.get("publishing")).map(JSONObject::toString).orElse("0");
        published = Optional.ofNullable(mangaJSON.get("published")).map(JSONObject::toString).orElse("0");
        rank = Optional.ofNullable(mangaJSON.get("rank")).map(JSONObject::toString).orElse("0");
        scored_by = Optional.ofNullable(mangaJSON.get("scored_by")).map(JSONObject::toString).orElse("0");
        popularity = Optional.ofNullable(mangaJSON.get("popularity")).map(JSONObject::toString).orElse("0");
        members = Optional.ofNullable(mangaJSON.get("members")).map(JSONObject::toString).orElse("0");
        favorites = Optional.ofNullable(mangaJSON.get("favorites")).map(JSONObject::toString).orElse("0");
        synopsis = Optional.ofNullable(mangaJSON.get("synopsis")).map(JSONObject::toString).orElse("0");
        background = Optional.ofNullable(mangaJSON.get("background")).map(JSONObject::toString).orElse("0");
        ArrayList<String> genreList = new ArrayList<String>();

        for (Object genre : genres) {
            genreList.add(
                    ((JSONObject) genre).get("name").toString()
            );
        }
        ArrayList<String> serializations = new ArrayList<String>();
        for (int x = 0; x < serialization.size(); x++) {
            serializations.add(
                    serialization.get(x).toString()
            );
        }

        return new Manga(
                mal_id, url, mangaTitle,
                title_english,title_synonyms.trimToSize(), title_japanese, status,
                image_url, Integer.parseInt(volumes), Integer.parseInt(chapters),
                publishing, published, rank,
                scored_by,popularity, members,
                favorites, synopsis, background,
                genreList.toString(), serializations.toString());
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

