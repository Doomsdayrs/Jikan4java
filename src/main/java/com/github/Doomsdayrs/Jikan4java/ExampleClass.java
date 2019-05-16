package com.github.Doomsdayrs.Jikan4java;

import com.github.Doomsdayrs.Jikan4java.connection.Connector;
import com.github.Doomsdayrs.Jikan4java.types.Main.Club.Club;

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
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*
        AnimeConnection animeConnection = new AnimeConnection();
        CharacterConnection characterConnection = new CharacterConnection();
        ClubConnection clubConnection = new ClubConnection();
        GenreConnection genreConnection = new GenreConnection();
        MagazineConnection magazineConnection = new MagazineConnection();
        MangaConnection mangaConnection = new MangaConnection();
        MetaConnection metaConnection = new MetaConnection();
        PersonConnection personConnection = new PersonConnection();
        ProducerConnection producerConnection = new ProducerConnection();
        ScheduleConnection scheduleConnection = new ScheduleConnection();
        SeasonConnection seasonConnection = new SeasonConnection();
        TopConnection topConnection = new TopConnection();
        UserConnection userConnection = new UserConnection();

        animeConnection.searchAnimeById(1).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        characterConnection.searchPage("re", 1).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        clubConnection.search(12).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        genreConnection.searchAnimeGenre(AnimeGenres.ACTION).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        genreConnection.searchMangaGenre(MangaGenres.ACTION).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        magazineConnection.searchPage(1, 1).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        mangaConnection.search("Ajin").thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        metaConnection.getStatus().thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        personConnection.search("re").thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        producerConnection.search(16, 2).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        scheduleConnection.scheduleSearch(Days.MONDAY).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        seasonConnection.seasonSearch(2018, Season.FALL).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        topConnection.search(Tops.ANIME).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(1);

        userConnection.search("doomsdayrs").thenAccept(System.out::println);


*/
        // Well, after this point you should get an idea, use code completion or decompile the classes to see what are methods available;
 /*       int a = 0;
        MangaSearch search = new MangaSearch().setQuery("boku");
        search.setLimit(2);
        search.addGenre(MangaGenres.ACTION);
        search.setStatus(Stati.COMPLETE);

        CompletableFuture completableFuture = search.get();
        while (!completableFuture.isDone()) {
            a++;
        }
        System.out.println(completableFuture.get());

        TimeUnit.SECONDS.sleep(1);

        completableFuture = search.getFirst();
        while (!completableFuture.isDone()) {
            a++;
        }
        System.out.println(completableFuture.get());
*/
        CompletableFuture<Club> a = new Connector().clubSearch(1);
        int b = 0;
        while (!a.isDone()) b++;
        System.out.println(a.get());
    }

}
