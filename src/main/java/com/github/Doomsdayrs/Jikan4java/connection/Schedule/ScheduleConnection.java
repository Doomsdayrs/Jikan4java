package com.github.Doomsdayrs.Jikan4java.connection.Schedule;

import com.github.Doomsdayrs.Jikan4java.connection.Connection;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Day;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Schedule;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Week.*;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Days;
import org.json.simple.parser.ParseException;

import java.io.IOException;
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
public class ScheduleConnection extends Connection {


    /**
     * Constructor
     */
    public ScheduleConnection() {
        super();
    }

    /**
     * Returns current schedule for all anime
     *
     * @return Schedule
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<Schedule> scheduleSearch() throws IOException, ParseException {
        return retrieve(Schedule.class, baseURL + "/schedule/");
    }


    /**
     * Returns all anime's schedule on a certain day
     *
     * @param day Day to retrieve, Can also be other or unknown
     * @return DaySchedule object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<Day> scheduleSearch(Days day) throws IOException, ParseException {
        switch (day) {
            case MONDAY:
                return retrieve(Monday.class, baseURL + "/schedule/monday");
            case TUESDAY:
                return retrieve(Tuesday.class, baseURL + "/schedule/tuesday");
            case WEDNESDAY:
                return retrieve(Wednesday.class, baseURL + "/schedule/wednesday");
            case THURSDAY:
                return retrieve(Thursday.class, baseURL + "/schedule/thursday");
            case FRIDAY:
                return retrieve(Friday.class, baseURL + "/schedule/friday");
            case SATURDAY:
                return retrieve(Saturday.class, baseURL + "/schedule/saturday");
            case SUNDAY:
                return retrieve(Sunday.class, baseURL + "/schedule/sunday");
            case OTHER:
                return retrieve(Other.class, baseURL + "/schedule/other");
            case UNKNOWN:
                return retrieve(Unknown.class, baseURL + "/schedule/unknown");
            default:
                return null;
        }
    }

}

