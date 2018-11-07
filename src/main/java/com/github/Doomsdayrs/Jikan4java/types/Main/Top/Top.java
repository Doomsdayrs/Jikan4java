package com.github.Doomsdayrs.Jikan4java.types.Main.Top;

import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Anime.TopAnime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Character.TopCharacter;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Manga.TopManga;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Person.TopPerson;

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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Top {
    private String request_hash;
    private boolean request_cached;
    private int request_cache_expiry;

    //Anime
    private ArrayList<TopAnime> topAnimes;

    //Character
    private ArrayList<TopCharacter> topCharacters;

    //Manga
    private ArrayList<TopManga> topMangas;

    //Person
    private ArrayList<TopPerson> topPeople;

    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    /**
     * Only applies to Animes
     *
     * @return TopAnime
     */
    public ArrayList<TopAnime> getTopAnimes() {
        return topAnimes;
    }

    /**
     * Only applies to Characters
     *
     * @return TopCharacter
     */
    public ArrayList<TopCharacter> getTopCharacters() {
        return topCharacters;
    }

    /**
     * Only applies to Mangas
     *
     * @return TopManga
     */
    public ArrayList<TopManga> getTopMangas() {
        return topMangas;
    }

    /**
     * Only applies to People
     *
     * @return TopPeople
     */
    public ArrayList<TopPerson> getTopPeople() {
        return topPeople;
    }

    @Override
    public String toString() {
        return "Top{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", topAnimes=" + topAnimes +
                ", topCharacters=" + topCharacters +
                ", topMangas=" + topMangas +
                ", topPeople=" + topPeople +
                '}';
    }
}
