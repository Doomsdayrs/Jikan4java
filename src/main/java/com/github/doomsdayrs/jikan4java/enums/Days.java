package com.github.doomsdayrs.jikan4java.enums;

import com.github.doomsdayrs.jikan4java.types.main.schedule.week.*;

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
 * 11 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum Days {
    MONDAY("monday", Monday.class),
    TUESDAY("tuesday", Tuesday.class),
    WEDNESDAY("wednesday", Wednesday.class),
    THURSDAY("thursday", Thursday.class),
    FRIDAY("friday", Friday.class),
    SATURDAY("saturday", Saturday.class),
    SUNDAY("sunday", Sunday.class),
    OTHER("other", Other.class),
    UNKNOWN("unknown", Unknown.class);

    private final String type;
    private final Class aClass;

    Days(String type, Class aClass) {
        this.type = type;
        this.aClass = aClass;
    }

    public Class getaClass() {
        return aClass;
    }

    @Override
    public String toString() {
        return type;
    }
}
