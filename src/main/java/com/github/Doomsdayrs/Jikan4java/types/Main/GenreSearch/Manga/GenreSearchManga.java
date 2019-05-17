package com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import com.github.Doomsdayrs.Jikan4java.types.Support.Authors;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
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
public class GenreSearchManga extends Retriever {

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
    @JsonProperty("publishing_start")
    public String publishing_start;
    @JsonProperty("volumes")
    public int volumes;
    @JsonProperty("members")
    public int members;
    @JsonProperty("genres")
    public ArrayList<Genre> genres;
    @JsonProperty("authors")
    public ArrayList<Authors> authors;
    @JsonProperty("score")
    public float score;
    @JsonProperty("serialization")
    public ArrayList<String> serialization;

    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     * @throws IOException
     * @throws ParseException
     */
    public CompletableFuture<Manga> getManga() {
        return retrieve(Manga.class, baseURL + "/manga/" + mal_id);
    }

    @Override
    public String toString() {
        return "GenreSearchManga{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
                ", publishing_start='" + publishing_start + '\'' +
                ", volumes=" + volumes +
                ", members=" + members +
                ", genres=" + genres +
                ", authors=" + authors +
                ", score=" + score +
                ", serialization=" + serialization +
                '}';
    }
}
