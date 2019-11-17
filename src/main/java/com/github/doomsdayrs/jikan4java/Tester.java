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

import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.types.main.anime.character_staff.Character_Staff;
import com.github.doomsdayrs.jikan4java.types.main.anime.episodes.Episodes;
import com.github.doomsdayrs.jikan4java.types.main.anime.videos.Video;
import com.github.doomsdayrs.jikan4java.types.support.MoreInfo;
import com.github.doomsdayrs.jikan4java.types.support.forum.Forum;
import com.github.doomsdayrs.jikan4java.types.support.news.News;
import com.github.doomsdayrs.jikan4java.types.support.pictures.Pictures;
import com.github.doomsdayrs.jikan4java.types.support.recommendations.RecommendationPage;
import com.github.doomsdayrs.jikan4java.types.support.reviews.anime.AnimeReviewPage;
import com.github.doomsdayrs.jikan4java.types.support.stats.Stats;
import com.github.doomsdayrs.jikan4java.types.support.userupdate.anime.AnimeUserUpdatesPage;

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


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Enables DEBUG mode
        setDebugMode(true);

        // Anime
        AnimeSearch animeSearch;
        for (String animeTitle : animes) {
            animeSearch = new AnimeSearch();
            animeSearch.setQuery(animeTitle);

            System.out.println("\nSearching for ANIME\n");
            CompletableFuture<Anime> animeCompletableFuture = animeSearch.getFirst();
            animeCompletableFuture.thenAccept(System.out::println);
            Anime anime = animeCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nCharacter_Staff\n");
            CompletableFuture<Character_Staff> characterStaffCompletableFuture = anime.getCharacterStaffs();
            characterStaffCompletableFuture.thenAccept(System.out::println);
            Character_Staff character_staff = characterStaffCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nEpisodes\n");
            CompletableFuture<Episodes> episodesCompletableFuture = anime.getEpisodes();
            episodesCompletableFuture.thenAccept(System.out::println);
            Episodes episodes = episodesCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nNews\n");
            CompletableFuture<News> newsCompletableFuture = anime.getNews();
            newsCompletableFuture.thenAccept(System.out::println);
            News news = newsCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nPictures\n");
            CompletableFuture<Pictures> picturesCompletableFuture = anime.getPictures();
            picturesCompletableFuture.thenAccept(System.out::println);
            Pictures pictures = picturesCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nVideos\n");
            CompletableFuture<Video> videoCompletableFuture = anime.getVideos();
            videoCompletableFuture.thenAccept(System.out::println);
            Video video = videoCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nStats\n");
            CompletableFuture<Stats> statsCompletableFuture = anime.getStats();
            statsCompletableFuture.thenAccept(System.out::println);
            Stats stats = statsCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nForum\n");
            CompletableFuture<Forum> forumCompletableFuture = anime.getForum();
            forumCompletableFuture.thenAccept(System.out::println);
            Forum forum = forumCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nMoreInfo\n");
            CompletableFuture<MoreInfo> moreInfoCompletableFuture = anime.getMoreInfo();
            moreInfoCompletableFuture.thenAccept(System.out::println);
            MoreInfo moreInfo = moreInfoCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nReviewPage\n");
            CompletableFuture<AnimeReviewPage> reviewCompletableFuture = anime.getReviewPage();
            reviewCompletableFuture.thenAccept(System.out::println);
            AnimeReviewPage reviewPage = reviewCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nRecommendationPage\n");
            CompletableFuture<RecommendationPage> recommendCompletableFuture = anime.getRecommendationPage();
            recommendCompletableFuture.thenAccept(System.out::println);
            RecommendationPage recommendationPage = recommendCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);

            System.out.println("\nUserUpdates\n");
            CompletableFuture<AnimeUserUpdatesPage> animeUserUpdateCompletableFuture = anime.getUserUpdatesPage();
            animeUserUpdateCompletableFuture.thenAccept(System.out::println);
            AnimeUserUpdatesPage animeUserUpdatesPage = animeUserUpdateCompletableFuture.get();
            TimeUnit.SECONDS.sleep(4);
        }
        System.out.println("\n=== Completed ===\n");
    }
}
