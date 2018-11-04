package com.github.Doomsdayrs.Jikan4java;

import com.github.Doomsdayrs.Jikan4java.connection.User.UserConnection;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Jikan4java
 * 28 / October / 2018
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

public class ExampleClass {
    /**
     * Example method
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, ParseException {
        /*
        System.out.println(new MangaConnection().search("Attack on titan").toString());

        System.out.println(new AnimeConnection().search("Attack on titan").toString);

        System.out.println(new CharacterConnection().search("Caster").toString());

        System.out.println(new PersonConnection().search("Hajime Isayama").toString());

        System.out.println(new BasicConnection().searchAnimeGenre(1,0).toString());

        System.out.println(new BasicConnection().searchMangaGenre(1,0).toString());

        System.out.println(new BasicConnection().seasonSearch(2016,"winter").toString());

        System.out.println(new BasicConnection().seasonArchiveSearch().toString());

        System.out.println(new BasicConnection().scheduleSearch().toString());

        System.out.println(new BasicConnection().scheduleSearch("monday").toString()); //`monday` can be replaced with any other day or unknown / other

        System.out.println(new BasicConnection().topSearch("anime",0,"").toString());
        System.out.println(new TopConnection().topSearch("manga",0,"").getTopMangas());
        System.out.println(new BasicConnection().topSearch("people",0,"").toString());
        System.out.println(new BasicConnection().topSearch("characters",0,"").toString());
        */
        System.out.println(new UserConnection().searchUser("kuglefang").getAnimelist(1).toString());
    }

}
