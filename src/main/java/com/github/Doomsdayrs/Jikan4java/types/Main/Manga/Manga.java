package com.github.Doomsdayrs.Jikan4java.types.Main.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.connection.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Published.Published;
import com.github.Doomsdayrs.Jikan4java.types.Support.Authors;
import com.github.Doomsdayrs.Jikan4java.types.Support.Forum.Forum;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
import com.github.Doomsdayrs.Jikan4java.types.Support.MoreInfo;
import com.github.Doomsdayrs.Jikan4java.types.Support.News.News;
import com.github.Doomsdayrs.Jikan4java.types.Support.Pictures.Pictures;
import com.github.Doomsdayrs.Jikan4java.types.Support.Recommendations.RecommendationPage;
import com.github.Doomsdayrs.Jikan4java.types.Support.Related.Related;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Manga.MangaReviewPage;
import com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Stats;
import com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Manga.MangaUserUpdatesPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

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
public class Manga extends Retriever {
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
    @JsonProperty("title")
    public String title;
    @JsonProperty("title_english")
    public String title_english;
    @JsonProperty("title_synonyms")
    public ArrayList<String> title_synonyms;
    @JsonProperty("title_japanese")
    public String title_japanese;
    @JsonProperty("status")
    public String status;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("type")
    public String type;
    @JsonProperty("volumes")
    public int volumes;
    @JsonProperty("chapters")
    public int chapters;
    @JsonProperty("publishing")
    public boolean publishing;
    @JsonProperty("published")
    public Published published;
    @JsonProperty("rank")
    public int rank;
    @JsonProperty("score")
    public double score;
    @JsonProperty("scored_by")
    public int scored_by;
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
    @JsonProperty("related")
    public ArrayList<Related> related;
    @JsonProperty("genres")
    public ArrayList<Genre> genres;
    @JsonProperty("authors")
    public ArrayList<Authors> authors;
    @JsonProperty("serializations")
    public ArrayList<Serializations> serializations;

    /**
     * Returns MangaCharacters object
     *
     * @return MangaCharacters
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<MangaCharacters> getCharacters() throws IOException, ParseException {
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/characters");
    }

    /**
     * Gets news about Manga
     *
     * @return News object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<News> getNews() throws IOException, ParseException {
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/news");
    }

    /**
     * Gets pictures related to Manga
     *
     * @return Pictures object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Pictures> getPictures() throws IOException, ParseException {
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/pictures");
    }

    /**
     * Gets stats about Manga object
     *
     * @return Stats object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Stats> getStats() throws IOException, ParseException {
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/stats");
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
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/forum");
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
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/moreinfo");
    }

    /**
     * Gets manga reviews
     *
     * @return MangaReviewPage
     * @throws IOException
     * @throws ParseException
     */
    @JsonProperty
    public CompletableFuture<MangaReviewPage> getReviews() throws IOException, ParseException {
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/reviews");
    }

    /**
     * Gets recommendations for this manga
     * @return RecommendationPage
     * @throws IOException
     * @throws ParseException
     */
    @JsonProperty
    public CompletableFuture<RecommendationPage> getRecommendationPage() throws IOException, ParseException {
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/recommendations");
    }

    /**
     * Gets first page of user updates
     * @return MangaUserUpdatesPage
     * @throws IOException
     * @throws ParseException
     */
    @JsonProperty
    public CompletableFuture<MangaUserUpdatesPage> getUserUpdatesPage() throws IOException, ParseException {
        return getUserUpdatesPage(1);
    }

    /**
     * Gets a page of userUpdates
     * @param page
     * @return MangaUserUpdatesPage
     * @throws IOException
     * @throws ParseException
     */
    @JsonProperty
    public CompletableFuture<MangaUserUpdatesPage> getUserUpdatesPage(int page) throws IOException, ParseException {
        return retrieve(MangaCharacters.class, baseURL + "/manga/" + mal_id + "/userupdates/"+page);
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
