package com.github.doomsdayrs.jikan4java;
/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 */

import com.github.doomsdayrs.jikan4java.core.search.TopSearch;
import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch;
import com.github.doomsdayrs.jikan4java.core.search.animemanga.MangaSearch;
import com.github.doomsdayrs.jikan4java.enums.top.Tops;
import com.github.doomsdayrs.jikan4java.exceptions.IncompatibleEnumException;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.types.main.anime.character_staff.Character_Staff;
import com.github.doomsdayrs.jikan4java.types.main.anime.episodes.Episodes;
import com.github.doomsdayrs.jikan4java.types.main.anime.videos.Video;
import com.github.doomsdayrs.jikan4java.types.main.manga.Manga;
import com.github.doomsdayrs.jikan4java.types.main.manga.MangaCharacters;
import com.github.doomsdayrs.jikan4java.types.main.top.Top;
import com.github.doomsdayrs.jikan4java.types.main.top.objects.anime.AnimeTop;
import com.github.doomsdayrs.jikan4java.types.main.top.objects.character.CharacterTop;
import com.github.doomsdayrs.jikan4java.types.main.top.objects.manga.MangaTop;
import com.github.doomsdayrs.jikan4java.types.main.top.objects.person.PersonTop;
import com.github.doomsdayrs.jikan4java.types.support.MoreInfo;
import com.github.doomsdayrs.jikan4java.types.support.forum.Forum;
import com.github.doomsdayrs.jikan4java.types.support.news.News;
import com.github.doomsdayrs.jikan4java.types.support.pictures.Pictures;
import com.github.doomsdayrs.jikan4java.types.support.recommendations.RecommendationPage;
import com.github.doomsdayrs.jikan4java.types.support.reviews.anime.AnimeReviewPage;
import com.github.doomsdayrs.jikan4java.types.support.stats.AnimeStats;
import com.github.doomsdayrs.jikan4java.types.support.stats.MangaStats;
import com.github.doomsdayrs.jikan4java.types.support.stats.Stats;
import com.github.doomsdayrs.jikan4java.types.support.userupdate.anime.AnimeUserUpdatesPage;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.github.doomsdayrs.jikan4java.core.Retriever.getErrorMessages;
import static com.github.doomsdayrs.jikan4java.core.Retriever.setDebugMode;

/**
 * Jikan4java
 * 47 / 44 / 2049
 *
 * @author github.com/doomsdayrs
 */
class Tester {
    private static final String[] animes = {"Boku no Hero Academia 4th Season", "Steins;Gate", "Fullmetal Alchemist: Brotherhood", "Kimetsu no Yaiba"};
    private static final String[] mangaTitles = {"Berserk"/*, "Boku no", "One punch", "Shield"*/};
    private static final Tops[] tops = {Tops.ANIME, Tops.MANGA, Tops.CHARACTERS, Tops.PEOPLE};
    /**
     * Types: Anime, Manga, Top
     */
    private static final boolean[] types = {true, true, true};
    private static final int max = 53;
    private static int currentProgress = 0;

