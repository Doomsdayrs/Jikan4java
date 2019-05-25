package com.github.Doomsdayrs.Jikan4java.enums.userListings.orderBy;

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
 * along with Jikan4java.  If not, see https://www.gnu.org/licenses/.
 * ====================================================================
 * Jikan4java
 * 25 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum AnimeListOrderBy implements ListOrderBy {
    TITLE("title"),
    FINISH_DATE("finish_date"),
    START_DATE("start_date"),
    SCORE("score"),
    LAST_UPDATED("last_updated"),
    TYPE("type"),
    RATED("rated"),
    REWATCH("rewatch"),
    REWATCHED_VALUE(REWATCH.type),
    PRIORITY("priority"),
    PROGRESS("progress"),
    EPISODES_WATCHED(PROGRESS.type),
    STORAGE("storage"),
    AIR_START("air_start"),
    AIR_END("air_end"),
    STATUS("status");

    private final String type;

    AnimeListOrderBy(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
