package com.github.doomsdayrs.jikan4java.model.main.character;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.model.support.VoiceActors;
import com.github.doomsdayrs.jikan4java.model.support.pictures.Pictures;

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
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Character extends Retriever {
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
    @JsonProperty("name")
    public String name;
    @JsonProperty("name_kanji")
    public String name_kanji;
    @JsonProperty("nicknames")
    public ArrayList<String> nicknames;
    @JsonProperty("about")
    public String about;
    @JsonProperty("member_favorites")
    public int member_favorites;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("animeography")
    public ArrayList<Animeography> animeography;
    @JsonProperty("mangaography")
    public ArrayList<Mangaography> mangaography;
    @JsonProperty("voice_actors")
    public ArrayList<VoiceActors> voice_actors;

    /**
     * Gets pictures
     *
     * @return pictures
     */
    @JsonProperty
    public CompletableFuture<Pictures> getPictures() {
        return retrieve(Pictures.class, baseURL + "/character/" + mal_id + "/pictures");
    }

    @Override
    public String toString() {
        return "Character{" +
                ",mal_id=" + mal_id +
                ",\n url='" + url + '\'' +
                ",\n name='" + name + '\'' +
                ",\n name_kanji='" + name_kanji + '\'' +
                ",\n nicknames=" + nicknames.toString() +
                ",\n about='" + about + '\'' +
                ",\n member_favorites=" + member_favorites +
                ",\n image_url='" + image_url + '\'' +
                ",\n animeography=" + animeography +
                ",\n mangaography=" + mangaography +
                ",\n voice_actors=" + voice_actors +
                '}';
    }
}
