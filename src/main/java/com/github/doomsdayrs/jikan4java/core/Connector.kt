package com.github.doomsdayrs.jikan4java.core

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
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
import com.github.doomsdayrs.jikan4java.data.model.main.schedule.SchedulePage
import com.github.doomsdayrs.jikan4java.data.model.main.season.SeasonPage
import com.github.doomsdayrs.jikan4java.data.model.main.season.seasonarchive.SeasonArchivePage
import com.github.doomsdayrs.jikan4java.data.model.main.user.User
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
	val retriever: Retriever
) {
	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("SchedulePage.getSchedule(retriever)")
	)
	val currentSchedulePage: CompletableFuture<JikanResult<SchedulePage>>
		get() = SchedulePage.getSchedule(retriever)

	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("Club.getByID(retriever,ID)")
	)
	fun retrieveClub(ID: Int) = Club.getByID(retriever, ID)


	@Deprecated(
		"Moved to companion",
		ReplaceWith("ClubMemberPage.get(retriever,id,1)")
	)
	@Suppress("MemberVisibilityCanBePrivate")
	fun getMembers(
		id: Int,
		page: Int
	): CompletableFuture<JikanResult<ClubMemberPage>> =
		ClubMemberPage.get(retriever, id, page)


	@Deprecated(
		"Moved to companion",
		ReplaceWith("ClubMemberPage.get(retriever,id,1)")
	)
	fun getMembers(id: Int) = getMembers(id, 1)

	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("Anime.getByID(retriever,ID)")
	)
	fun retrieveAnime(ID: Int) = Anime.getByID(retriever, ID)

	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("Manga.getByID(retriever,ID)")
	)
	fun retrieveManga(ID: Int) = Manga.getByID(retriever, ID)

	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("Person.getByID(retriever,ID)")
	)
	fun retrievePerson(ID: Int) = Person.getByID(retriever, ID)

	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("Person.getPicturesByID(retriever,id)")
	)
	fun getPersonPictures(id: Int) = Person.getPictures(retriever, id)

	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("Character.getByID(retriever,ID)")
	)
	fun retrieveCharacter(ID: Int) = Character.getByID(retriever, ID)


	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("Character.getPicturesByID(retriever,id)")
	)
	fun getCharacterPictures(id: Int) = Character.getPictures(retriever, id)

	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("User.getByName(retriever,name)")
	)
	fun userRetrieve(name: String): CompletableFuture<JikanResult<User>> =
		User.getByName(retriever, name)


	@Deprecated(
		"Moved to companion",
		replaceWith = ReplaceWith("MagazinePage.get(retriever,ID,page)")
	)
	fun magazineSearch(
		ID: Int,
		page: Int
	): CompletableFuture<JikanResult<MagazinePage>> =
		MagazinePage.get(retriever, ID, page)

	/**
	 * Gets meta data from API.
	 * WARNING USING MAY CAUSE ERRORS BEYOND IMAGINATION FOR ANYTHING BUT STATUS
	 *
	 * @param metaRequest REQUEST / STATUS
	 * @param metaType    ANIME / CHARACTER / MANGA / PERSON / SEARCH / SCHEDULE / SEASON / TOP
	 * @param metaPeriod  MONTHLY / WEEKLY / TODAY
	 * @return Completable future of metaRequest's class
	 */
	@Deprecated("Just don't use ever, Look at the JikanStatus object and use its get")
	inline fun <reified T : Class<V>, V : Meta> getMeta(
		metaRequest: MetaRequest,
		metaType: MetaType,
		metaPeriod: MetaPeriod
	): CompletableFuture<JikanResult<T>> {
		val option = StringBuilder()
		option.append(metaRequest)

		if (metaRequest == MetaRequest.REQUEST) {
			option.append("/").append(metaType)
			option.append("/").append(metaPeriod)
		}
		return retriever("$JIKAN_URL/meta/$option")
	}

	@Deprecated(
		"Moved to companion",
		ReplaceWith(
			"ProducerPage.search(retriever,ID,page)",
			"com.github.doomsdayrs.jikan4java.data.model.main.producer.ProducerPage"
		)
	)
	fun producerSearch(
		ID: Int,
		page: Int
	) = ProducerPage.search(retriever, ID, page)


	@Deprecated(
		"Moved to companion",
		ReplaceWith("SeasonPage.get(retriever,year,season)")
	)
	fun seasonSearch(
		year: Int,
		season: Season
	): CompletableFuture<JikanResult<SeasonPage>> =
		SeasonPage.get(retriever, year, season)


	@Deprecated(
		"Moved to companion",
		ReplaceWith("SeasonPage.getNextSeason(retriever)")
	)
	fun seasonLater() = SeasonPage.getNextSeason(retriever)

	@Deprecated(
		"Moved to companion",
		ReplaceWith("SeasonArchivePage.get(retriever)")
	)
	fun seasonArchive() = SeasonArchivePage.get(retriever)
}