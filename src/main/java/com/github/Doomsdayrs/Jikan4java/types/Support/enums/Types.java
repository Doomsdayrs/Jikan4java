package com.github.Doomsdayrs.Jikan4java.types.Support.enums;

import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage.AnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Character.CharacterPage.CharacterPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.MangaPage.MangaPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.PersonPage.PersonPage;

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
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum  Types {
    ANIME("anime", AnimePage.class),
    MANGA("manga", MangaPage.class),
    PERSON("person", PersonPage.class),
    CHARACTER("character", CharacterPage.class);
    private final String type;
    private final Class c;
    Types(String type, Class c){
        this.type = type;
        this.c = c;
    }

    public Class getC() {
        return c;
    }

    @Override
    public String toString() {
        return type;
    }
}