    /**
     * S is for sleep, It sleeps!
     *
     * @throws InterruptedException SLEEEEEEEEP
     */
    private static void s() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }

    /**
     * Loops through array setting values
     *
     * @param target value to set opposite of Value
     * @param value  set the rest to this
     */
    public static void setLoopSwap(int target, boolean value) {
        for (int x = 0; x < types.length; x++)
            if (x != target)
                types[x] = value;
            else types[x] = !value;
    }

    private static void progressUpdate() {
        currentProgress++;
        System.out.println("\f");
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int x = 0; x < currentProgress; x++)
            stringBuilder.append("=");
        for (int x = currentProgress; x < max; x++)
            stringBuilder.append("-");
        System.out.println("Progress: " + stringBuilder.toString());
    }

    /**
     * Tester method
     *
     * @param args No args = run's all tests, Default all types enabled, -(type)=0 disables said type, -(type)=1 disables all but said type
     * @throws ExecutionException        ignored
     * @throws InterruptedException      ignored
     * @throws IncompatibleEnumException ignored
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException, IncompatibleEnumException {
        // Enables DEBUG mode
        setDebugMode(true);
        for (String arg : args) {
            String holder = "";
            int v = arg.indexOf("=");
            if (v != -1 && v != arg.length() - 1)
                holder = arg.substring(v);
            else throw new IndexOutOfBoundsException("Invalid entry!");
            int value = -1;
            try {
                value = Integer.parseInt(holder);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (value != 1 || value != 0)
                throw new IndexOutOfBoundsException("Invalid entry!");


            if (arg.toLowerCase().contains("-anime")) {
                if (value == 0)
                    types[0] = false;
                else if (value == 1)
                    setLoopSwap(0, false);
            } else if (arg.toLowerCase().contains("-manga")) {

                if (value == 0)
                    types[1] = false;
                else if (value == 1)
                    setLoopSwap(1, false);
            } else if (arg.toLowerCase().contains("-top")) {

                if (value == 0)
                    types[2] = false;
                else if (value == 1)
                    setLoopSwap(2, false);
            }
        }

        // Anime
        if (types[0]) {
            AnimeSearch animeSearch;
            int a = 0;
            for (String animeTitle : animes) {
                a++;
                animeSearch = new AnimeSearch();
                animeSearch.setQuery(animeTitle);

                progressUpdate();
                System.out.println("\nSearching for ANIME\n");
                CompletableFuture<Anime> animeCompletableFuture = animeSearch.getFirst();
                animeCompletableFuture.thenAccept(System.out::println);
                Anime anime = animeCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nCharacter_Staff\n");
                CompletableFuture<Character_Staff> characterStaffCompletableFuture = anime.getCharacterStaffs();
                characterStaffCompletableFuture.thenAccept(System.out::println);
                Character_Staff character_staff = characterStaffCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nEpisodes\n");
                CompletableFuture<Episodes> episodesCompletableFuture = anime.getEpisodes();
                episodesCompletableFuture.thenAccept(System.out::println);
                Episodes episodes = episodesCompletableFuture.get();
                s();

                System.out.println("\nNews\n");
                CompletableFuture<News> newsCompletableFuture = anime.getNews();
                newsCompletableFuture.thenAccept(System.out::println);
                News news = newsCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nPictures\n");
                CompletableFuture<Pictures> picturesCompletableFuture = anime.getPictures();
                picturesCompletableFuture.thenAccept(System.out::println);
                Pictures pictures = picturesCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nVideos\n");
                CompletableFuture<Video> videoCompletableFuture = anime.getVideos();
                videoCompletableFuture.thenAccept(System.out::println);
                Video video = videoCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nStats\n");
                CompletableFuture<AnimeStats> statsCompletableFuture = anime.getStats();
                statsCompletableFuture.thenAccept(System.out::println);
                Stats stats = statsCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nForum\n");
                CompletableFuture<Forum> forumCompletableFuture = anime.getForum();
                forumCompletableFuture.thenAccept(System.out::println);
                Forum forum = forumCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nMoreInfo\n");
                CompletableFuture<MoreInfo> moreInfoCompletableFuture = anime.getMoreInfo();
                moreInfoCompletableFuture.thenAccept(System.out::println);
                MoreInfo moreInfo = moreInfoCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nReviewPage\n");
                CompletableFuture<AnimeReviewPage> reviewCompletableFuture = anime.getReviewPage();
                reviewCompletableFuture.thenAccept(System.out::println);
                AnimeReviewPage reviewPage = reviewCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nRecommendationPage\n");
                CompletableFuture<RecommendationPage> recommendCompletableFuture = anime.getRecommendationPage();
                recommendCompletableFuture.thenAccept(System.out::println);
                RecommendationPage recommendationPage = recommendCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nUserUpdates\n");
                CompletableFuture<AnimeUserUpdatesPage> animeUserUpdateCompletableFuture = anime.getUserUpdatesPage();
                animeUserUpdateCompletableFuture.thenAccept(System.out::println);
                AnimeUserUpdatesPage animeUserUpdatesPage = animeUserUpdateCompletableFuture.get();
                s();
            }
        }

        if (types[1]) {
            MangaSearch mangaSearch;
            for (String mangaTitle : mangaTitles) {
                mangaSearch = new MangaSearch();
                mangaSearch.setQuery(mangaTitle);

                progressUpdate();
                System.out.println("Searching Manga: " + mangaTitle);
                CompletableFuture<Manga> mangaCompletableFuture = mangaSearch.getFirst();
                mangaCompletableFuture.thenAccept(System.out::println);
                Manga manga = mangaCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<MangaCharacters> characterCompletableFuture = manga.getCharacters();
                characterCompletableFuture.thenAccept(System.out::println);
                MangaCharacters mangaCharacters = characterCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<News> newsCompletableFuture = manga.getNews();
                newsCompletableFuture.thenAccept(System.out::println);
                News news = newsCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<Pictures> picturesCompletableFuture = manga.getPictures();
                picturesCompletableFuture.thenAccept(System.out::println);
                Pictures pictures = picturesCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<MangaStats> statsCompletableFuture = manga.getStats();
                statsCompletableFuture.thenAccept(System.out::println);
                Stats stats = statsCompletableFuture.get();
                s();
            }
        }

        if (types[2]) {
            TopSearch topSearch;
            for (Tops top : tops) {
                topSearch = new TopSearch();
                progressUpdate();
                System.out.println("\n" + top.toString() + "\n");
                CompletableFuture<Top> topCompletableFuture = topSearch.searchTop(top);
                topCompletableFuture.thenAccept(System.out::println);
                Top t = topCompletableFuture.get();
                switch (top) {
                    case PEOPLE:
                        PersonTop personTop = (PersonTop) t;
                        System.out.println(personTop);
                        break;
                    case CHARACTERS:
                        CharacterTop characterTop = (CharacterTop) t;
                        System.out.println(characterTop);
                        break;
                    case MANGA:
                        MangaTop mangaTop = (MangaTop) t;
                        System.out.println(mangaTop);
                        break;
                    case ANIME:
                        AnimeTop animeTop = (AnimeTop) t;
                        System.out.println(animeTop);
                        break;
                    default:
                        break;
                }
                s();
            }
        }
        // Gets any and all errors from code
        ArrayList<String[]> errors = getErrorMessages();
        for (String[] error : errors) {
            System.out.println("\nError: " + error[0]);
            System.out.println("\tJSON: " + error[1]);
            System.out.println("\tURL: " + error[2]);
        }
        System.out.println("\n=== Completed ===\n");
    }
}
