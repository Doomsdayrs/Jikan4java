package com.github.Doomsdayrs.Jikan4java.enums.top;

import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Anime.AnimeTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Character.CharacterTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Manga.MangaTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Person.PersonTop;

/*
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 11 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum Tops {
    ANIME("anime", AnimeTop.class),
    MANGA("manga", MangaTop.class),
    PEOPLE("people", PersonTop.class),
    CHARACTERS("characters", CharacterTop.class);
    private final String type;
    private final Class aClass;

    Tops(String type, Class aClass) {
        this.type = type;
        this.aClass = aClass;
    }

    public boolean compatible(TopSubType topSubType) {
        if (this.equals(PEOPLE) || this.equals(CHARACTERS))
            return false;
        if (topSubType != null) {
            if (this.equals(ANIME) || this.equals(MANGA))
                if (topSubType.getClass().equals(SharedTops.class))
                    return true;

            if (this.equals(ANIME))
                return topSubType.getClass().equals(AnimeTops.class);
            if (this.equals(MANGA))
                return topSubType.getClass().equals(MangaTops.class);

        }
        return false;
    }

    public Class getaClass() {
        return aClass;
    }

    @Override
    public String toString() {
        return type;
    }
}
