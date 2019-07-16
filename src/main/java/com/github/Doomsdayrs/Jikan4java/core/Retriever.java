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
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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