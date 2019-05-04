package com.github.Doomsdayrs.Jikan4java.connection.Genre;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.connection.Connection;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Anime.GenreSearchAnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga.GenreSearchManga;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga.GenreSearchMangaPage;
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
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class GenreConnection extends Connection {
    /**
     * Constructor
     */
    public GenreConnection() {
        super();
    }

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
        return (GenreSearchAnimePage) retrieve(GenreSearchAnimePage.class,baseURL+"/genre/anime/" + genreID + "/" + page);
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
        return (GenreSearchMangaPage) retrieve(GenreSearchMangaPage.class,baseURL+"/genre/manga/" + genreID + "/" + page);
    }

}
