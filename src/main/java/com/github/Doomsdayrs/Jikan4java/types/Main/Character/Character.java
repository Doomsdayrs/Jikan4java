package com.github.Doomsdayrs.Jikan4java.types.Main.Character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Support.Pictures.Pictures;
import com.github.Doomsdayrs.Jikan4java.types.Support.Voice_actors;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Character {

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
    @JsonProperty("name")
    private String name;
    @JsonProperty("name_kanji")
    private String name_kanji;
    @JsonProperty("nicknames")
    private ArrayList<String> nicknames;// Nickname is an array
    @JsonProperty("about")
    private String about;
    @JsonProperty("member_favorites")
    private int member_favorites;
    @JsonProperty("image_url")
    private String image_url;
    // animeography is an object array thing
    @JsonProperty("animeography")
    private ArrayList<Animeography> animeography;
    // mangaography is an object array thing
    @JsonProperty("mangaography")
    private ArrayList<Mangaography> mangaography;
    // voice_actors is an object array thing
    @JsonProperty("voice_actors")
    private ArrayList<Voice_actors> voice_actors;

    public int getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getName_kanji() {
        return name_kanji;
    }

    public ArrayList<String> getNicknames() {
        return nicknames;
    }

    public String getAbout() {
        return about;
    }

    public int getMember_favorites() {
        return member_favorites;
    }

    public String getImage_url() {
        return image_url;
    }

    public ArrayList<Animeography> getAnimeography() {
        return animeography;
    }

    public ArrayList<Mangaography> getMangaography() {
        return mangaography;
    }

    public ArrayList<Voice_actors> getVoice_actors() {
        return voice_actors;
    }

    @JsonProperty
    public Pictures getPictures() throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();
        String baseURL = "https://api.jikan.moe/v3";
        Request request = new Request.Builder().url(baseURL + "/character/" + mal_id + "/pictures").build();
        Response response = client.newCall(request).execute();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().string());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonObject.toJSONString(), Pictures.class);
    }

    @Override
    public String toString() {
        return "Character{" +
                ",mal_id=" + mal_id +
                ",\n url='" + url + '\'' +
                ",\n name='" + name + '\'' +
                ",\n name_kanji='" + name_kanji + '\'' +
                ",\n nicknames=" + nicknames.toString() +
                ",\n about='" + about + '\'' +
                ",\n member_favorites=" + member_favorites +
                ",\n image_url='" + image_url + '\'' +
                ",\n animeography=" + animeography +
                ",\n mangaography=" + mangaography +
                ",\n voice_actors=" + voice_actors +
                '}';
    }
}
