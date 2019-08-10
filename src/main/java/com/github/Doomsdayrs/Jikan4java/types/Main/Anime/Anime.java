package com.github.Doomsdayrs.Jikan4java.types.Main.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
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
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */

public class Anime extends Retriever {
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
     */
    @JsonProperty
    public CompletableFuture<Character_Staff> getCharacterStaffs() {
        return retrieve(Character_Staff.class, baseURL + "/anime/" + mal_id + "/characters_staff");
    }


    /**
     * Gets episodes, Please be aware that if the amount of episodes is greater than 100, the episode list will be split into two pages.
     *
     * @return Episode object
     */
    @JsonProperty
    public CompletableFuture<Episodes> getEpisode(int pageNumber) {
        String category = "/episodes";
        if (pageNumber != 0) {
            category = "/episodes/" + pageNumber;
        }
        String finalCategory = category;
        return retrieve(Episodes.class, baseURL + "/anime/" + mal_id + finalCategory);
    }

    @JsonProperty
    public CompletableFuture<Episodes> getEpisode() {
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
    public CompletableFuture<News> getNews() {
        return retrieve(News.class, baseURL + "/anime/" + mal_id + "/news");
    }

    /**
     * Gets pictures related to anime
     *
     * @return Pictures object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Pictures> getPictures() {
        return retrieve(Pictures.class, baseURL + "/anime/" + mal_id + "/pictures");
    }

    /**
     * Gets videos related to anime
     *
     * @return Pictures object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Video> getVideos() {
        return retrieve(Video.class, baseURL + "/anime/" + mal_id + "/videos");
    }

    /**
     * Gets stats about anime object
     *
     * @return Stats object
     */
    @JsonProperty
    public CompletableFuture<Stats> getStats() {
        return retrieve(Stats.class, baseURL + "/anime/" + mal_id + "/stats");
    }


    /**
     * Returns forum object
     *
     * @return Forum object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Forum> getForum() {
        return retrieve(Forum.class, baseURL + "/anime/" + mal_id + "/forum");
    }

    /**
     * Returns Moreinfo object
     *
     * @return MoreInfo
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<MoreInfo> getMoreInfo() {
        return retrieve(MoreInfo.class, baseURL + "/anime/" + mal_id + "/moreinfo");
    }


    @JsonProperty
    public CompletableFuture<AnimeReviewPage> getReviewPage() {
        return retrieve(AnimeReviewPage.class, baseURL + "/anime/" + mal_id + "/reviews");
    }

    @JsonProperty
    public CompletableFuture<RecommendationPage> getRecommendationPage() {
        return retrieve(RecommendationPage.class, baseURL + "/anime/" + mal_id + "/recommendations");
    }

    @JsonProperty
    public CompletableFuture<AnimeUserUpdatesPage> getUserUpdatesPage() {
        return getUserUpdatesPage(0);
    }



    @JsonProperty
    public CompletableFuture<AnimeUserUpdatesPage> getUserUpdatesPage(int page) {
        return retrieve(AnimeUserUpdatesPage.class, baseURL + "/anime/" + mal_id + "/userupdates/" + page);
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
                ",\n subType='" + type + '\'' +
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
