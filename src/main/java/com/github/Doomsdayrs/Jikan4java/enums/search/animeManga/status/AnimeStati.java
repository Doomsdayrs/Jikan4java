package com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.status;

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
public enum AnimeStati {
    AIRING("airing"),
    COMPLETED("completed"),
    COMPLETE("complete"),
    TBA("tba"),
    UPCOMING("upcoming");

    private final String status;

    AnimeStati(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
