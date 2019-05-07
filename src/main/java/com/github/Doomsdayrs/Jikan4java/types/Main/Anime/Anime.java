package com.github.Doomsdayrs.Jikan4java.types.Main.Anime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Character_staff.Character_Staff;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Episodes.Episodes;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Videos.Video;
import com.github.Doomsdayrs.Jikan4java.types.Support.Forum.Forum;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
import com.github.Doomsdayrs.Jikan4java.types.Support.MoreInfo;
import com.github.Doomsdayrs.Jikan4java.types.Support.News.News;
import com.github.Doomsdayrs.Jikan4java.types.Support.Pictures.Pictures;
import com.github.Doomsdayrs.Jikan4java.types.Support.Producer;
import com.github.Doomsdayrs.Jikan4java.types.Support.Recommendations.RecommendationPage;
import com.github.Doomsdayrs.Jikan4java.types.Support.Related.Related;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Anime.AnimeReviewPage;
import com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Stats;
import com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Anime.AnimeUserUpdatesPage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

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

public class Anime {

    @JsonIgnore
    private final ObjectMapper mapper = new ObjectMapper();

    @JsonProperty("request_hash")
    public String request_hash;
    @JsonProperty("request_cached")
    public boolean request_cached;
    @JsonProperty("request_cache_expiry")
    public int request_cache_expiry;
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("url")
    public String url;
    @JsonProperty("trailer_url")
    public String trailer_url;
    @JsonProperty("title")
    public String title;
    @JsonProperty("title_english")
    public String title_english;
    @JsonProperty("title_japanese")
    public String title_japanese;
    @JsonProperty("title_synonyms")
    public ArrayList<String> title_synonyms;
    @JsonProperty("type")
    public String type;
    @JsonProperty("source")
    public String source;
    @JsonProperty("episodes")
    public int episodes;
    @JsonProperty("status")
    public String status;
    @JsonProperty("aired")
    public Aired aired;
    @JsonProperty("airing")
    public boolean airing;
    @JsonProperty("duration")
    public String duration;
    @JsonProperty("rating")
    public String rating;
    @JsonProperty("score")
    public double score;
    @JsonProperty("scored_by")
    public int scored_by;
    @JsonProperty("rank")
    public int rank;
    @JsonProperty("popularity")
    public int popularity;
    @JsonProperty("members")
    public int members;
    @JsonProperty("favorites")
    public int favorites;
    @JsonProperty("synopsis")
    public String synopsis;
    @JsonProperty("background")
    public String background;
    @JsonProperty("premiered")
    public String premiered;
    @JsonProperty("broadcast")
    public String broadcast;

    @JsonProperty("related")
    public Related related;
    @JsonProperty("producers")
    public ArrayList<Producer> producers;
    @JsonProperty("licensors")
    public ArrayList<Licensors> licensors;
    @JsonProperty("studios")
    public ArrayList<Studios> studios;
    @JsonProperty("genres")
    public ArrayList<Genre> genres;
    @JsonProperty("opening_themes")
    public ArrayList<String> opening_themes;
    @JsonProperty("ending_themes")
    public ArrayList<String> ending_themes;
    @JsonProperty("image_url")
    public String imageURL;

    /**
     * Anime object constructor without variables
     */
    public Anime() {
    }

    /**
     * Gets character and staff object
     *
     * @return Character_Staff
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Character_Staff> getCharacterStaffs() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("characters_staff").toJSONString(), Character_Staff.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });
    }


    /**
     * Gets episodes, Please be aware that if the amount of episodes is greater than 100, the episode list will be split into two pages.
     *
     * @return Episode object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Episodes> getEpisode(int pageNumber) throws IOException, ParseException {
        String category = "episodes";
        if (pageNumber != 0) {
            category = "episodes/" + pageNumber;
        }
        String finalCategory = category;
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve(finalCategory).toJSONString(), Episodes.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });
    }

    @JsonProperty
    public CompletableFuture<Episodes> getEpisode() throws IOException, ParseException {
        return getEpisode(0);
    }


    /**
     * Gets news about anime
     *
     * @return News object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<News> getNews() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("news").toJSONString(), News.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });
    }

    /**
     * Gets pictures related to anime
     *
     * @return Pictures object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Pictures> getPictures() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("pictures").toJSONString(), Pictures.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }

    /**
     * Gets videos related to anime
     *
     * @return Pictures object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Video> getVideos() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("videos").toJSONString(), Video.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }

    /**
     * Gets stats about anime object
     *
     * @return Stats object
     */
    @JsonProperty
    public CompletableFuture<Stats> getStats() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("stats").toJSONString(), Stats.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }


    /**
     * Returns forum object
     *
     * @return Forum object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Forum> getForum() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("forum").toJSONString(), Forum.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }

    /**
     * Returns Moreinfo object
     *
     * @return MoreInfo
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<MoreInfo> getMoreInfo() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("moreinfo").toJSONString(), MoreInfo.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }


    @JsonProperty
    public CompletableFuture<AnimeReviewPage> getReviewPage() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("reviews").toJSONString(), AnimeReviewPage.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }

    @JsonProperty
    public CompletableFuture<RecommendationPage> getRecommendationPage() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("recommendations").toJSONString(), RecommendationPage.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }

    @JsonProperty
    public CompletableFuture<AnimeUserUpdatesPage> getUserUpdatesPage() throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("userupdates").toJSONString(), AnimeUserUpdatesPage.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

    }

    @JsonProperty
    public CompletableFuture<AnimeUserUpdatesPage> getUserUpdatesPage(int page) throws IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return mapper.readValue(this.retrieve("userupdates/" + page).toJSONString(), AnimeUserUpdatesPage.class);
            } catch (IOException | ParseException e) {
                throw new CompletionException(e);
            }
        });

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
        String responseString = response.body().string();
        if (!responseString.equals(null))
            return (JSONObject) parser.parse(responseString);
        else return null;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "request_hash='" + request_hash + '\'' +
                ",\n request_cached=" + request_cached +
                ",\n request_cache_expiry=" + request_cache_expiry +
                ",\n mal_id=" + mal_id +
                ",\n url='" + url + '\'' +
                ",\n iconURL='" + imageURL + '\'' +
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
