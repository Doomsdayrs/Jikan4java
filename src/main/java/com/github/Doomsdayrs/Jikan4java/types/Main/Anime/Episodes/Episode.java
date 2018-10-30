package com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Episodes;
/*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Aired;

/**
 * Jikan4java
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Episode {
    @JsonProperty("episode_id")
    private int episode_id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("title_japanese")
    private String title_japanese;

    @JsonProperty("title_romanji")
    private String title_romanji;

    @JsonProperty("aired")
    private Aired aired;

    @JsonProperty("filler")
    private boolean filler;

    @JsonProperty("recap")
    private boolean recap;

    @JsonProperty("video_url")
    private String video_url;

    @JsonProperty("forum_url")
    private String forum_url;

    public int getEpisode_id() {
        return episode_id;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public String getTitle_romanji() {
        return title_romanji;
    }

    public Aired getAired() {
        return aired;
    }

    public boolean isFiller() {
        return filler;
    }

    public boolean isRecap() {
        return recap;
    }

    public String getVideo_url() {
        return video_url;
    }

    public String getForum_url() {
        return forum_url;
    }

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
