package com.github.Doomsdayrs.Jikan4java.types.Main.Manga.MangaPage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class MangaPageManga {
    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image_url")
    private String iconURL;
    @JsonProperty("title")
    private String title;
    @JsonProperty("publishing")
    private boolean publishing;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("type")
    private String type;
    @JsonProperty("chapters")
    private int chapters;
    @JsonProperty("volumes")
    private int volumes;
    @JsonProperty("score")
    private double score;
    @JsonProperty("start_date")
    private String start_date;
    @JsonProperty("end_date")
    private String end_date;
    @JsonProperty("members")
    private int members;

    public int getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getIconURL() {
        return iconURL;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublishing() {
        return publishing;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getType() {
        return type;
    }

    public int getChapters() {
        return chapters;
    }

    public int getVolumes() {
        return volumes;
    }

    public double getScore() {
        return score;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public int getMembers() {
        return members;
    }

    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     * @throws IOException
     * @throws ParseException
     */
    public Manga getManga() throws IOException, ParseException {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/character/" + mal_id).build()).execute().body().string())).toJSONString(), Manga.class);
    }

    @Override
    public String toString() {
        return "MangaPageManga{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", iconURL='" + iconURL + '\'' +
                ", title='" + title + '\'' +
                ", publishing=" + publishing +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                ", chapters=" + chapters +
                ", volumes=" + volumes +
                ", score=" + score +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                '}';
    }
}
