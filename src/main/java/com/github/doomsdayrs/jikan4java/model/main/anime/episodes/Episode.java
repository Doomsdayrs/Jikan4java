package com.github.doomsdayrs.jikan4java.model.main.anime.episodes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Episode {
    @JsonProperty("episode_id")
    @SuppressWarnings("WeakerAccess")
    public int episode_id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("title_japanese")
    public String title_japanese;

    @JsonProperty("title_romanji")
    @SuppressWarnings("WeakerAccess")
    public String title_romanji;

    @JsonProperty("aired")
    public String aired;
    //public Aired aired;

    @JsonProperty("filler")
    @SuppressWarnings("WeakerAccess")
    public boolean filler;

    @JsonProperty("recap")
    @SuppressWarnings("WeakerAccess")
    public boolean recap;

    @JsonProperty("video_url")
    public String video_url;

    @JsonProperty("forum_url")
    @SuppressWarnings("WeakerAccess")
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
