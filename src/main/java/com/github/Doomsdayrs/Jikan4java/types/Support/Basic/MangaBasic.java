package com.github.Doomsdayrs.Jikan4java.types.Support.Basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;

import java.util.concurrent.CompletableFuture;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 * Jikan4java
 * 07 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class MangaBasic extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;

    @JsonProperty("url")
    public String url;

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("name")
    public String name;
    
    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     */
    public CompletableFuture<Manga> getManga() {
        return retrieve(Anime.class, baseURL + "/manga/" + mal_id);
    }

    @Override
    public String toString() {
        return "MangaBasic{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
