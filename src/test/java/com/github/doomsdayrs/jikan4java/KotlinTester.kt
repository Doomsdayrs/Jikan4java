package com.github.doomsdayrs.jikan4java

import com.github.doomsdayrs.jikan4java.common.debugMode
import com.github.doomsdayrs.jikan4java.core.Connector
import com.github.doomsdayrs.jikan4java.core.Retriever.Companion.errorMessages
import com.github.doomsdayrs.jikan4java.core.search.GenreSearch
import com.github.doomsdayrs.jikan4java.core.search.TopSearch
import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch
import com.github.doomsdayrs.jikan4java.core.search.animemanga.MangaSearch
import com.github.doomsdayrs.jikan4java.data.enums.Days
import com.github.doomsdayrs.jikan4java.data.enums.HistoryTypes
import com.github.doomsdayrs.jikan4java.data.enums.genres.AnimeGenres
import com.github.doomsdayrs.jikan4java.data.enums.genres.MangaGenres
import com.github.doomsdayrs.jikan4java.data.exceptions.IncompatibleEnumException
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.data.model.main.anime.characterStaff.CharacterStaff
import com.github.doomsdayrs.jikan4java.data.model.main.anime.episodes.Episodes
import com.github.doomsdayrs.jikan4java.data.model.main.anime.videos.Video
import com.github.doomsdayrs.jikan4java.data.model.main.character.Character
import com.github.doomsdayrs.jikan4java.data.model.main.club.Club
import com.github.doomsdayrs.jikan4java.data.model.main.club.ClubMemberPage
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.anime.GenreSearchAnimePage
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.manga.GenreSearchMangaPage
import com.github.doomsdayrs.jikan4java.data.model.main.magazine.MagazinePage
import com.github.doomsdayrs.jikan4java.data.model.main.manga.Manga
import com.github.doomsdayrs.jikan4java.data.model.main.manga.MangaCharacters
import com.github.doomsdayrs.jikan4java.data.model.main.person.Person
import com.github.doomsdayrs.jikan4java.data.model.main.producer.ProducerPage
import com.github.doomsdayrs.jikan4java.data.model.main.schedule.Day
import com.github.doomsdayrs.jikan4java.data.model.main.season.SeasonSearch
import com.github.doomsdayrs.jikan4java.data.model.main.season.seasonarchive.SeasonArchive
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top
import com.github.doomsdayrs.jikan4java.data.model.main.user.User
import com.github.doomsdayrs.jikan4java.data.model.main.user.friends.FriendPage
import com.github.doomsdayrs.jikan4java.data.model.main.user.history.HistoryPage
import com.github.doomsdayrs.jikan4java.data.model.main.user.listing.animelist.AnimeList
import com.github.doomsdayrs.jikan4java.data.model.main.user.listing.mangalist.MangaList
import com.github.doomsdayrs.jikan4java.data.model.support.MoreInfo
import com.github.doomsdayrs.jikan4java.data.model.support.forum.Forum
import com.github.doomsdayrs.jikan4java.data.model.support.news.News
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures
import com.github.doomsdayrs.jikan4java.data.model.support.recommendations.RecommendationPage
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.anime.AnimeReviewPage
import com.github.doomsdayrs.jikan4java.data.model.support.stats.AnimeStats
import com.github.doomsdayrs.jikan4java.data.model.support.stats.MangaStats
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.anime.AnimeUserUpdatesPage
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

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
 */ /**
 * Jikan4java
 * 47 / 44 / 2049
 *
 * @author github.com/doomsdayrs
 */
internal object KotlinTester {

	private val animes = arrayOf("Boku no Hero Academia 4th Season", "Steins;Gate", "Fullmetal Alchemist: Brotherhood", "Kimetsu no Yaiba")
	private val mangaTitles = arrayOf("Berserk", "Boku no" /*,"One punch", "Shield"*/)
	private val tops = arrayOf(TopSearch.ANIME, TopSearch.MANGA, TopSearch.CHARACTER)
	private val days = arrayOf(Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY, Days.UNKNOWN, Days.OTHER)
	private const val CONNECTOR_SIZE = 8
	private const val GENRES_SIZE = 2
	private const val USER_SIZE = 5
	private const val CLUB_SIZE = 2
	private const val USER_NAME = "Parisbelle"

