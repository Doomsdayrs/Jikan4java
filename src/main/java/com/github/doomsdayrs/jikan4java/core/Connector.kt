package com.github.doomsdayrs.jikan4java.core

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.doomsdayrs.jikan4java.data.enums.Days
import com.github.doomsdayrs.jikan4java.data.enums.Season
import com.github.doomsdayrs.jikan4java.data.enums.meta.MetaPeriod
import com.github.doomsdayrs.jikan4java.data.enums.meta.MetaRequest
import com.github.doomsdayrs.jikan4java.data.enums.meta.MetaType
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.data.model.main.character.Character
import com.github.doomsdayrs.jikan4java.data.model.main.club.Club
import com.github.doomsdayrs.jikan4java.data.model.main.club.ClubMemberPage
import com.github.doomsdayrs.jikan4java.data.model.main.magazine.MagazinePage
import com.github.doomsdayrs.jikan4java.data.model.main.manga.Manga
import com.github.doomsdayrs.jikan4java.data.model.main.meta.Meta
import com.github.doomsdayrs.jikan4java.data.model.main.person.Person
import com.github.doomsdayrs.jikan4java.data.model.main.producer.ProducerPage
import com.github.doomsdayrs.jikan4java.data.model.main.schedule.Day
import com.github.doomsdayrs.jikan4java.data.model.main.schedule.Schedule
import com.github.doomsdayrs.jikan4java.data.model.main.season.SeasonSearch
import com.github.doomsdayrs.jikan4java.data.model.main.season.seasonarchive.SeasonArchive
import com.github.doomsdayrs.jikan4java.data.model.main.user.User
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.simple.parser.JSONParser
import java.util.concurrent.CompletableFuture

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
class Connector(
		client: OkHttpClient = OkHttpClient(),
		objectMapper: ObjectMapper = ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true),
		jsonParser: JSONParser = JSONParser(),
		builder: Request.Builder = Request.Builder()
) : Retriever(client, objectMapper, jsonParser, builder) {

	/**
	 * gets an club
	 *
	 * @param ID id of the club
	 * @return Club
	 */
	fun retrieveClub(ID: Int): CompletableFuture<Club> = retrieve("$baseURL/club/$ID")

	/**
	 * 35 per page
	 *
	 * @param id   of club
	 * @param page page
	 * @return Members
	 */
	fun getMembers(id: Int, page: Int): CompletableFuture<ClubMemberPage> = retrieve("$baseURL/club/$id/members/$page")

	/**
	 * Returns first page, 35 count
	 *
	 * @param id of club
	 * @return Members
	 */
	fun getMembers(id: Int): CompletableFuture<ClubMemberPage> = getMembers(id, 1)

	/**
	 * retreives an anime
	 *
	 * @param ID id of the anime
	 * @return Anime
	 */
	fun retrieveAnime(ID: Int): CompletableFuture<Anime> = retrieve("$baseURL/anime/$ID")

	/**
	 * retreives an manga
	 *
	 * @param ID id of the manga
	 * @return Manga
	 */
	fun retrieveManga(ID: Int): CompletableFuture<Manga> = retrieve("$baseURL/manga/$ID")

	/**
	 * retreives an person
	 *
	 * @param ID id of the person
	 * @return Person
	 */
	fun retrievePerson(ID: Int): CompletableFuture<Person> = retrieve("$baseURL/person/$ID")

	/**
	 * @param id id of a person
	 * @return their pictures
	 */
	fun getPersonPictures(id: Int): CompletableFuture<Pictures> = retrieve("$baseURL/person/$id/pictures")

	/**
	 * retreives an character
	 *
	 * @param ID id of the character
	 * @return Character
	 */
	fun retrieveCharacter(ID: Int): CompletableFuture<Character> =
			retrieve("$baseURL/character/$ID")

	/**
	 * @param id id of a character
	 * @return their pictures
	 */
	fun getCharacterPictures(id: Int): CompletableFuture<Pictures> =
			retrieve("$baseURL/character/$id/pictures")

	/**
	 * Returns a user object
	 *
	 * @param name the name of the user to retrieve
	 * @return User
	 */
	fun userRetrieve(name: String): CompletableFuture<User> =
			retrieve("$baseURL/user/$name")

	/**
	 * Retrieves Magazines
	 *
	 * @param ID   ID of magazine
	 * @param page page to core for
	 * @return MagazinePage object
	 */
	fun magazineSearch(ID: Int, page: Int): CompletableFuture<MagazinePage> =
			retrieve("$baseURL/magazine/$ID/$page")

	/**
	 * Gets meta data from API. WARNING USING MAY CAUSE ERRORS BEYOND IMAGINATION FOR ANYTHING BUT STATUS
	 *
	 * @param metaRequest REQUEST / STATUS
	 * @param metaType    ANIME / CHARACTER / MANGA / PERSON / SEARCH / SCHEDULE / SEASON / TOP
	 * @param metaPeriod  MONTHLY / WEEKLY / TODAY
	 * @return Completable future of metaRequest's class
	 */
	inline fun <reified T : Class<V>, V : Meta> getMeta(
			metaRequest: MetaRequest,
			metaType: MetaType,
			metaPeriod: MetaPeriod
	): CompletableFuture<T>? {
		val option = StringBuilder()
		option.append(metaRequest)

		if (metaRequest == MetaRequest.REQUEST) {
			option.append("/").append(metaType)
			option.append("/").append(metaPeriod)
		}
		return retrieve("$baseURL/meta/$option")
	}

	/**
	 * Retrieves Producer
	 *
	 * @param ID   ID of magazine
	 * @param page page to core for
	 * @return Producer object
	 */
	fun producerSearch(ID: Int, page: Int): CompletableFuture<ProducerPage> =
			retrieve("$baseURL/producer/$ID/$page")

	/**
	 * Returns current schedule for all anime
	 *
	 * @return Schedule
	 */
	val currentSchedule: CompletableFuture<Schedule>
		get() = retrieve("$baseURL/schedule")

	/**
	 * Returns all anime schedule on a certain day
	 *
	 * @param day Day to retrieve, Can also be other or unknown
	 * @return DaySchedule object
	 */
	fun scheduleSearch(day: Days): CompletableFuture<Day> =
			retrieve("$baseURL/schedule/$day")

	/**
	 * Searches for anime by season
	 *
	 * @param year   Year
	 * @param season Season
	 * @return SeasonSearchObject
	 */
	fun seasonSearch(year: Int, season: Season): CompletableFuture<SeasonSearch> =
			retrieve("$baseURL/season/$year/$season")

	/**
	 * Returns next season of anime
	 *
	 * @return SeasonSearchObject
	 */
	fun seasonLater(): CompletableFuture<SeasonSearch> = retrieve("$baseURL/season/later")

	/**
	 * Returns archive of all possible seasons and years
	 *
	 * @return SeasonArchive
	 */
	fun seasonArchive(): CompletableFuture<SeasonArchive> = retrieve( "$baseURL/season/archive")
}