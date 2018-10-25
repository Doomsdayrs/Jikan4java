package Jikan4java;
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
import Jikan4java.types.Anime.Anime;
import Jikan4java.types.Anime.AnimeConnection;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class TestClass {
    public static void main(String[] args) {
        AnimeConnection animeConnection = new AnimeConnection();
        Anime anime = null;
        try {
            anime = animeConnection.search("Boku no pico");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Something to make it push, another thing
        System.out.println(anime.getUrl());
    }

}