	/** Types: Anime, Manga, Top, Connector, Days, Genres, User, Club */
	private val types = booleanArrayOf(
			true,//Anime
			true,//Manga
			true,//Top
			true,//Connector
			true,//Days
			true,//Genres
			true,//User
			true//Club
	)
	private var max = 1 + animes.size * 12 + mangaTitles.size * 5 + tops.size + CONNECTOR_SIZE + days.size + GENRES_SIZE + USER_SIZE + CLUB_SIZE
	private var currentProgress = 0

	private fun p(`object`: Any?) {
		println(`object`)
	}

	private fun progressUpdate() {
		currentProgress++
		print("\u001b[H\u001b[2J")
		val stringBuilder = StringBuilder("[")
		for (x in 0 until currentProgress) stringBuilder.append("=")
		for (x in currentProgress until max) stringBuilder.append("-")
		stringBuilder.append("]").append(" ").append(currentProgress).append("/").append(max)
		println("Progress: $stringBuilder")
	}

	/**
	 * Tester method
	 *
	 * @param args No args = run's all tests, Default all types enabled, -(type)=0 disables said type
	 * @throws ExecutionException        ignored
	 * @throws InterruptedException      ignored
	 * @throws IncompatibleEnumException ignored
	 */
	@Throws(ExecutionException::class, InterruptedException::class, IncompatibleEnumException::class)
	@JvmStatic
	fun main(args: Array<String>) {
		setupTest()
		progressUpdate()
		testAnime()
		testManga()
		testSearch()
		testGeneralConnector()
		testDay()
		testGenre()
		testUser()
		testClub()
		finnaly()
	}

	@Before
	fun setupTest() {
		debugMode = true
	}

	@Test
	fun testAnime() {
		if (types[0]) {
			var animeSearch: AnimeSearch
			for (animeTitle in animes) {
				animeSearch = AnimeSearch()
				animeSearch.setQuery(animeTitle)
				progressUpdate()
				println("\nSearching for ANIME\n")
				val animeCompletableFuture = animeSearch.getFirst<Anime>()
				animeCompletableFuture!!.thenAccept { obj: Anime? -> p(obj) }
				val anime: Anime = animeCompletableFuture.get()

				progressUpdate()
				println("\nCharacter_Staff\n")
				val characterStaffCompletableFuture = anime.characterStaffs
				characterStaffCompletableFuture.thenAccept { obj: CharacterStaff? -> p(obj) }
				characterStaffCompletableFuture.get()

				progressUpdate()
				println("\nEpisodes\n")
				val episodesCompletableFuture = anime.getEpisodeCount()
				episodesCompletableFuture.thenAccept { obj: Episodes? -> p(obj) }
				episodesCompletableFuture.get()

				println("\nNews\n")
				val newsCompletableFuture = anime.news
				newsCompletableFuture.thenAccept { obj: News? -> p(obj) }
				newsCompletableFuture.get()

				progressUpdate()
				println("\nPictures\n")
				val picturesCompletableFuture = anime.pictures
				picturesCompletableFuture.thenAccept { obj: Pictures? -> p(obj) }
				picturesCompletableFuture.get()

				progressUpdate()
				println("\nVideos\n")
				val videoCompletableFuture = anime.videos
				videoCompletableFuture.thenAccept { obj: Video? -> p(obj) }
				videoCompletableFuture.get()

				progressUpdate()
				println("\nStats\n")
				val statsCompletableFuture = anime.stats
				statsCompletableFuture.thenAccept { obj: AnimeStats? -> p(obj) }
				statsCompletableFuture.get()

				progressUpdate()
				println("\nForum\n")
				val forumCompletableFuture = anime.forum
				forumCompletableFuture.thenAccept { obj: Forum? -> p(obj) }
				forumCompletableFuture.get()

				progressUpdate()
				println("\nMoreInfo\n")
				val moreInfoCompletableFuture = anime.moreInfo
				moreInfoCompletableFuture.thenAccept { obj: MoreInfo? -> p(obj) }
				moreInfoCompletableFuture.get()

				progressUpdate()
				println("\nReviewPage\n")
				val reviewCompletableFuture = anime.reviewPage
				reviewCompletableFuture.thenAccept { obj: AnimeReviewPage? -> p(obj) }
				reviewCompletableFuture.get()

				progressUpdate()
				println("\nRecommendationPage\n")
				val recommendCompletableFuture = anime.recommendationPage
				recommendCompletableFuture.thenAccept { obj: RecommendationPage? -> p(obj) }
				recommendCompletableFuture.get()

				progressUpdate()
				println("\nUserUpdates\n")
				val animeUserUpdateCompletableFuture = anime.userUpdatesPage
				animeUserUpdateCompletableFuture.thenAccept { obj: AnimeUserUpdatesPage? -> p(obj) }
				animeUserUpdateCompletableFuture.get()

			}
		}
	}

