package com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Episodes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Aired;

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Episode {
    @JsonProperty("episode_id")
    public int episode_id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("title_japanese")
    public String title_japanese;

    @JsonProperty("title_romanji")
    public String title_romanji;

    @JsonProperty("aired")
    public Aired aired;

    @JsonProperty("filler")
    public boolean filler;

    @JsonProperty("recap")
    public boolean recap;

    @JsonProperty("video_url")
    public String video_url;

    @JsonProperty("forum_url")
    public String forum_url;
    

    @Override
    public String toString() {
        return "Episode{" +
                "episode_id=" + episode_id +
                ", title='" + title + '\'' +
                ", title_japanese='" + title_japanese + '\'' +
                ", title_romanji='" + title_romanji + '\'' +
                ", aired=" + aired +
                ", filler=" + filler +
                ", recap=" + recap +
                ", video_url='" + video_url + '\'' +
                ", forum_url='" + forum_url + '\'' +
                '}';
    }
}
