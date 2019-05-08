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
    public String request_hash;
    public boolean request_cached;
    public int request_cache_expiry;

    //Anime
    public ArrayList<TopAnime> topAnimes;

    //Character
    public ArrayList<TopCharacter> topCharacters;

    //Manga
    public ArrayList<TopManga> topMangas;

    //Person
    public ArrayList<TopPerson> topPeople;

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
