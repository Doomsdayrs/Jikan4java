/*
 *
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * /
 */

/*
 *
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * /
 */

/*
 *
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * /
 */

package com.github.Doomsdayrs.Jikan4java.connection.Top;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
public class TopConnection {
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    /**
     * Constructor
     */
    public TopConnection() {
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
        if (!subtype.equals("") || pageNumber != 0) {
            optionals = true;
        }
        if (optionals) {
            optional = "/" + pageNumber + "/" + subtype;
        }
        if (type.equalsIgnoreCase("anime")) {
            return objectMapper.readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), AnimeTop.class);
        } else if (type.equalsIgnoreCase("manga")) {
            return objectMapper.readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), MangaTop.class);
        } else if (type.equalsIgnoreCase("people")) {
            return objectMapper.readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), PersonTop.class);
        } else if (type.equalsIgnoreCase("characters")) {
            return objectMapper.readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("https://api.jikan.moe/v3/top/" + type + optional).build()).execute().body().string())).toJSONString(), CharacterTop.class);
        }


        System.out.println("ERROR, Invalid input");
        return null;

    }

}
