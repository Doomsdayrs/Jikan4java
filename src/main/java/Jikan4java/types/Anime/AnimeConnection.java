package Jikan4java.types.Anime;
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
import Jikan4java.connection.Connect;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AnimeConnection {
    private final OkHttpClient client;
    public AnimeConnection()
    {
        this.client = new OkHttpClient();
    }
    public Anime search(String title) throws IOException, ParseException {
        Connect connect = new Connect();
        JSONObject animeJSON = connect.search("anime",title);

        Anime anime = new Anime(animeJSON.get("url").toString(),animeJSON.get("title").toString(),animeJSON.get("image_url").toString(),animeJSON.get("synopsis").toString(), new int[Integer.parseInt(animeJSON.get("episodes").toString())]);
        return anime;
    }
}

