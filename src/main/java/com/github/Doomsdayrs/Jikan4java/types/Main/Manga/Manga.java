package com.github.Doomsdayrs.Jikan4java.types.Main.Manga;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Published.Published;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genres;
import com.github.Doomsdayrs.Jikan4java.types.Support.Related.Related;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
/*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation,\n either version 3 of the License,\n or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,\n
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not,\n see <https://www.gnu.org/licenses/>.
*/
public class Manga {

    @JsonIgnore
    private final String baseURL = "https://api.jikan.moe/v3";
    @JsonProperty("request_hash")
    private String request_hash;
    @JsonProperty("request_cached")
    private boolean request_cached;
    @JsonProperty("request_cache_expiry")
    private int request_cache_expiry;
    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_english")
    private String title_english;
    @JsonProperty("title_synonyms")
    private ArrayList<String> title_synonyms;
    @JsonProperty("title_japanese")
    private String title_japanese;
    @JsonProperty("status")
    private String status;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("volumes")
    private int volumes;
    @JsonProperty("chapters")
    private int chapters;
    @JsonProperty("publishing")
    private boolean publishing;
    @JsonProperty("published")
    private Published published;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("score")
    private double score;
    @JsonProperty("scored_by")
    private int scored_by;
    @JsonProperty("popularity")
    private int popularity;
    @JsonProperty("members")
    private int members;
    @JsonProperty("favorites")
    private int favorites;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("background")
    private String background;
    @JsonProperty("related")
    private Related related;
    @JsonProperty("genres")
    private ArrayList<Genres> genres;
    @JsonProperty("authors")
    private ArrayList<Authors> authors;
    @JsonProperty("serializations")
    private ArrayList<Serializations> serializations;

    /**
     * Manga object constructor without variables
     */
    public Manga() {
    }


    public int getMal_id() {
        return mal_id;
    }

    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public ArrayList<String> getTitle_synonyms() {
        return title_synonyms;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public String getStatus() {
        return status;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getType() {
        return type;
    }

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public boolean isPublishing() {
        return publishing;
    }

    public Published getPublished() {
        return published;
    }

    public int getRank() {
        return rank;
    }

    public double getScore() {
        return score;
    }

    public int getScored_by() {
        return scored_by;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getMembers() {
        return members;
    }

    public int getFavorites() {
        return favorites;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getBackground() {
        return background;
    }

    public Related getRelated() {
        return related;
    }

    public ArrayList<Genres> getGenres() {
        return genres;
    }

    public ArrayList<Authors> getAuthors() {
        return authors;
    }

    public ArrayList<Serializations> getSerializations() {
        return serializations;
    }

    @JsonProperty
    public MangaCharacters getCharacters() throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(baseURL + "/manga/" + mal_id + "/characters").build();
        Response response = client.newCall(request).execute();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().string());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonObject.toJSONString(), MangaCharacters.class);
    }

    @Override
    public String toString() {
        return "Manga{" +
                ",mal_id=" + mal_id +
                ",\n url='" + url + '\'' +
                ",\n title='" + title + '\'' +
                ",\n title_english='" + title_english + '\'' +
                ",\n title_synonyms=" + title_synonyms +
                ",\n title_japanese='" + title_japanese + '\'' +
                ",\n status='" + status + '\'' +
                ",\n image_url='" + image_url + '\'' +
                ",\n type='" + type + '\'' +
                ",\n volumes=" + volumes +
                ",\n chapters=" + chapters +
                ",\n publishing=" + publishing +
                ",\n published=" + published +
                ",\n rank=" + rank +
                ",\n score=" + score +
                ",\n scored_by=" + scored_by +
                ",\n popularity=" + popularity +
                ",\n members=" + members +
                ",\n favorites=" + favorites +
                ",\n synopsis='" + synopsis + '\'' +
                ",\n background='" + background + '\'' +
                ",\n related=" + related +
                ",\n genres=" + genres +
                ",\n authors=" + authors +
                ",\n serializations=" + serializations +
                '}';
    }
}
