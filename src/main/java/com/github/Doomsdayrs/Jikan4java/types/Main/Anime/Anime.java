package com.github.Doomsdayrs.Jikan4java.types.Main.Anime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Character_staff.Character_Staff;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Episodes.Episodes;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Videos.Video;
import com.github.Doomsdayrs.Jikan4java.types.Support.Forum.Forum;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
import com.github.Doomsdayrs.Jikan4java.types.Support.MALData;
import com.github.Doomsdayrs.Jikan4java.types.Support.MoreInfo;
import com.github.Doomsdayrs.Jikan4java.types.Support.News.News;
import com.github.Doomsdayrs.Jikan4java.types.Support.Pictures.Pictures;
import com.github.Doomsdayrs.Jikan4java.types.Support.Producer;
import com.github.Doomsdayrs.Jikan4java.types.Support.Related.Related;
import com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Stats;
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
public class Anime extends MALData {

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
    @JsonProperty("image_url")
    private String iconURL;
    @JsonProperty("trailer_url")
    private String trailer_url;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_english")
    private String title_english;
    @JsonProperty("title_japanese")
    private String title_japanese;
    @JsonProperty("title_synonyms")
    private ArrayList<String> title_synonyms;
    @JsonProperty("type")
    private String type;
    @JsonProperty("source")
    private String source;
    @JsonProperty("episodes")
    private int episodes;
    @JsonProperty("status")
    private String status;
    @JsonProperty("aired")
    private Aired aired;
    @JsonProperty("airing")
    private boolean airing;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("score")
    private double score;
    @JsonProperty("scored_by")
    private int scored_by;
    @JsonProperty("rank")
    private int rank;
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
    @JsonProperty("premiered")
    private String premiered;
    @JsonProperty("broadcast")
    private String broadcast;
    @JsonProperty("related")
    private ArrayList<Related> related;
    @JsonProperty("producers")
    private ArrayList<Producer> producers;
    @JsonProperty("licensors")
    private ArrayList<Licensors> licensors;
    @JsonProperty("studios")
    private ArrayList<Studios> studios;
    @JsonProperty("genres")
    private ArrayList<Genre> genres;
    @JsonProperty("opening_themes")
    private ArrayList<String> opening_themes;
    @JsonProperty("ending_themes")
    private ArrayList<String> ending_themes;

    /**
     * Anime object constructor without variables
     */
    public Anime() {
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

    public int getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getIconURL() {
        return iconURL;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public ArrayList<String> getTitle_synonyms() {
        return title_synonyms;
    }

    public String getType() {
        return type;
    }

    public String getSource() {
        return source;
    }

    public int getEpisodes() {
        return episodes;
    }

    public String getStatus() {
        return status;
    }

    public Aired getAired() {
        return aired;
    }

    public boolean isAiring() {
        return airing;
    }

    public String getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }

    public double getScore() {
        return score;
    }

    public int getScored_by() {
        return scored_by;
    }

    public int getRank() {
        return rank;
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

    public String getPremiered() {
        return premiered;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public ArrayList<Related> getRelated() {
        return related;
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }

    public ArrayList<Licensors> getLicensors() {
        return licensors;
    }

    public ArrayList<Studios> getStudios() {
        return studios;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public ArrayList<String> getOpening_themes() {
        return opening_themes;
    }

    public ArrayList<String> getEnding_themes() {
        return ending_themes;
    }

    /**
     * Gets character and staff object
     *
     * @return Character_Staff
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public Character_Staff getCharacterStaffs() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("characters_staff").toJSONString(), Character_Staff.class);
    }


    /**
     * Gets episodes, Please be aware that if the amount of episodes is greater than 100, the episode list will be split into two pages.
     *
     * @return Episode object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public Episodes getEpisode(int pageNumber) throws IOException, ParseException {
        String category = "episodes";
        if (pageNumber != 0) {
            category = "episodes/" + pageNumber;
        }
        return new ObjectMapper().readValue(this.retrieve(category).toJSONString(), Episodes.class);
    }

    /**
     * Gets news about anime
     *
     * @return News object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public News getNews() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("news").toJSONString(), News.class);
    }

    /**
     * Gets pictures related to anime
     *
     * @return Pictures object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public Pictures getPictures() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("pictures").toJSONString(), Pictures.class);
    }

    /**
     * Gets videos related to anime
     *
     * @return Pictures object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public Video getVideos() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("videos").toJSONString(), Video.class);
    }

    /**
     * Gets stats about anime object
     *
     * @return Stats object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public Stats getStats() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("stats").toJSONString(), Stats.class);
    }


    /**
     * Returns forum object
     *
     * @return Forum object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public Forum getForum() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("forum").toJSONString(), Forum.class);
    }

    /**
     * Returns Moreinfo object
     *
     * @return MoreInfo
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public MoreInfo getMoreInfo() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("moreinfo").toJSONString(), MoreInfo.class);
    }

    /**
     * Retrieves data from anime page
     *
     * @param subCategory What is needed to be retrieved, ie 'moreinfo'
     * @return JSONObject of the page
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    private JSONObject retrieve(String subCategory) throws IOException, ParseException {
        String baseURL = "https://api.jikan.moe/v3";
        Request request = new Request.Builder().url(baseURL + "/anime/" + mal_id + "/" + subCategory).build();
        Response response = new OkHttpClient().newCall(request).execute();
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(response.body().string());
    }

    @Override
    public String toString() {
        return "Anime{" +
                "request_hash='" + request_hash + '\'' +
                ",\n request_cached=" + request_cached +
                ",\n request_cache_expiry=" + request_cache_expiry +
                ",\n mal_id=" + mal_id +
                ",\n url='" + url + '\'' +
                ",\n iconURL='" + iconURL + '\'' +
                ",\n trailer_url='" + trailer_url + '\'' +
                ",\n title='" + title + '\'' +
                ",\n title_english='" + title_english + '\'' +
                ",\n title_japanese='" + title_japanese + '\'' +
                ",\n title_synonyms=" + title_synonyms +
                ",\n type='" + type + '\'' +
                ",\n source='" + source + '\'' +
                ",\n episodes=" + episodes +
                ",\n status='" + status + '\'' +
                ",\n aired=" + aired +
                ",\n airing=" + airing +
                ",\n duration='" + duration + '\'' +
                ",\n rating='" + rating + '\'' +
                ",\n score=" + score +
                ",\n scored_by=" + scored_by +
                ",\n rank=" + rank +
                ",\n popularity=" + popularity +
                ",\n members=" + members +
                ",\n favorites=" + favorites +
                ",\n synopsis='" + synopsis + '\'' +
                ",\n background='" + background + '\'' +
                ",\n premiered='" + premiered + '\'' +
                ",\n broadcast='" + broadcast + '\'' +
                ",\n related=" + related +
                ",\n producers=" + producers +
                ",\n licensors=" + licensors +
                ",\n studios=" + studios +
                ",\n genres=" + genres +
                ",\n opening_themes=" + opening_themes +
                ",\n ending_themes=" + ending_themes +
                '}';
    }
}
