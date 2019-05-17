package com.github.Doomsdayrs.Jikan4java.types.Main.Schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
import com.github.Doomsdayrs.Jikan4java.types.Support.Producer;
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
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class SubAnime extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("url")
    public String url;
    @JsonProperty("title")
    public String title;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("synopsis")
    public String synopsis;
    @JsonProperty("type")
    public String type;
    @JsonProperty("airing_start")
    public String airing_start;
    @JsonProperty("episodes")
    public int episodes;
    @JsonProperty("members")
    public int members;
    @JsonProperty("genres")
    public ArrayList<Genre> genres;
    @JsonProperty("source")
    public String source;
    @JsonProperty("producers")
    public ArrayList<Producer> producers;
    @JsonProperty("score")
    public float score;
    @JsonProperty("licensors")
    public ArrayList<String> licensors;
    @JsonProperty("r18")
    public boolean r18;
    @JsonProperty("kids")
    public boolean kids;


    /**
     * Returns the Anime object of this object
     *
     * @return Anime Object
     * @throws IOException
     * @throws ParseException
     */
    public CompletableFuture<Anime> getAnime() throws IOException, ParseException {
        return retrieve(Anime.class, baseURL + "/anime/" + mal_id);
    }

    @Override
    public String toString() {
        return "GenreSearchAnime{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
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
