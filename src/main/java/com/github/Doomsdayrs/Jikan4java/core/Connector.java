package com.github.Doomsdayrs.Jikan4java.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.exceptions.IncompatibleEnumException;
import com.github.Doomsdayrs.Jikan4java.types.Main.Club.Club;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Anime.GenreSearchAnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.GenreSearch.Manga.GenreSearchMangaPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Magazine.MagazinePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Meta.Status;
import com.github.Doomsdayrs.Jikan4java.types.Main.Producer.ProducerPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Day;
import com.github.Doomsdayrs.Jikan4java.types.Main.Schedule.Schedule;
import com.github.Doomsdayrs.Jikan4java.types.Main.Season.SeasonArchive.SeasonArchive;
import com.github.Doomsdayrs.Jikan4java.types.Main.Season.SeasonSearch;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Top;
import com.github.Doomsdayrs.Jikan4java.types.Main.User.User;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Days;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Season;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.AnimeGenres;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.Genres;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.MangaGenres;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.top.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
//TODO Create Documentation detailing the need to convert their old deprecated Connection classes to this connector

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
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Connector extends Retriever {

    public Connector() {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
    }

    public Connector(OkHttpClient client) {
        super(client);
    }

    public Connector(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    public Connector(JSONParser jsonParser) {
        super(jsonParser);
    }

    public Connector(Request.Builder builder) {
        super(builder);
    }

    /**
     * retreives a club
     *
     * @param ID id of the club
     * @return AnimePage
     */
    public CompletableFuture<Club> clubSearch(int ID) {
        return retrieve(Club.class, baseURL + "/club/" + ID);
    }

    /**
     * Retrieves Magazines
     *
     * @param ID   ID of magazine
     * @param page page to core for
     * @return MagazinePage object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<MagazinePage> magazineSearch(int ID, int page) {
        return retrieve(MagazinePage.class, baseURL + "/magazine/" + ID + "/" + page);
    }

    /**
     * Gets status of Jikans api
     *
     * @return Status object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<Status> getStatus() {
        return retrieve(Status.class, baseURL + "/meta/status");
    }

    /**
     * Retrieves Producer
     *
     * @param ID   ID of magazine
     * @param page page to core for
     * @return Producer object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<ProducerPage> producerSearch(int ID, int page) {
        return retrieve(ProducerPage.class, baseURL + "/producer/" + ID + "/" + page);
    }

    /**
     * Returns current schedule for all anime
     *
     * @return Schedule
     */
    public CompletableFuture<Schedule> getCurrentSchedule() {
        return retrieve(Schedule.class, baseURL + "/schedule");
    }


    /**
     * Returns all anime schedule on a certain day
     *
     * @param day Day to retrieve, Can also be other or unknown
     * @return DaySchedule object
     */
    public CompletableFuture<Day> scheduleSearch(Days day) {
        if (day != null)
            return retrieve(day.getaClass(), baseURL + "/schedule/" + day);
        return null;
    }

    /**
     * Searches for anime by season
     *
     * @param year   Year
     * @param season Season
     * @return SeasonSearchObject
     */
    public CompletableFuture<SeasonSearch> seasonSearch(int year, Season season) {
        return retrieve(SeasonSearch.class, baseURL + "/season/" + year + "/" + season);

    }

    /**
     * Returns next season of anime
     *
     * @return SeasonSearchObject
     */
    public CompletableFuture<SeasonSearch> seasonLater() {
        return retrieve(SeasonSearch.class, baseURL + "/season/later");
    }

    /**
     * Returns archive of all possible seasons and years
     *
     * @return SeasonArchive
     */
    public CompletableFuture<SeasonArchive> seasonArchive() {
        return retrieve(SeasonArchive.class, baseURL + "/season/archive");
    }

    /**
     * Returns a user object
     *
     * @param name the name of the user to retrieve
     * @return User
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<User> userSearch(String name) {
        return retrieve(User.class, baseURL + "/user/" + name);
    }

    //Top Searching

    /**
     * Searches the top charts of MAL, with all default cases
     *
     * @param tops What type of media: anime, manga, people, characters
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops) throws IncompatibleEnumException {
        return searchCore(tops, 0, null);
    }

    /**
     * Searches the top charts of MAL, with subtype defaulted
     *
     * @param tops       What type of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, null);
    }


    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What type of media: anime, manga, people, characters
     * @param subtype Shared subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, SharedTops subtype) throws IncompatibleEnumException {
        return searchTopSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What type of media: anime, manga, people, characters
     * @param subtype The Anime subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, AnimeTops subtype) throws IncompatibleEnumException {
        return searchTopSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What type of media: anime, manga, people, characters
     * @param subtype The Manga subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, MangaTops subtype) throws IncompatibleEnumException {
        return searchTopSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, with subtype defaulted
     *
     * @param tops    What type of media: anime, manga, people, characters
     * @param subtype The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTopSub(Tops tops, TopSubType subtype) throws IncompatibleEnumException {
        return searchCore(tops, 0, subtype);
    }


    /**
     * Searches the top charts of MAL
     *
     * @param tops       What type of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber, AnimeTops subtype) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, subtype);
    }

    /**
     * Searches the top charts of MAL
     *
     * @param tops       What type of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber, MangaTops subtype) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, subtype);
    }

    /**
     * Searches the top charts of MAL
     *
     * @param tops       What type of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber, SharedTops subtype) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, subtype);
    }


    /**
     * Searches the top charts of MAL
     *
     * @param tops       What type of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchCore(Tops tops, int pageNumber, TopSubType subtype) throws IncompatibleEnumException {
        if (tops == null) throw new EnumConstantNotPresentException(Tops.class, "Tops type not present!");
        StringBuilder options = new StringBuilder();
        if (pageNumber == 0) pageNumber = 1;
        options.append("/");
        options.append(pageNumber);
        if (subtype != null) {
            if (tops.compatible(subtype))
                options.append("/").append(subtype);
            else throw new IncompatibleEnumException(tops + " is not compatible with " + subtype);
        }
        return retrieve(tops.getaClass(), baseURL + "/top/" + tops + options.toString());
    }

    //GenreSearching

    /**
     * Searches for Anime/manga by genre, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    public CompletableFuture<GenreSearchAnimePage> searchGenre(AnimeGenres genreID) {
        return searchGenrePage(genreID, 1);
    }

    /**
     * Searches for Anime/manga by genre, Returns first page
     *
     * @param genreID The genre ID
     * @return GenreSearchMangaPage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID) {
        return searchGenrePage(genreID, 1);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchAnimePage> searchGenre(AnimeGenres genreID, int page) {
        return searchGenrePage(genreID, page);
    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture<GenreSearchMangaPage> searchGenre(MangaGenres genreID, int page) {
        return searchGenrePage(genreID, page);

    }

    /**
     * Searches for Anime/manga by genre, There are more than one page since each page has a hundred entries max.
     *
     * @param genreID The genre ID
     * @param page    The page number to go to, 0 should be the default unless you know else wise
     * @return GenreSearchAnimePage
     */
    public CompletableFuture searchGenrePage(Genres genreID, int page) {
        return retrieve(GenreSearchAnimePage.class, baseURL + "/genre/" + genreID.getType() + "/" + genreID.getId() + "/" + page);
    }


}
