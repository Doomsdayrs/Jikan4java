package com.github.doomsdayrs.jikan4java.types.support.prop;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class From extends DateProp {
    public From(@JsonProperty("day") int day,
                @JsonProperty("month") int month,
                @JsonProperty("year") int year) {
        super(day, month, year);
    }

    @Override
    public String toString() {
        return "From{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
