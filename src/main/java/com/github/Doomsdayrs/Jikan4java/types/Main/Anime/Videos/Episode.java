package com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Videos;

/**
 * Jikan4java
 * 30 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
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

public class Episode {
    @JsonProperty("title")
    private String title;

    @JsonProperty("episode")
    private String episode;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String image_url;

    public String getTitle() {
        return title;
    }

    public String getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "title='" + title + '\'' +
                ", episode='" + episode + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
