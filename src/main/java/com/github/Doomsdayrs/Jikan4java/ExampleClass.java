package com.github.Doomsdayrs.Jikan4java;

import com.github.Doomsdayrs.Jikan4java.connection.Anime.AnimeConnection;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class ExampleClass {

    /**
     * Example method
     *
     * @param args Args
     */
    public static void main(String[] args) throws IOException, ParseException, ExecutionException, InterruptedException {
        /*
        // Gets first search result
        System.out.println(new MangaConnection().search("Attack on titan").toString());
        System.out.println(new AnimeConnection().searchSimple("Attack on titan").toString;
        System.out.println(new CharacterConnection().search("Caster").toString());
        System.out.println(new PersonConnection().search("Hajime Isayama").toString());

        // Returns search results
        System.out.println(new AnimeConnection().searchPage("Attack on titan",1).toString());
        System.out.println(new MangaConnection().searchPage("Tensei",1));
        System.out.println(new CharacterConnection().searchPage("caster",1));
        System.out.println(new PersonConnection().searchPage("Hajime Isayama", 1));

        System.out.println(new GenreConnection().searchAnimeGenre(1,0).toString());
        System.out.println(new GenreConnection().searchMangaGenre(1,0).toString());


        System.out.println(new SeasonConnection().seasonArchiveSearch().toString());

        System.out.println(new ScheduleConnection().scheduleSearch().toString());
        System.out.println(new ScheduleConnection().scheduleSearch("monday").toString()); //`monday` can be replaced with any other day or unknown / other

        System.out.println(new TopConnection().topSearch("anime",0,"").toString());
        System.out.println(new TopConnection().topSearch("manga",0,"").toString());
        System.out.println(new TopConnection().topSearch("people",0,"").toString());
        System.out.println(new TopConnection().topSearch("characters",0,"").toString());
        System.out.println(new UserConnection().searchUser("Aerchan").toString());


        System.out.println(new MagazineConnection().search(11,1));
        System.out.println(new ProducerConnection().search(135,1));
        System.out.println(new MetaConnection().getStatus().toString());
        */
        AnimeConnection connection = new AnimeConnection();
        CompletableFuture<Anime> animeCompletableFuture = connection.searchAnimeById(111);
        int a = 0;
        while (!animeCompletableFuture.isDone()) a++;
        System.out.println(animeCompletableFuture.get());

        animeCompletableFuture = connection.searchAnimeById(124);
        a = 0;
        while (!animeCompletableFuture.isDone()) a++;
        System.out.println(animeCompletableFuture.get());
    }

}
