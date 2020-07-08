package com.github.doomsdayrs.jikan4java.enums.status;

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
 * 18 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum MangaStati implements Stati {
    AIRING("publishing"),
    COMPLETED("completed"),
    COMPLETE(COMPLETED.status),
    TO_BE_PUBLISHED("to_be_published"),
    TBP(TO_BE_PUBLISHED.status),
    UPCOMING(TBP.status);

    private final String status;

    MangaStati(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
