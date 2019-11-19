package com.github.doomsdayrs.jikan4java.types.main.manga.mangapage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.main.manga.Manga;
import com.github.doomsdayrs.jikan4java.types.support.searchResults.ContentPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
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
 * ====================================================================*/

/**
 * Jikan4java
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class MangaPageManga extends ContentPage {

    public final boolean publishing;
    public final int chapters;
    public final int volumes;

    public MangaPageManga(@JsonProperty("mal_id") int mal_id,
                          @JsonProperty("url") String url,
                          @JsonProperty("image_url") String image_url,
                          @JsonProperty("title") String title,
                          @JsonProperty("synopsis") String synopsis,
                          @JsonProperty("type") String type,
                          @JsonProperty("score") double score,
                          @JsonProperty("start_date") String start_date,
                          @JsonProperty("end_date") String end_date,
                          @JsonProperty("members") int members,
                          @JsonProperty("publishing") boolean publishing,
                          @JsonProperty("chapters") int chapters,
                          @JsonProperty("volumes") int volumes) {
        super(mal_id, url, image_url, title, synopsis, type, score, start_date, end_date, members);
        this.publishing = publishing;
        this.chapters = chapters;
        this.volumes = volumes;
    }

    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     */
    public CompletableFuture<Manga> getManga() {
        return retrieve(Manga.class, baseURL + "/character/" + mal_id);
    }

    @Override
    public String toString() {
        return "MangaPageManga{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", title='" + title + '\'' +
                ", publishing=" + publishing +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
                ", chapters=" + chapters +
                ", volumes=" + volumes +
                ", score=" + score +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                '}';
    }
}
