package com.github.Doomsdayrs.Jikan4java.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.exceptions.RequestError;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;


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

    public CompletableFuture retrieve(Class target, String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                ResponseBody responseBody = client.newCall(builder.url(url).build()).execute().body();
                if (responseBody != null) {
                    JSONObject object = ((JSONObject) jsonParser.parse(responseBody.string()));
                    if (!object.containsKey("error"))
                        return objectMapper.readValue(object.toJSONString(), target);
                    else {
                        throw new CompletionException(new RequestError(object.get("error").toString()));
                    }
                } else return null;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
