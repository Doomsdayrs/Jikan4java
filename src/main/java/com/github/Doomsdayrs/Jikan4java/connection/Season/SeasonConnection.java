package com.github.Doomsdayrs.Jikan4java.connection.Season;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.connection.Connection;
import com.github.Doomsdayrs.Jikan4java.types.Main.Season.SeasonArchive.SeasonArchive;
import com.github.Doomsdayrs.Jikan4java.types.Main.Season.SeasonSearch;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Season;
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
public class SeasonConnection extends Connection {

    /**
     * Constructor
     */
    public SeasonConnection() {
        super();
    }

    /**
     * Searches for anime by season
     *
     * @param year   Year
     * @param season Season
     * @return SeasonSearchObject
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public SeasonSearch seasonSearch(int year, Season season) throws IOException, ParseException {
        switch (season) {
            case FALL:
                return (SeasonSearch) retrieve(SeasonSearch.class,baseURL+"/season/" + year + "/fall");
            case SPRING:
                return (SeasonSearch) retrieve(SeasonSearch.class,baseURL+"/season/" + year + "/spring");
            case SUMMER:
                return (SeasonSearch) retrieve(SeasonSearch.class,baseURL+"/season/" + year + "/summer");
            case WINTER:
                return (SeasonSearch) retrieve(SeasonSearch.class,baseURL+"/season/" + year + "/winter");
            default:
                return null;
        }
    }

    /**
     * Returns next season of anime
     *
     * @return SeasonSearchObject
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public SeasonSearch seasonLater() throws IOException, ParseException {
        return (SeasonSearch) retrieve(SeasonSearch.class,baseURL+"/season/later");
    }

    /**
     * Returns archive of all possible seasons and years
     *
     * @return SeasonArchive
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public SeasonArchive seasonArchive() throws IOException, ParseException {
        return (SeasonArchive) retrieve(SeasonArchive.class, baseURL+"/season/archive");
    }
}

