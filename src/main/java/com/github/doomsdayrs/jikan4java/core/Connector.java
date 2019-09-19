package com.github.doomsdayrs.jikan4java.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.doomsdayrs.jikan4java.enums.Days;
import com.github.doomsdayrs.jikan4java.enums.Season;
import com.github.doomsdayrs.jikan4java.enums.meta.MetaPeriod;
import com.github.doomsdayrs.jikan4java.enums.meta.MetaRequest;
import com.github.doomsdayrs.jikan4java.enums.meta.MetaType;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.types.main.club.Club;
import com.github.doomsdayrs.jikan4java.types.main.magazine.MagazinePage;
import com.github.doomsdayrs.jikan4java.types.main.manga.Manga;
import com.github.doomsdayrs.jikan4java.types.main.person.Person;
import com.github.doomsdayrs.jikan4java.types.main.producer.ProducerPage;
import com.github.doomsdayrs.jikan4java.types.main.schedule.Day;
import com.github.doomsdayrs.jikan4java.types.main.schedule.Schedule;
import com.github.doomsdayrs.jikan4java.types.main.season.SeasonSearch;
import com.github.doomsdayrs.jikan4java.types.main.season.seasonarchive.SeasonArchive;
import com.github.doomsdayrs.jikan4java.types.main.user.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
//TODO Create Documentation detailing the need to convert their old deprecated Connection classes to this connector

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
     * gets an club
     *
     * @param ID id of the club
     * @return Club
     */
    public CompletableFuture<Club> retrieveClub(int ID) {
        return retrieve(Club.class, baseURL + "/club/" + ID);
    }

    /**
     * retreives an anime
     *
     * @param ID id of the anime
     * @return Anime
     */
    public CompletableFuture<Anime> retrieveAnime(int ID) {
        return retrieve(Anime.class, baseURL + "/anime/" + ID);
    }

    /**
     * retreives an manga
     *
     * @param ID id of the manga
     * @return Manga
     */
    public CompletableFuture<Manga> retrieveManga(int ID) {
        return retrieve(Manga.class, baseURL + "/manga/" + ID);
    }

    /**
     * retreives an person
     *
     * @param ID id of the person
     * @return Person
     */
    public CompletableFuture<Person> retrievePerson(int ID) {
        return retrieve(Person.class, baseURL + "/manga/" + ID);
    }

    /**
     * retreives an character
     *
     * @param ID id of the character
     * @return Character
     */
    public CompletableFuture<Character> retrieveCharacter(int ID) {
        return retrieve(Character.class, baseURL + "/manga/" + ID);
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
     * Gets meta data from API. WARNING USING MAY CAUSE ERRORS BEYOND IMAGINATION FOR ANYTHING BUT STATUS
     * @param metaRequest
     * @param metaType
     * @param metaPeriod
     * @return
     */
    public CompletableFuture getMeta(MetaRequest metaRequest, MetaType metaType, MetaPeriod metaPeriod) {
        if (metaRequest == null) return null;

        StringBuilder option = new StringBuilder();
        option.append(metaRequest);
        if (metaRequest.equals(MetaRequest.REQUEST)) {
            if (metaType != null) {
                option.append("/").append(metaType);
                if (metaPeriod != null) {
                    option.append("/").append(metaPeriod);
                } else return null;
            } else return null;
        }
        return retrieve(metaRequest.getaClass(), baseURL + "/meta/" + option.toString());
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

}
