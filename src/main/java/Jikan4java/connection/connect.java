package Jikan4java.connection;

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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class connect {
    // Request client
    private final OkHttpClient client = new OkHttpClient();
    private final String baseURL = "https://api.jikan.moe/v3";
    public String test() throws IOException
    {
        Request request = new Request.Builder().url(baseURL).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    public String animeSearch(String title) throws IOException {
        Request request = new Request.Builder().url(baseURL + "/search/manga?q="+ title +"&page=1").build();
        Response response = client.newCall(request).execute();
        return  response.headers("results:").toString();
    }

}
