package com.github.Doomsdayrs.Jikan4java.connection.Schedule;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.enums.Days;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Day;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Schedule;

import java.util.concurrent.CompletableFuture;

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
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Deprecated
public class ScheduleConnection extends Retriever {

    /**
     * Constructor
     */
    public ScheduleConnection() {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
    }

    /**
     * Returns current schedule for all anime
     *
     * @return Schedule
     */
    public CompletableFuture<Schedule> getCurrentSchedule() {
        return retrieve(Schedule.class, baseURL + "/schedule");
    }


    /**
     * Returns all anime schedule on a certain day
     *
     * @param day Day to retrieve, Can also be other or unknown
     * @return DaySchedule object
     */
    public CompletableFuture<Day> scheduleSearch(Days day) {
        if (day != null)
            return retrieve(day.getaClass(), baseURL + "/schedule/" + day);
        return null;
    }

}

