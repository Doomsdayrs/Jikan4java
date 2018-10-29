package com.github.Doomsdayrs.Jikan4java.connection.Person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.Person;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.text.ParseException;

public class PersonConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";

    public Person search(String title) throws IOException, org.json.simple.parser.ParseException {
        JSONObject personJSON = this.searchSite(title);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(personJSON.toJSONString(), Person.class);
    }


    /**
     * Searches Jikan api for manga
     *
     * @param search The name of what you are searching for
     * @return Returns an JSON object of the first result
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    private JSONObject searchSite(String search) throws IOException, org.json.simple.parser.ParseException {
        Request request = new Request.Builder().url(baseURL + "/search/person?q=" + search + "&page=1").build();
        Response response = client.newCall(request).execute();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().string());
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        // Gets anime ID then goes to it's page
        request = new Request.Builder().url(baseURL + "/person/" + ((JSONObject) jsonArray.get(0)).get("mal_id").toString()).build();
        response = client.newCall(request).execute();

        return (JSONObject) parser.parse(response.body().string());
    }

    /**
     * Test method
     *
     * @throws IOException IOException
     */
    public void test() throws IOException, org.json.simple.parser.ParseException {
        System.out.println(this.searchSite("Hajime Isayama").toJSONString());
    }
}
