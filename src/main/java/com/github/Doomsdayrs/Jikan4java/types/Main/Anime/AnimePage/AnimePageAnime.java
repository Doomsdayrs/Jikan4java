package com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
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
public class AnimePageAnime {
    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image_url")
    private String iconURL;
    @JsonProperty("title")
    private String title;
    @JsonProperty("airing")
    private boolean airing;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("type")
    private String type;
    @JsonProperty("episodes")
    private int episodes;
    @JsonProperty("score")
    private double score;
    @JsonProperty("source")
    private String source;
    @JsonProperty("start_date")
    private String start_date;
    @JsonProperty("end_date")
    private String end_date;
    @JsonProperty("members")
    private int members;
    @JsonProperty("rated")
    private String rated;

    /**
     * Get MAL id
     *
     * @return MAL ID int
     */
    public int getMal_id() {
        return mal_id;
    }

    /**
     * Gets url
     *
     * @return url string
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets icon url
     * @return url string
     */
    public String getIconURL() {
        return iconURL;
    }

    /**
     * Gets title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Is the anime airing?
     * @return airing?
     */
    public boolean isAiring() {
        return airing;
    }

    /**
     * Synopsis of the anime
     * @return synopsis string
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Type of anime
     * @return type of anime
     */
    public String getType() {
        return type;
    }

    /**
     * Episode count
     * @return # of episodes
     */
    public int getEpisodes() {
        return episodes;
    }

    /**
     * Score of anime
     * @return score
     */
    public double getScore() {
        return score;
    }

    /**
     * Source of anime
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * Gets start date
     * @return start date
     */
    public String getStart_date() {
        return start_date;
    }

    /**
     * Gets end date
     * @return end date
     */
    public String getEnd_date() {
        return end_date;
    }

    /**
     * Gets members
     * @return # of members
     */
    public int getMembers() {
        return members;
    }

    /**
     * Rating of anime
     * @return rating
     */
    public String getRated() {
        return rated;
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
        return "AnimePageAnime{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", iconURL='" + iconURL + '\'' +
                ", title='" + title + '\'' +
                ", airing=" + airing +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                ", episodes=" + episodes +
                ", score=" + score +
                ", source='" + source + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                ", rated='" + rated + '\'' +
                '}';
    }
}
