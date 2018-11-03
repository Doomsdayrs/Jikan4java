package com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.TopList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Jikan4java
 * 01 / November / 2018
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
*/
public class TopAnime extends TopList {
    @JsonProperty("mal_id")
    private int mal_id;

    @JsonProperty("rank")
    private int rank;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("type")
    private String type;

    @JsonProperty("episodes")
    private int episodes;

    @JsonProperty("start_date")
    private String start_date;

    @JsonProperty("end_date")
    private String end_date;

    @JsonProperty("members")
    private int members;

    @JsonProperty("score")
    private float score;

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

    public String getImage_url() {
        return image_url;
    }

    public String getType() {
        return type;
    }

    public int getEpisodes() {
        return episodes;
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

    public float getScore() {
        return score;
    }

    /**
     * Returns the Anime object of this object
     *
     * @return Anime Object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Anime getAnime() throws IOException, ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/anime/" + mal_id).build()).execute().body().string())).toJSONString(), Anime.class);
    }

    @Override
    public String toString() {
        return "TopAnime{" +
                "mal_id=" + mal_id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", type='" + type + '\'' +
                ", episodes=" + episodes +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                ", score=" + score +
                '}';
    }
}
