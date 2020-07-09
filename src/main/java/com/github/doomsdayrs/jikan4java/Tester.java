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

import com.github.doomsdayrs.jikan4java.core.Connector;
import com.github.doomsdayrs.jikan4java.core.search.GenreSearch;
import com.github.doomsdayrs.jikan4java.core.search.TopSearch;
import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch;
import com.github.doomsdayrs.jikan4java.core.search.animemanga.MangaSearch;
import com.github.doomsdayrs.jikan4java.data.enums.Days;
import com.github.doomsdayrs.jikan4java.data.enums.HistoryTypes;
import com.github.doomsdayrs.jikan4java.data.enums.genres.AnimeGenres;
import com.github.doomsdayrs.jikan4java.data.enums.genres.MangaGenres;
import com.github.doomsdayrs.jikan4java.data.enums.top.Tops;
import com.github.doomsdayrs.jikan4java.data.exceptions.IncompatibleEnumException;
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.data.model.main.anime.characterStaff.CharacterStaff;
import com.github.doomsdayrs.jikan4java.data.model.main.anime.episodes.Episodes;
import com.github.doomsdayrs.jikan4java.data.model.main.anime.videos.Video;
import com.github.doomsdayrs.jikan4java.data.model.main.character.Character;
import com.github.doomsdayrs.jikan4java.data.model.main.club.Club;
import com.github.doomsdayrs.jikan4java.data.model.main.club.ClubMemberPage;
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.anime.GenreSearchAnimePage;
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.manga.GenreSearchMangaPage;
import com.github.doomsdayrs.jikan4java.data.model.main.magazine.MagazinePage;
import com.github.doomsdayrs.jikan4java.data.model.main.manga.Manga;
import com.github.doomsdayrs.jikan4java.data.model.main.manga.MangaCharacters;
import com.github.doomsdayrs.jikan4java.data.model.main.person.Person;
import com.github.doomsdayrs.jikan4java.data.model.main.producer.ProducerPage;
import com.github.doomsdayrs.jikan4java.data.model.main.schedule.Day;
import com.github.doomsdayrs.jikan4java.data.model.main.season.SeasonSearch;
import com.github.doomsdayrs.jikan4java.data.model.main.season.seasonarchive.SeasonArchive;
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top;
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.anime.AnimeTop;
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.character.CharacterTop;
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.manga.MangaTop;
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.person.PersonTop;
import com.github.doomsdayrs.jikan4java.data.model.main.user.User;
import com.github.doomsdayrs.jikan4java.data.model.main.user.friends.Friends;
import com.github.doomsdayrs.jikan4java.data.model.main.user.history.HistoryPage;
import com.github.doomsdayrs.jikan4java.data.model.main.user.listing.animelist.AnimeList;
import com.github.doomsdayrs.jikan4java.data.model.main.user.listing.mangalist.MangaList;
import com.github.doomsdayrs.jikan4java.data.model.support.MoreInfo;
import com.github.doomsdayrs.jikan4java.data.model.support.forum.Forum;
import com.github.doomsdayrs.jikan4java.data.model.support.news.News;
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures;
import com.github.doomsdayrs.jikan4java.data.model.support.recommendations.RecommendationPage;
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.anime.AnimeReviewPage;
import com.github.doomsdayrs.jikan4java.data.model.support.stats.AnimeStats;
import com.github.doomsdayrs.jikan4java.data.model.support.stats.MangaStats;
import com.github.doomsdayrs.jikan4java.data.model.support.stats.Stats;
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.anime.AnimeUserUpdatesPage;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.github.doomsdayrs.jikan4java.core.Retriever.setDebugMode;

/**
 * Jikan4java
 * 47 / 44 / 2049
 *
 * @author github.com/doomsdayrs
 */
