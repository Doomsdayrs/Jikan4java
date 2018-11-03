package com.github.Doomsdayrs.Jikan4java.types.Main.Schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
import com.github.Doomsdayrs.Jikan4java.types.Support.Producer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Jikan4java
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
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
*/public class SubAnime {
    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("type")
    private String type;
    @JsonProperty("airing_start")
    private String airing_start;
    @JsonProperty("episodes")
    private int episodes;
    @JsonProperty("members")
    private int members;
    @JsonProperty("genres")
    private ArrayList<Genre> genres;
    @JsonProperty("source")
    private String source;
    @JsonProperty("producers")
    private ArrayList<Producer> producers;
    @JsonProperty("score")
    private float score;
    @JsonProperty("licensors")
    private ArrayList<String> licensors;
    @JsonProperty("r18")
    private boolean r18;
    @JsonProperty("kids")
    private boolean kids;


    public int getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getType() {
        return type;
    }

    public String getAiring_start() {
        return airing_start;
    }

    public int getEpisodes() {
        return episodes;
    }

    public int getMembers() {
        return members;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public String getSource() {
        return source;
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }

    public float isScore() {
        return score;
    }

    public ArrayList<String> getLicensors() {
        return licensors;
    }

    public boolean isR18() {
        return r18;
    }

    public boolean isKids() {
        return kids;
    }


    /**
     * Returns the Anime object of this object
     *
     * @return Anime Object
     * @throws IOException
     * @throws ParseException
     */
    public Anime getAnime() throws IOException, ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/anime/" + mal_id).build()).execute().body().string())).toJSONString(), Anime.class);
    }

    @Override
    public String toString() {
        return "GenreSearchAnime{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                ", airing_start='" + airing_start + '\'' +
                ", episodes=" + episodes +
                ", members=" + members +
                ", genres=" + genres +
                ", source='" + source + '\'' +
                ", producers=" + producers +
                ", score=" + score +
                ", licensors=" + licensors +
                ", r18=" + r18 +
                ", kids=" + kids +
                '}';
    }
}
