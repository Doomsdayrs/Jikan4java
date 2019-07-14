package com.github.Doomsdayrs.Jikan4java.enums.userListings.filters;

import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.MangaList.MangaList;

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
 * along with Jikan4java.  If not, see https://www.gnu.org/licenses/.
 * ====================================================================
 * Jikan4java
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum MangaListFilters implements UserListFilters {
    ALL("all"),
    READING("reading"),
    COMPLETED("completed"),
    ONHOLD("onhold"),
    DROPPED("dropped"),
    PLANTOREAD("plantoread"),
    PTR(PLANTOREAD.type);

    private final String type;
    private final Class aClass = MangaList.class;

    MangaListFilters(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public String getForm() {
        return "mangalist";
    }

    @Override
    public Class getaClass() {
        return aClass;
    }
}