	@Test
	fun testManga() {
		if (types[1]) {
			var mangaSearch: MangaSearch
			for (mangaTitle in mangaTitles) {
				mangaSearch = MangaSearch()
				mangaSearch.setQuery(mangaTitle)
				progressUpdate()
				println("Searching Manga: $mangaTitle")
				val mangaCompletableFuture = mangaSearch.getFirst<Manga>()
				mangaCompletableFuture!!.thenAccept { obj: Manga? -> p(obj) }
				val manga = mangaCompletableFuture.get()

				progressUpdate()
				val characterCompletableFuture = manga.characters
				characterCompletableFuture.thenAccept { obj: MangaCharacters? -> p(obj) }
				characterCompletableFuture.get()

				progressUpdate()
				val newsCompletableFuture = manga.news
				newsCompletableFuture.thenAccept { obj: News? -> p(obj) }
				newsCompletableFuture.get()

				progressUpdate()
				val picturesCompletableFuture = manga.pictures
				picturesCompletableFuture.thenAccept { obj: Pictures? -> p(obj) }
				picturesCompletableFuture.get()

				progressUpdate()
				val statsCompletableFuture = manga.stats
				statsCompletableFuture.thenAccept { obj: MangaStats? -> p(obj) }
				statsCompletableFuture.get()
			}
		}
	}

	@Test
	fun testSearch() {
		if (types[2]) {
			var topSearch: TopSearch
			run {
				topSearch = TopSearch()
				progressUpdate()
				println("\n")
				val topCompletableFuture = topSearch.searchTop(TopSearch.ANIME)
				topCompletableFuture.thenAccept { obj: Top<*>? -> p(obj) }
				topCompletableFuture.get()
			}
			run {
				topSearch = TopSearch()
				progressUpdate()
				println("\n")
				val topCompletableFuture = topSearch.searchTop(TopSearch.MANGA)
				topCompletableFuture.thenAccept { obj: Top<*>? -> p(obj) }
				topCompletableFuture.get()
			}
			run {
				topSearch = TopSearch()
				progressUpdate()
				println("\n")
				val topCompletableFuture = topSearch.searchTop(TopSearch.CHARACTER)
				topCompletableFuture.thenAccept { obj: Top<*>? -> p(obj) }
				topCompletableFuture.get()
			}
			run {
				topSearch = TopSearch()
				progressUpdate()
				println("\n")
				val topCompletableFuture = topSearch.searchTop(TopSearch.PERSON)
				topCompletableFuture.thenAccept { obj: Top<*>? -> p(obj) }
				topCompletableFuture.get()
			}
		}
	}

	@Test
	fun testGeneralConnector() {
		val connector = Connector()
		if (types[3]) {
			progressUpdate()
			val personCompletableFuture = connector.retrievePerson(1)
			personCompletableFuture.thenAccept { obj: Person? -> p(obj) }
			val person = personCompletableFuture.get()

			progressUpdate()
			var picturesCompletableFuture: CompletableFuture<Pictures> = person.pictures
			picturesCompletableFuture.thenAccept { obj: Pictures? -> p(obj) }
			picturesCompletableFuture.get()

			progressUpdate()
			val characterCompletableFuture = connector.retrieveCharacter(1)
			characterCompletableFuture.thenAccept { obj: Character? -> p(obj) }
			val character = characterCompletableFuture.get()

			progressUpdate()
			picturesCompletableFuture = character.pictures
			picturesCompletableFuture.thenAccept { obj: Pictures? -> p(obj) }
			picturesCompletableFuture.get()

			progressUpdate()
			val seasonArchiveCompletableFuture = connector.seasonArchive()
			seasonArchiveCompletableFuture.thenAccept { obj: SeasonArchive? -> p(obj) }
			seasonArchiveCompletableFuture.get()

			progressUpdate()
			val seasonSearchCompletableFuture = connector.seasonLater()
			seasonSearchCompletableFuture.thenAccept { obj: SeasonSearch? -> p(obj) }
			seasonSearchCompletableFuture.get()

			progressUpdate()
			val producerPageCompletableFuture = connector.producerSearch(1, 1)
			producerPageCompletableFuture.thenAccept { obj: ProducerPage? -> p(obj) }
			producerPageCompletableFuture.get()

			progressUpdate()
			val magazinePageCompletableFuture = connector.magazineSearch(1, 1)
			magazinePageCompletableFuture.thenAccept { obj: MagazinePage? -> p(obj) }
			magazinePageCompletableFuture.get()

		}
	}

