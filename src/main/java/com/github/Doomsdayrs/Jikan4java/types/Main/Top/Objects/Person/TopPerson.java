package com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.Person;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.TopList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class TopPerson extends TopList {
    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name_kanji")
    private String name_kanji;
    @JsonProperty("favorites")
    private int favorites;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("birthday")
    private String birthday;

    public int getMal_id() {
        return mal_id;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getName_kanji() {
        return name_kanji;
    }

    public int getFavorites() {
        return favorites;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getBirthday() {
        return birthday;
    }

    /**
     * Returns the Person object of this object
     *
     * @return Person Object
     * @throws IOException
     * @throws ParseException
     */
    public Person getPerson() throws IOException, ParseException {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/manga/" + mal_id).build()).execute().body().string())).toJSONString(), Person.class);
    }

    @Override
    public String toString() {
        return "TopPerson{" +
                "mal_id=" + mal_id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", name_kanji='" + name_kanji + '\'' +
                ", favorites=" + favorites +
                ", image_url='" + image_url + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
