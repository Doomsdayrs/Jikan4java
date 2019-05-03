package com.github.Doomsdayrs.Jikan4java.connection.Schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Day;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Schedule;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Week.*;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Days;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Objects;

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
public class ScheduleConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";
    private final ObjectMapper objectMapper = new ObjectMapper();


    /**
     * Constructor
     */
    public ScheduleConnection() {
    }

    /**
     * Returns current schedule for all anime
     *
     * @return Schedule
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Schedule scheduleSearch() throws IOException, ParseException {
        return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/").build()).execute().body()).string())).toJSONString(), Schedule.class);
    }




    /**
     * Returns all anime's schedule on a certain day
     *
     * @param day Day to retrieve, Can also be other or unknown
     * @return DaySchedule object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Day scheduleSearch(Days day) throws IOException, ParseException {
        switch (day) {
            case MONDAY:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/monday").build()).execute().body()).string())).toJSONString(), Monday.class);
            case TUESDAY:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/tuesday").build()).execute().body()).string())).toJSONString(), Tuesday.class);
            case WEDNESDAY:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/wednesday").build()).execute().body()).string())).toJSONString(), Wednesday.class);
            case THURSDAY:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/thursday").build()).execute().body()).string())).toJSONString(), Thursday.class);
            case FRIDAY:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/friday").build()).execute().body()).string())).toJSONString(), Friday.class);
            case SATURDAY:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/saturday").build()).execute().body()).string())).toJSONString(), Saturday.class);
            case SUNDAY:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/sunday").build()).execute().body()).string())).toJSONString(), Sunday.class);
            case OTHER:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/other").build()).execute().body()).string())).toJSONString(), Other.class);
            case UNKNOWN:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL+"/schedule/unknown").build()).execute().body()).string())).toJSONString(), Unknown.class);
            default:
                return null;
        }
    }

}

