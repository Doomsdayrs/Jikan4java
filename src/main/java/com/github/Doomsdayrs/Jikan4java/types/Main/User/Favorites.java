package com.github.Doomsdayrs.Jikan4java.types.Main.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.AnimeBasic;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.CharacterBasic;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.MangaBasic;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.PeopleBasic;

import java.util.ArrayList;

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Deprecated
public class Favorites {
    @JsonProperty("anime")
    private ArrayList<AnimeBasic> animes;
    @JsonProperty("manga")
    private ArrayList<MangaBasic> mangas;
    @JsonProperty("characters")
    private ArrayList<CharacterBasic> characters;
    @JsonProperty("people")
    private ArrayList<PeopleBasic> peoples;

    public ArrayList<AnimeBasic> getAnimes() {
        return animes;
    }

    public ArrayList<MangaBasic> getMangas() {
        return mangas;
    }

    public ArrayList<CharacterBasic> getCharacters() {
        return characters;
    }

    public ArrayList<PeopleBasic> getPeoples() {
        return peoples;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "animes=" + animes +
                ", mangas=" + mangas +
                ", characters=" + characters +
                ", peoples=" + peoples +
                '}';
    }
}
