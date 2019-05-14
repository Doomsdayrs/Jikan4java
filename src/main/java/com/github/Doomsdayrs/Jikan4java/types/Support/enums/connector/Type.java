package com.github.Doomsdayrs.Jikan4java.types.Support.enums.connector;

import com.github.Doomsdayrs.Jikan4java.types.Main.Season.SeasonArchive.SeasonArchive;
import com.github.Doomsdayrs.Jikan4java.types.Main.Season.SeasonSearch;

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
 * 14 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum Type {
    SEASON("season", SeasonSearch.class, SeasonArchive.class);

    private final String type;
    private final Class a;
    private final Class b;

    Type(String type, Class a, Class b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    public Class getA() {
        return a;
    }

    public Class getB() {
        return b;
    }

    @Override
    public String toString() {
        return type;
    }
}
