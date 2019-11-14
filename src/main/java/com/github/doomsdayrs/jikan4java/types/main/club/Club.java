package com.github.doomsdayrs.jikan4java.types.main.club;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.types.support.basic.BasicMeta;
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
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Club extends Retriever {

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
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("title")
    public String title;
    @JsonProperty("members_count")
    public float members_count;
    @JsonProperty("pictures_count")
    public float pictures_count;
    @JsonProperty("category")
    public String category;
    @JsonProperty("created")
    public String created;
    @JsonProperty("type")
    public String type;
    @JsonProperty("staff")
    public ArrayList<BasicMeta> staff;
    @JsonProperty("anime_relations")
    public ArrayList<BasicMeta> anime_relations;
    @JsonProperty("manga_relations")
    public ArrayList<BasicMeta> manga_relations;
    @JsonProperty("character_relations")
    public ArrayList<BasicMeta> character_relations;

    @JsonProperty
    public CompletableFuture<ClubMemberPage> getMembers() throws IOException, ParseException {
        return retrieve(ClubMemberPage.class, baseURL + "/club/" + mal_id + "/members");
    }


    @Override
    public String toString() {
        return "Club{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", title=" + title +
                ", members_count=" + members_count +
                ", pictures_count=" + pictures_count +
                ", category='" + category + '\'' +
                ", created='" + created + '\'' +
                ", subType='" + type + '\'' +
                ", staff=" + staff +
                ", anime_relations=" + anime_relations +
                ", manga_relations=" + manga_relations +
                ", character_relations=" + character_relations +
                '}';
    }
}