	@Test
	fun testDay() {
		val connector = Connector()
		if (types[4]) {
			for (day in days) {
				progressUpdate()
				val daysCompletableFuture = connector.scheduleSearch(day)
				daysCompletableFuture.thenAccept { obj: Day? -> p(obj) }
				daysCompletableFuture.get()

			}
		}
	}

	@Test
	fun testGenre() {
		val connector = Connector()
		if (types[5]) {
			val genreSearch = GenreSearch()
			progressUpdate()
			val animePageCompletableFuture = genreSearch.searchGenre(AnimeGenres.ACTION)
			animePageCompletableFuture.thenAccept { obj: GenreSearchAnimePage? -> p(obj) }
			animePageCompletableFuture.get()

			progressUpdate()
			val mangaPageCompletableFuture = genreSearch.searchGenre(MangaGenres.ACTION)
			mangaPageCompletableFuture.thenAccept { obj: GenreSearchMangaPage? -> p(obj) }
			mangaPageCompletableFuture.get()

		}
	}

	@Test
	fun testUser() {
		val connector = Connector()
		if (types[6]) {
			progressUpdate()
			val userCompletableFuture = connector.userRetrieve(USER_NAME)
			userCompletableFuture.thenAccept { obj: User? -> p(obj) }
			val user = userCompletableFuture.get()

			progressUpdate()
			val animeListCompletableFuture = user.animeListSearch.list
			animeListCompletableFuture.thenAccept { obj: AnimeList? -> p(obj) }
			animeListCompletableFuture.get()

			progressUpdate()
			val mangaListCompletableFuture = user.mangaListSearch.list
			mangaListCompletableFuture.thenAccept { obj: MangaList? -> p(obj) }
			mangaListCompletableFuture.get()

			progressUpdate()
			val friendsCompletableFuture = user.getFriends(1)
			friendsCompletableFuture.thenAccept { obj: FriendPage? -> p(obj) }
			friendsCompletableFuture.get()

			progressUpdate()
			val animeHistoryPageCompletableFuture = user.getHistory(HistoryTypes.ANIME)
			animeHistoryPageCompletableFuture.thenAccept { obj: HistoryPage? -> p(obj) }
			animeHistoryPageCompletableFuture.get()

			progressUpdate()
			val mangaHistoryPageCompletableFuture = user.getHistory(HistoryTypes.MANGA)
			mangaHistoryPageCompletableFuture.thenAccept { obj: HistoryPage? -> p(obj) }
			mangaHistoryPageCompletableFuture.get()

		}
	}

	@Test
	fun testClub() {
		val connector = Connector()
		if (types[7]) {
			progressUpdate()
			val clubCompletableFuture = connector.retrieveClub(1)
			clubCompletableFuture.thenAccept { obj: Club? -> p(obj) }
			val club = clubCompletableFuture.get()

			progressUpdate()
			val clubMemberPageCompletableFuture = club.members
			clubMemberPageCompletableFuture.thenAccept { obj: ClubMemberPage? -> p(obj) }
			clubMemberPageCompletableFuture.get()
		}
	}

	@After
	fun finnaly() {
		// Gets any and all errors from code
		val errors: ArrayList<Array<String>> = errorMessages
		for (error in errors) {
			println("""
	
	Error: ${error[0]}
	""".trimIndent())
			println("\tJSON: " + error[1])
			println("\tURL: " + error[2])
		}
		println("\n=== Completed ===\n")
	}
}