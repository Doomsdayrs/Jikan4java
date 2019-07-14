package com.github.Doomsdayrs.Jikan4java.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.exceptions.RequestError;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/*
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 11 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Retriever {
    protected final String baseURL = "https://api.jikan.moe/v3";

    protected final OkHttpClient client;
    protected final ObjectMapper objectMapper;
    protected final JSONParser jsonParser;
    protected final Request.Builder builder;

    public Retriever() {
        client = new OkHttpClient();
        objectMapper = new ObjectMapper();
        jsonParser = new JSONParser();
        builder = new Request.Builder();
    }

    /**
     * Retriever constructor with custom OkHttpClient
     *
     * @param client Custom client
     */
    public Retriever(OkHttpClient client) {
        this.client = client;
        objectMapper = new ObjectMapper();
        jsonParser = new JSONParser();
        builder = new Request.Builder();
    }

    /**
     * Retriever constructor with custom objectMapper
     *
     * @param objectMapper customObject mapper
     */
    public Retriever(ObjectMapper objectMapper) {
        client = new OkHttpClient();
        this.objectMapper = objectMapper;
        jsonParser = new JSONParser();
        builder = new Request.Builder();
    }

    /**
     * Retriever constructor with custom jsonParser for whatever reason
     *
     * @param jsonParser custom jsonParser
     */
    public Retriever(JSONParser jsonParser) {
        client = new OkHttpClient();
        objectMapper = new ObjectMapper();
        this.jsonParser = jsonParser;
        builder = new Request.Builder();
    }

    /**
     * Retriever constructor with custom Request.Builder
     *
     * @param builder Custom Request.Builder
     */
    public Retriever(Request.Builder builder) {
        client = new OkHttpClient();
        objectMapper = new ObjectMapper();
        jsonParser = new JSONParser();
        this.builder = builder;
    }


    /**
     * Request builder
     *
     * @param url data to request
     * @return response from jikan
     * @throws IOException something went wrong
     */
    protected ResponseBody request(String url) throws IOException {
        URL u = new URL(url);
        Request request = builder.url(u).build();
        return client.newCall(request).execute().body();
    }

    /**
     * Connects to the jikan API and parses incoming data
     *
     * @param target what to parse into
     * @param url    apiURL
     * @return A completable future of the parsed response
     */
    public CompletableFuture retrieve(Class target, String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Retrieving: " + url);
                ResponseBody responseBody = request(url);
                if (responseBody != null) {
                    String response = responseBody.string();
                    JSONObject object = ((JSONObject) jsonParser.parse(response));
                    if (!object.containsKey("error"))
                        return objectMapper.readValue(object.toJSONString(), target);
                    else {
                        throw new CompletionException(new RequestError(object.get("error").toString()));
                    }
                } else {
                    System.out.println("Response body is null");
                    return null;
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}