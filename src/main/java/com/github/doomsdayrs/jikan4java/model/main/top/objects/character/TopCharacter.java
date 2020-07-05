package com.github.doomsdayrs.jikan4java.model.main.top.objects.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.model.main.character.Character;
import com.github.doomsdayrs.jikan4java.model.main.top.TopListingBeing;

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
 * ====================================================================*/

/**
 * Jikan4java
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class TopCharacter extends TopListingBeing {
    @JsonProperty("animeography")
    public ArrayList<TopCharacterAnime> characterAnimes;
    @JsonProperty("mangaography")
    public ArrayList<TopCharacterManga> characterMangas;
    public TopCharacter(@JsonProperty("mal_id") int mal_id, @JsonProperty("rank") int rank, @JsonProperty("title") String title, @JsonProperty("url") String url, @JsonProperty("favorites") int favorites, @JsonProperty("name_kanji") String name_kanji, @JsonProperty("image_url") String image_url) {
        super(mal_id, rank, title, url, favorites, name_kanji, image_url);
    }

    /**
     * Returns the Character object of this object
     *
     * @return Character Object
     */
    public CompletableFuture<Character> getCharacter() {
        return retrieve(Character.class, baseURL + "/character/" + mal_id);
    }

    @Override
    public String toString() {
        return "TopCharacter{" +
                "mal_id=" + mal_id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", name_kanji='" + name_kanji + '\'' +
                ", animeographies=" + characterAnimes +
                ", mangaographies=" + characterMangas +
                ", favorites=" + favorites +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
