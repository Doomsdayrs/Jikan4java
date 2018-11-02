package com.github.Doomsdayrs.Jikan4java.connection.Basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.GenreSearch.Anime.GenreSearchAnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.GenreSearch.Manga.GenreSearchMangaPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Schedule.DaySchedule;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Schedule.Schedule;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Schedule.Week.*;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Season.SeasonSearch;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.SeasonArchive.SeasonArchive;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Top.Objects.Anime.AnimeTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Top.Top;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Jikan4java
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
/*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
*/
public class BasicConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";

    /**
     * Searches for manga by ID, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public GenreSearchAnimePage searchMangaGenre(int genreID, int page) throws IOException, ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/genre/anime/" + genreID + "/" + page).build()).execute().body().string())).toJSONString(), GenreSearchAnimePage.class);
    }

    /**
     * Searches for anime by ID, there are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    the page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchMangaPage
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public GenreSearchMangaPage searchAnimeGenre(int genreID, int page) throws IOException, ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/genre/manga/" + genreID + "/" + page).build()).execute().body().string())).toJSONString(), GenreSearchMangaPage.class);
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
    public SeasonSearch seasonSearch(int year, String season) throws IOException, ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/season/" + year + "/" + season).build()).execute().body().string())).toJSONString(), SeasonSearch.class);
    }

    /**
     * Returns archive of all possible seasons and years
     *
     * @return SeasonArchive
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public SeasonArchive seasonArchiveSearch() throws IOException, ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/season/archive").build()).execute().body().string())).toJSONString(), SeasonArchive.class);
    }

    /**
     * Returns current schedule for all anime
     *
     * @return Schedule
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Schedule scheduleSearch() throws IOException, ParseException {
        return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/").build()).execute().body().string())).toJSONString(), Schedule.class);
    }

    /**
     * Returns all anime's schedule on a certain day
     *
     * @param day Day to retrieve, Can also be other or unknown
     * @return DaySchedule object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public DaySchedule scheduleSearch(String day) throws IOException, ParseException {
        if (day.equalsIgnoreCase("monday")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Monday.class);
        } else if (day.equalsIgnoreCase("tuesday")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Tuesday.class);
        } else if (day.equalsIgnoreCase("wednesday")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Wednesday.class);
        } else if (day.equalsIgnoreCase("thursday")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Thursday.class);
        } else if (day.equalsIgnoreCase("friday")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Friday.class);
        } else if (day.equalsIgnoreCase("saturday")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Saturday.class);
        } else if (day.equalsIgnoreCase("sunday")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Sunday.class);
        } else if (day.equalsIgnoreCase("other")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Other.class);
        } else if (day.equalsIgnoreCase("unknown")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/schedule/" + day).build()).execute().body().string())).toJSONString(), Unknown.class);
        }
        System.out.println("ERROR, Invalid input");
        return null;
    }

    /**
     * Searches the top charts of MAL
     *
     * @param type       What type of media: anime, manga, people, characters
     * @param pageNumber Should be 0 by default, Each page has 50 entries; Page 1 would be the next page, so 50 - 100
     * @param subtype    The sub category to search for. One at a time only.
     * @return Top object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Top topSearch(String type, int pageNumber, String subtype) throws IOException, ParseException {
        boolean optionals = false;
        String optional = "";
        if (subtype != "" || pageNumber != 0) {
            optionals = true;
        }
        if (optionals) {
            optional = "/" + pageNumber + "/" + subtype;
        }
        if (type.equalsIgnoreCase("anime")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), AnimeTop.class);
        } else if (type.equalsIgnoreCase("manga")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), AnimeTop.class);
        } else if (type.equalsIgnoreCase("people")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), AnimeTop.class);
        } else if (type.equalsIgnoreCase("characters")) {
            return new ObjectMapper().readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), AnimeTop.class);
        }


        System.out.println("ERRPR, Invalid input");
        return null;

    }

}
