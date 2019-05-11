package com.github.Doomsdayrs.Jikan4java;

import com.github.Doomsdayrs.Jikan4java.connection.Anime.AnimeConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Character.CharacterConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Club.ClubConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Genre.GenreConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Magazine.MagazineConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Manga.MangaConnection;
import com.github.Doomsdayrs.Jikan4java.connection.MetaConnection.MetaConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Person.PersonConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Producer.ProducerConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Schedule.ScheduleConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Season.SeasonConnection;
import com.github.Doomsdayrs.Jikan4java.connection.Top.TopConnection;
import com.github.Doomsdayrs.Jikan4java.connection.User.UserConnection;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Character.CharacterPage.CharacterPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Club.Club;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Anime.GenreSearchAnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga.GenreSearchMangaPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Magazine.MagazinePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import com.github.Doomsdayrs.Jikan4java.types.Main.Meta.Status;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.AnimeGenres;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.MangaGenres;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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

        int a = 0;

        CompletableFuture<Anime> animeCompletableFuture = animeConnection.searchAnimeById(1);
        if (animeCompletableFuture != null) {
            while (!animeCompletableFuture.isDone()) a++;
            System.out.println(animeCompletableFuture.get());
        }

        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<CharacterPage> characterCompletableFuture = characterConnection.searchPage("re", 1);
        if (characterCompletableFuture != null) {
            while (!characterCompletableFuture.isDone()) a++;
            System.out.println(characterCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<Club> clubCompletableFuture = clubConnection.search(12);
        if (clubCompletableFuture != null) {
            while (!clubCompletableFuture.isDone()) a++;
            System.out.println(clubCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<GenreSearchAnimePage> searchAnimeGenre = genreConnection.searchAnimeGenre(AnimeGenres.ACTION);
        if (searchAnimeGenre != null) {
            while (!searchAnimeGenre.isDone()) a++;
            System.out.println(searchAnimeGenre.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<GenreSearchMangaPage> searchMangaGenre = genreConnection.searchMangaGenre(MangaGenres.ACTION);
        if (searchMangaGenre != null) {
            while (!searchMangaGenre.isDone()) a++;
            System.out.println(searchMangaGenre.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<MagazinePage> magazinePageCompletableFuture = magazineConnection.searchPage(1, 1);
        if (magazinePageCompletableFuture != null) {
            while (!magazinePageCompletableFuture.isDone()) a++;
            System.out.println(magazinePageCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<Manga> mangaCompletableFuture = mangaConnection.search("Ajin");
        if (mangaCompletableFuture != null) {
            while (!mangaCompletableFuture.isDone()) a++;
            System.out.println(mangaCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<Status> statusCompletableFuture = metaConnection.getStatus();
        if (statusCompletableFuture != null) {
            while (!statusCompletableFuture.isDone()) a++;
            System.out.println(statusCompletableFuture.get());
        }

        // Well, after this point you should get an idea, use code completion or decompile the classes to see what are methods available;

    }

}