class Tester {
    private static final String[] animes = {"Boku no Hero Academia 4th Season", "Steins;Gate", "Fullmetal Alchemist: Brotherhood", "Kimetsu no Yaiba"};
    private static final String[] mangaTitles = {"Berserk", "Boku no"/*,"One punch", "Shield"*/};
    private static final Tops[] tops = {Tops.ANIME, Tops.MANGA, Tops.CHARACTERS, Tops.PEOPLE};
    private static final Days[] days = {Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY, Days.UNKNOWN, Days.OTHER};

    private static final int CONNECTOR_SIZE = 8;
    private static final int GENRES_SIZE = 2;
    private static final int USER_SIZE = 5;
    private static final int CLUB_SIZE = 2;

    /**
     * Types: Anime, Manga, Top, Connector, Days, Genres, User, Club
     */
    private static final boolean[] types = {true, true, true, true, true, true, true, true};
    private static int max = 1 + (animes.length * 12) + (mangaTitles.length * 5) + (tops.length) + CONNECTOR_SIZE + days.length + GENRES_SIZE + USER_SIZE + CLUB_SIZE;
    private static int currentProgress = 0;

    /**
     * S is for sleep, It sleeps!
     *
     * @throws InterruptedException AAAA
     */
    private static void s() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }

    private static void p(Object object) {
        System.out.println(object);
    }


    private static void progressUpdate() {
        currentProgress++;
        System.out.print("\033[H\033[2J");
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int x = 0; x < currentProgress; x++)
            stringBuilder.append("=");
        for (int x = currentProgress; x < max; x++)
            stringBuilder.append("-");
        stringBuilder.append("]").append(" ").append(currentProgress).append("/").append(max);
        System.out.println("Progress: " + stringBuilder.toString());
    }

    /**
     * Tester method
     *
     * @param args No args = run's all tests, Default all types enabled, -(type)=0 disables said type
     * @throws ExecutionException        ignored
     * @throws InterruptedException      ignored
     * @throws IncompatibleEnumException ignored
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException, IncompatibleEnumException {
        // Enables DEBUG mode
        setDebugMode(true);
        progressUpdate();
        for (String arg : args) {
            String holder = "";
            int v = arg.indexOf("=");
            if (v != -1 && v != arg.length() - 1)
                holder = arg.substring(v + 1);
            else throw new IndexOutOfBoundsException("Invalid entry!");
            int value = -1;
            try {
                value = Integer.parseInt(holder);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (value != 1 && value != 0)
                throw new IndexOutOfBoundsException("Invalid entry!");


            if (arg.toLowerCase().contains("-anime")) {
                if (value == 0) {
                    max -= (animes.length * 12);
                    types[0] = false;
                }
            } else if (arg.toLowerCase().contains("-manga")) {
                if (value == 0) {
                    max -= (mangaTitles.length * 5);
                    types[1] = false;
                }
            } else if (arg.toLowerCase().contains("-top")) {
                if (value == 0) {
                    max -= tops.length;
                    types[2] = false;
                }
            } else if (arg.toLowerCase().contains("-connector")) {
                if (value == 0) {
                    max -= CONNECTOR_SIZE;
                    types[3] = false;
                }
            } else if (arg.toLowerCase().contains("-days")) {
                if (value == 0) {
                    max -= days.length;
                    types[4] = false;
                }
            } else if (arg.toLowerCase().contains("-genre")) {
                if (value == 0) {
                    max -= GENRES_SIZE;
                    types[5] = false;
                }
            } else if (arg.toLowerCase().contains("-user")) {
                if (value == 0) {
                    max -= USER_SIZE;
                    types[6] = false;
                }
            } else if (arg.toLowerCase().contains("-club")) {
                if (value == 0) {
                    max -= CLUB_SIZE;
                    types[6] = false;
                }
            }
        }

        // Anime
        if (types[0]) {
            AnimeSearch animeSearch;
            for (String animeTitle : animes) {
                animeSearch = new AnimeSearch();
                animeSearch.setQuery(animeTitle);

                progressUpdate();
                System.out.println("\nSearching for ANIME\n");
                CompletableFuture<Anime> animeCompletableFuture = animeSearch.getFirst();
                animeCompletableFuture.thenAccept(Tester::p);
                Anime anime = animeCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nCharacter_Staff\n");
                CompletableFuture<CharacterStaff> characterStaffCompletableFuture = anime.getCharacterStaffs();
                characterStaffCompletableFuture.thenAccept(Tester::p);
                CharacterStaff character_staff = characterStaffCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nEpisodes\n");
                CompletableFuture<Episodes> episodesCompletableFuture = anime.getEpisodes();
                episodesCompletableFuture.thenAccept(Tester::p);
                Episodes episodes = episodesCompletableFuture.get();
                s();

                System.out.println("\nNews\n");
                CompletableFuture<News> newsCompletableFuture = anime.getNews();
                newsCompletableFuture.thenAccept(Tester::p);
                News news = newsCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nPictures\n");
                CompletableFuture<Pictures> picturesCompletableFuture = anime.getPictures();
                picturesCompletableFuture.thenAccept(Tester::p);
                Pictures pictures = picturesCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nVideos\n");
                CompletableFuture<Video> videoCompletableFuture = anime.getVideos();
                videoCompletableFuture.thenAccept(Tester::p);
                Video video = videoCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nStats\n");
                CompletableFuture<AnimeStats> statsCompletableFuture = anime.getStats();
                statsCompletableFuture.thenAccept(Tester::p);
                Stats stats = statsCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nForum\n");
                CompletableFuture<Forum> forumCompletableFuture = anime.getForum();
                forumCompletableFuture.thenAccept(Tester::p);
                Forum forum = forumCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nMoreInfo\n");
                CompletableFuture<MoreInfo> moreInfoCompletableFuture = anime.getMoreInfo();
                moreInfoCompletableFuture.thenAccept(Tester::p);
                MoreInfo moreInfo = moreInfoCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nReviewPage\n");
                CompletableFuture<AnimeReviewPage> reviewCompletableFuture = anime.getReviewPage();
                reviewCompletableFuture.thenAccept(Tester::p);
                AnimeReviewPage reviewPage = reviewCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nRecommendationPage\n");
                CompletableFuture<RecommendationPage> recommendCompletableFuture = anime.getRecommendationPage();
                recommendCompletableFuture.thenAccept(Tester::p);
                RecommendationPage recommendationPage = recommendCompletableFuture.get();
                s();

                progressUpdate();
                System.out.println("\nUserUpdates\n");
                CompletableFuture<AnimeUserUpdatesPage> animeUserUpdateCompletableFuture = anime.getUserUpdatesPage();
                animeUserUpdateCompletableFuture.thenAccept(Tester::p);
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
                mangaCompletableFuture.thenAccept(Tester::p);
                Manga manga = mangaCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<MangaCharacters> characterCompletableFuture = manga.getCharacters();
                characterCompletableFuture.thenAccept(Tester::p);
                MangaCharacters mangaCharacters = characterCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<News> newsCompletableFuture = manga.getNews();
                newsCompletableFuture.thenAccept(Tester::p);
                News news = newsCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<Pictures> picturesCompletableFuture = manga.getPictures();
                picturesCompletableFuture.thenAccept(Tester::p);
                Pictures pictures = picturesCompletableFuture.get();
                s();

                progressUpdate();
                CompletableFuture<MangaStats> statsCompletableFuture = manga.getStats();
                statsCompletableFuture.thenAccept(Tester::p);
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
                topCompletableFuture.thenAccept(Tester::p);
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

        Connector connector = new Connector();
        if (types[3]) {
            progressUpdate();
            CompletableFuture<Person> personCompletableFuture = connector.retrievePerson(1);
            personCompletableFuture.thenAccept(Tester::p);
            Person person = personCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<Pictures> picturesCompletableFuture = person.getPictures();
            picturesCompletableFuture.thenAccept(Tester::p);
            Pictures personPictures = picturesCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<Character> characterCompletableFuture = connector.retrieveCharacter(1);
            characterCompletableFuture.thenAccept(Tester::p);
            Character character = characterCompletableFuture.get();
            s();

            progressUpdate();
            picturesCompletableFuture = character.getPictures();
            picturesCompletableFuture.thenAccept(Tester::p);
            Pictures characterPictures = picturesCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<SeasonArchive> seasonArchiveCompletableFuture = connector.seasonArchive();
            seasonArchiveCompletableFuture.thenAccept(Tester::p);
            seasonArchiveCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<SeasonSearch> seasonSearchCompletableFuture = connector.seasonLater();
            seasonSearchCompletableFuture.thenAccept(Tester::p);
            seasonSearchCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<ProducerPage> producerPageCompletableFuture = connector.producerSearch(1, 1);
            producerPageCompletableFuture.thenAccept(Tester::p);
            producerPageCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<MagazinePage> magazinePageCompletableFuture = connector.magazineSearch(1, 1);
            magazinePageCompletableFuture.thenAccept(Tester::p);
            magazinePageCompletableFuture.get();
            s();
        }

        if (types[4]) {
            for (Days day : days) {
                progressUpdate();
                CompletableFuture<Day> daysCompletableFuture = connector.scheduleSearch(day);
                daysCompletableFuture.thenAccept(Tester::p);
                daysCompletableFuture.get();
                s();
            }
        }

        if (types[5]) {
            GenreSearch genreSearch = new GenreSearch();
            progressUpdate();
            CompletableFuture<GenreSearchAnimePage> animePageCompletableFuture = genreSearch.searchGenre(AnimeGenres.ACTION);
            animePageCompletableFuture.thenAccept(Tester::p);
            animePageCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<GenreSearchMangaPage> mangaPageCompletableFuture = genreSearch.searchGenre(MangaGenres.ACTION);
            mangaPageCompletableFuture.thenAccept(Tester::p);
            mangaPageCompletableFuture.get();
            s();
        }

        if (types[6]) {
            progressUpdate();
            CompletableFuture<User> userCompletableFuture = connector.userRetrieve("doomsdayrs");
            userCompletableFuture.thenAccept(Tester::p);
            User user = userCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<AnimeList> animeListCompletableFuture = user.getAnimeListSearch().getList();
            animeListCompletableFuture.thenAccept(Tester::p);
            animeListCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<MangaList> mangaListCompletableFuture = user.getMangaListSearch().getList();
            mangaListCompletableFuture.thenAccept(Tester::p);
            mangaListCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<Friends> friendsCompletableFuture = user.getFriends(1);
            friendsCompletableFuture.thenAccept(Tester::p);
            friendsCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<HistoryPage> animeHistoryPageCompletableFuture = user.getHistory(HistoryTypes.ANIME);
            animeHistoryPageCompletableFuture.thenAccept(Tester::p);
            animeHistoryPageCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<HistoryPage> mangaHistoryPageCompletableFuture = user.getHistory(HistoryTypes.MANGA);
            mangaHistoryPageCompletableFuture.thenAccept(Tester::p);
            mangaHistoryPageCompletableFuture.get();
            s();
        }

        if (types[7]) {
            progressUpdate();
            CompletableFuture<Club> clubCompletableFuture = connector.retrieveClub(1);
            clubCompletableFuture.thenAccept(Tester::p);
            Club club = clubCompletableFuture.get();
            s();

            progressUpdate();
            CompletableFuture<ClubMemberPage> clubMemberPageCompletableFuture = club.getMembers();
            clubMemberPageCompletableFuture.thenAccept(Tester::p);
            clubMemberPageCompletableFuture.get();

        }
        // Gets any and all errors from code
        ArrayList<String[]> errors = errorMessages;
        for (String[] error : errors) {
            System.out.println("\nError: " + error[0]);
            System.out.println("\tJSON: " + error[1]);
            System.out.println("\tURL: " + error[2]);
        }
        System.out.println("\n=== Completed ===\n");
    }
}
