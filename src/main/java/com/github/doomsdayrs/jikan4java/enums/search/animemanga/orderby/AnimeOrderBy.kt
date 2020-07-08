package com.github.doomsdayrs.jikan4java.enums.search.animemanga.orderby;

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
 * ====================================================================
 * Jikan4java
 * 17 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum AnimeOrderBy implements OrderBy {
    TITLE("title"),
    START_DATE("start_date"),
    END_DATE("end_date"),
    SCORE("score"),
    TYPE("type"),
    MEMBERS("members"),
    ID("id"),
    EPISODES("episodes"),
    RATING("rating");

    private final String type;

    AnimeOrderBy(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
