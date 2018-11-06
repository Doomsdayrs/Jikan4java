/*
 *
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * /
 */

/*
 *
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * /
 */

package com.github.Doomsdayrs.Jikan4java.types.Main.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Published.Published;
import com.github.Doomsdayrs.Jikan4java.types.Support.Authors;
import com.github.Doomsdayrs.Jikan4java.types.Support.Forum.Forum;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
import com.github.Doomsdayrs.Jikan4java.types.Support.MoreInfo;
import com.github.Doomsdayrs.Jikan4java.types.Support.News.News;
import com.github.Doomsdayrs.Jikan4java.types.Support.Pictures.Pictures;
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
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
/*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation,\n either version 3 of the License,\n or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,\n
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not,\n see <https://www.gnu.org/licenses/>.
*/
public class Manga {

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
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_english")
    private String title_english;
    @JsonProperty("title_synonyms")
    private ArrayList<String> title_synonyms;
    @JsonProperty("title_japanese")
    private String title_japanese;
    @JsonProperty("status")
    private String status;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("volumes")
    private int volumes;
    @JsonProperty("chapters")
    private int chapters;
    @JsonProperty("publishing")
    private boolean publishing;
    @JsonProperty("published")
    private Published published;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("score")
    private double score;
    @JsonProperty("scored_by")
    private int scored_by;
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
    @JsonProperty("related")
    private Related related;
    @JsonProperty("genres")
    private ArrayList<Genre> genres;
    @JsonProperty("authors")
    private ArrayList<Authors> authors;
    @JsonProperty("serializations")
    private ArrayList<Serializations> serializations;

    /**
     * Manga object constructor without variables
     */
    public Manga() {
    }


    public int getMal_id() {
        return mal_id;
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

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public ArrayList<String> getTitle_synonyms() {
        return title_synonyms;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public String getStatus() {
        return status;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getType() {
        return type;
    }

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public boolean isPublishing() {
        return publishing;
    }

    public Published getPublished() {
        return published;
    }

    public int getRank() {
        return rank;
    }

    public double getScore() {
        return score;
    }

    public int getScored_by() {
        return scored_by;
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

    public Related getRelated() {
        return related;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public ArrayList<Authors> getAuthors() {
        return authors;
    }

    public ArrayList<Serializations> getSerializations() {
        return serializations;
    }


    /**
     * Returns MangaCharacters object
     *
     * @return MangaCharacters
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public MangaCharacters getCharacters() throws IOException, ParseException {
        return new ObjectMapper().readValue(this.retrieve("characters").toJSONString(), MangaCharacters.class);
    }

    /**
     * Gets news about Manga
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
     * Gets pictures related to Manga
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
     * Gets stats about Manga object
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
     * Retrieves data from manga page
     *
     * @param subCategory What is needed to be retrieved, ie 'moreinfo'
     * @return JSONObject of the page
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    private JSONObject retrieve(String subCategory) throws IOException, ParseException {
        String baseURL = "https://api.jikan.moe/v3";
        Request request = new Request.Builder().url(baseURL + "/manga/" + mal_id + "/" + subCategory).build();
        Response response = new OkHttpClient().newCall(request).execute();
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(response.body().string());
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
