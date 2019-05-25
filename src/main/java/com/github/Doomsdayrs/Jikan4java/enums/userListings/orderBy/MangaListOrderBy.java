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
public enum MangaListOrderBy {
    TITLE("title"),
    FINISH_DATE("finish_date"),
    START_DATE("start_date"),
    SCORE("score"),
    LAST_UPDATED("last_updated"),
    TYPE("type"),
    PRIORITY("priority"),
    PROGRESS("progress"),
    CHAPTERS_READ(PROGRESS.type),
    VOLUMES_READ("volumes_read"),
    AIR_START("air_start"),
    AIR_END("air_end"),
    STATUS("status");

    private final String type;

    MangaListOrderBy(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
