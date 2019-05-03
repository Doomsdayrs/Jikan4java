package com.github.Doomsdayrs.Jikan4java.connection.Top;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Anime.AnimeTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Character.CharacterTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Manga.MangaTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Person.PersonTop;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Top;
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
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class TopConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";
    private final ObjectMapper objectMapper = new ObjectMapper();
    public enum Tops {
        ANIME(),
        MANGA,
        PEOPLE(),
        CHARACTERS()
    }


    /**
     * Constructor
     */
    public TopConnection() {
    }

    /**
     * Searches the top charts of MAL
     *
     * @param tops       What type of media: anime, manga, people, characters
     * @param pageNumber Should be 0 by default, Each page has 50 entries; Page 1 would be the next page, so 50 - 100
     * @param subtype    The sub category to search for. One at a time only.
     * @return Top object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Top topSearch(Tops tops, int pageNumber, String subtype) throws IOException, ParseException {
        if (tops == null) throw new EnumConstantNotPresentException(Tops.class, "Tops type not present!");
        if (subtype == null) subtype = "";

        boolean optionals = false;
        String optional = "";
        if (!subtype.equals("") || pageNumber != 0) {
            optionals = true;
        }

        if (optionals) {
            optional = "/" + pageNumber + "/" + subtype;
        }
        switch (tops) {
            case ANIME:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/anime" + optional).build()).execute().body()).string())).toJSONString(), AnimeTop.class);
            case MANGA:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/manga" + optional).build()).execute().body()).string())).toJSONString(), MangaTop.class);
            case PEOPLE:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/people" + optional).build()).execute().body()).string())).toJSONString(), PersonTop.class);
            case CHARACTERS:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/characters" + optional).build()).execute().body()).string())).toJSONString(), CharacterTop.class);
            default:
                return null;
        }
    }

    /**
     * Searches the top charts of MAL, with all default cases
     *
     * @param tops What type of media: anime, manga, people, characters
     * @return Top object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public Top topSearch(Tops tops) throws IOException, ParseException {
        switch (tops) {
            case ANIME:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/anime").build()).execute().body()).string())).toJSONString(), AnimeTop.class);
            case MANGA:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/manga").build()).execute().body()).string())).toJSONString(), MangaTop.class);
            case PEOPLE:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/people").build()).execute().body()).string())).toJSONString(), PersonTop.class);
            case CHARACTERS:
                return objectMapper.readValue(((JSONObject) new JSONParser().parse(Objects.requireNonNull(client.newCall(new Request.Builder().url(baseURL + "/top/characters").build()).execute().body()).string())).toJSONString(), CharacterTop.class);
            default:
                return null;
        }
    }


}

