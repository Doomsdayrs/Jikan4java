package com.github.Doomsdayrs.Jikan4java.connection.Magazine;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Magazine.MagazinePage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class MagazineConnection {
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    /**
     * Constructor
     */
    public MagazineConnection() {
    }

    /**
     * Retrieves Magazines
     *
     * @param ID   ID of magazine
     * @param page page to search for
     * @return MagazinePage object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public MagazinePage search(int ID, int page) throws IOException, ParseException {
        return objectMapper.readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/magazine/" + ID + "/" + page).build()).execute().body().string())).toJSONString(), MagazinePage.class);
    }
}
