package Jikan4java.connection;

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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Connect {
    // Request client
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";
    public Connect()
    {}
    /*
    * Quickly tests the api
    */
    public String test() throws IOException
    {
        Request request = new Request.Builder().url(baseURL).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    /*
    * Searches the API
    * @return JSONObject
    */
    public JSONObject search(String type,String search) throws IOException, ParseException {
        Request request = new Request.Builder().url(baseURL + "/search/"+type+"?q="+ search +"&page=1").build();
        Response response = client.newCall(request).execute();
        JSONParser parser = new JSONParser();

        JSONObject jsonObject = null;

        jsonObject = (JSONObject) parser.parse(response.body().string());
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        //request_hash
        JSONObject object =(JSONObject) jsonArray.get(0);
        return object;
    }
        //request:search:05d0a56266b3c5b1ecefb883a41235be572caed1
}
