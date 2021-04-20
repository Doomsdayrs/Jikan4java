package com.github.doomsdayrs.jikan4java

import com.github.doomsdayrs.jikan4java.data.enums.TopType

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
/**
 * Jikan4java
 * 47 / 44 / 2049
 *
 * @author github.com/doomsdayrs
 */
internal object KotlinTester {
	private val animes = arrayOf(
		"Boku no Hero Academia 4th Season",
		"Steins;Gate",
		"Fullmetal Alchemist: Brotherhood",
		"Kimetsu no Yaiba"
	)
	private val mangaTitles =
		arrayOf("Berserk", "Boku no" /*,"One punch", "Shield"*/)
	private val tops =
		arrayOf(TopType.ANIME, TopType.MANGA, TopType.CHARACTER)

	private const val CONNECTOR_SIZE = 8
	private const val GENRES_SIZE = 2
	private const val USER_SIZE = 5
	private const val CLUB_SIZE = 2
	private val exceptions = ArrayList<Pair<Int, Exception>>()

	@Suppress("SpellCheckingInspection")
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
	private var max =
		1 + animes.size * 12 + mangaTitles.size * 5 + tops.size + CONNECTOR_SIZE + 10 + GENRES_SIZE + USER_SIZE + CLUB_SIZE

	private var currentProgress = 0

	private fun progressUpdate() {
		currentProgress++
		print("\u001b[H\u001b[2J")
		val stringBuilder = StringBuilder("[")
		for (x in 0 until currentProgress) stringBuilder.append("=")
		for (x in currentProgress until max) stringBuilder.append("-")
		stringBuilder.append("]").append(" ").append(currentProgress)
			.append("/").append(max)
		println("Progress: $stringBuilder")
	}

	/*
	/**
	 * Tester method
	 *
	 * @param args No args = run's all tests, Default all types enabled, -(type)=0 disables said type
	 * @throws ExecutionException        ignored
	 * @throws InterruptedException      ignored
	 * @throws IncompatibleEnumException ignored
	 */
	@Throws(
		IncompatibleEnumException::class
	)
	@JvmStatic
	fun main(args: Array<String>) {
		val job = GlobalScope.launch {
			setupTest()
			progressUpdate()
			//testAnime()
			//testManga()
			//testSearch()
			testGeneralConnector()
			testProducer()
			//testSchedule()
			//testGenre()
			//testUser()
			//testClub()
			finally()
		}

		var i = 0
		while (job.isActive) {
			i++
		}
	}

	private suspend fun testProducer() {
		ProducerPage.search(retriever, 1).awaitAndPrint()

	}

	fun setupTest() {
		debugMode = true
	}

	suspend fun testAnime() {
		if (types[0]) {
			var animeSearch: AnimeSearch
			for (animeTitle in animes) {
				animeSearch = AnimeSearch(retriever)
				animeSearch.setQuery(animeTitle)
				progressUpdate()
				println("\nSearching for ANIME\n")
				val animeCompletableFuture = animeSearch.getFirst<Anime>()
				animeCompletableFuture.thenAccept { obj -> p(obj) }
				animeCompletableFuture.await().handle { anime ->
					progressUpdate()
					println("\nCharacter_Staff\n")
					val characterStaffCompletableFuture =
						anime.getCharacterStaffs(
							retriever
						)
					characterStaffCompletableFuture.thenAccept { obj ->
						p(
							obj
						)
					}
					characterStaffCompletableFuture.await()

					progressUpdate()
					println("\nEpisodes\n")
					val episodesCompletableFuture =
						anime.getEpisodesPage(retriever, 1)
					episodesCompletableFuture.thenAccept { obj ->
						p(
							obj
						)
					}
					episodesCompletableFuture.await()

					println("\nNews\n")
					val newsCompletableFuture = anime.getNews(retriever)
					newsCompletableFuture.thenAccept { obj -> p(obj) }
					newsCompletableFuture.await()

					progressUpdate()
					println("\nPictures\n")
					val picturesCompletableFuture = anime.getPictures(retriever)
					picturesCompletableFuture.thenAccept { obj -> p(obj) }
					picturesCompletableFuture.await()

					progressUpdate()
					println("\nVideos\n")
					val videoCompletableFuture = anime.getVideos(retriever)
					videoCompletableFuture.thenAccept { obj -> p(obj) }
					videoCompletableFuture.await()

					progressUpdate()
					println("\nStats\n")
					val statsCompletableFuture = anime.getStats(retriever)
					statsCompletableFuture.thenAccept { obj -> p(obj) }
					statsCompletableFuture.await()

					progressUpdate()
					println("\nForum\n")
					val forumCompletableFuture = anime.getForum(retriever)
					forumCompletableFuture.thenAccept { obj -> p(obj) }
					forumCompletableFuture.await()

					progressUpdate()
					println("\nMoreInfo\n")
					val moreInfoCompletableFuture = anime.getMoreInfo(retriever)
					moreInfoCompletableFuture.thenAccept { obj -> p(obj) }
					moreInfoCompletableFuture.await()

					progressUpdate()
					println("\nReviewPage\n")
					val reviewCompletableFuture = anime.getReviewPage(retriever)
					reviewCompletableFuture.thenAccept { obj ->
						p(
							obj
						)
					}
					reviewCompletableFuture.await()

					progressUpdate()
					println("\nRecommendationPage\n")
					val recommendCompletableFuture =
						anime.getRecommendationPage(
							retriever
						)
					recommendCompletableFuture.thenAccept { obj ->
						p(
							obj
						)
					}
					recommendCompletableFuture.await()

					progressUpdate()
					println("\nUserUpdates\n")
					val animeUserUpdateCompletableFuture =
						anime.getUserUpdatesPage(
							retriever, 1
						)
					animeUserUpdateCompletableFuture.thenAccept { obj ->
						p(
							obj
						)
					}
					animeUserUpdateCompletableFuture.await()

				}


			}
		}
	}

	suspend fun testManga() {
		if (types[1]) {
			var mangaSearch: MangaSearch
			for (mangaTitle in mangaTitles) {
				mangaSearch = MangaSearch(retriever)
				mangaSearch.setQuery(mangaTitle)
				progressUpdate()
				println("Searching Manga: $mangaTitle")
				val mangaCompletableFuture = mangaSearch.getFirst<Manga>()
				mangaCompletableFuture.thenAccept { obj -> p(obj) }
				mangaCompletableFuture.await().handle { manga ->
					progressUpdate()
					val characterCompletableFuture =
						manga.getCharacters(retriever)
					characterCompletableFuture.thenAccept { obj ->
						p(
							obj
						)
					}
					characterCompletableFuture.await()

					progressUpdate()
					val newsCompletableFuture = manga.getNews(retriever)
					newsCompletableFuture.thenAccept { obj -> p(obj) }
					newsCompletableFuture.await()

					progressUpdate()
					val picturesCompletableFuture = manga.getPictures(retriever)
					picturesCompletableFuture.thenAccept { obj -> p(obj) }
					picturesCompletableFuture.await()

					progressUpdate()
					val statsCompletableFuture = manga.getStats(retriever)
					statsCompletableFuture.thenAccept { obj ->
						p(
							obj
						)
					}
					statsCompletableFuture.await()
				}

			}
		}
	}

	suspend fun testSearch() {
		if (types[2]) {
			var topSearch: TopSearch
			run {
				topSearch = TopSearch(retriever)
				progressUpdate()
				topSearch.searchTop(TopSearch.ANIME).awaitAndPrint()
			}
			run {
				topSearch = TopSearch(retriever)
				progressUpdate()
				topSearch.searchTop(TopSearch.MANGA).awaitAndPrint()
			}
			run {
				topSearch = TopSearch(retriever)
				progressUpdate()
				topSearch.searchTop(TopSearch.CHARACTER).awaitAndPrint()
			}
			run {
				topSearch = TopSearch(retriever)
				progressUpdate()
				topSearch.searchTop(TopSearch.PERSON).awaitAndPrint()

				topSearch.searchTop(TopSearch.ANIME)
			}

			topSearch.searchTop(TopType.ANIME, subtype = AnimeSubTops.AIRING)

		}
	}

	suspend fun testGeneralConnector() {
		val connector = Connector(retriever)
		if (types[3]) {
			progressUpdate()
			Person.getUrlById(1).awaitAndPrint()
				.handle { person ->
					progressUpdate()
					var picturesCompletableFuture: CompletableFuture<JikanResult<Pictures>> =
						person.getPictures(retriever)
					picturesCompletableFuture.thenAccept { obj -> p(obj) }
					picturesCompletableFuture.await()

					progressUpdate()
					val characterCompletableFuture =
						Character.getUrlById(1)
					characterCompletableFuture.thenAccept { obj -> p(obj) }
					characterCompletableFuture.await().handle { character ->
						progressUpdate()
						picturesCompletableFuture =
							character.getPictures(retriever)
						picturesCompletableFuture.thenAccept { obj -> p(obj) }
						picturesCompletableFuture.await()
					}
				}



			progressUpdate()
			val seasonArchiveCompletableFuture = connector.seasonArchive()
			seasonArchiveCompletableFuture.thenAccept { obj ->
				p(
					obj
				)
			}
			seasonArchiveCompletableFuture.await()

			progressUpdate()
			val seasonSearchCompletableFuture = connector.seasonLater()
			seasonSearchCompletableFuture.thenAccept { obj ->
				p(
					obj
				)
			}
			seasonSearchCompletableFuture.await()

			progressUpdate()
			val producerPageCompletableFuture =
				ProducerPage.search(connector.retriever, 1, 1)
			producerPageCompletableFuture.thenAccept { obj ->
				p(
					obj
				)
			}
			producerPageCompletableFuture.await()

			progressUpdate()
			val magazinePageCompletableFuture = connector.magazineSearch(1, 1)
			magazinePageCompletableFuture.thenAccept { obj ->
				p(
					obj
				)
			}
			magazinePageCompletableFuture.await()

		}
	}


	suspend fun testSchedule() {
		if (types[4]) {
			progressUpdate()
			SchedulePage.getSchedule(retriever).awaitAndPrint()

			arrayOf(
				SchedulePage.Companion::getSundaySchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getMondaySchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getTuesdaySchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getWednesdaySchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getThursdaySchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getFridaySchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getSaturdaySchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getOtherSchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
				SchedulePage.Companion::getUnknownSchedule as KFunction1<Retriever, CompletableFuture<JikanResult<Day>>>,
			).forEach {
				progressUpdate()
				it.invoke(retriever).awaitAndPrint()
			}
		}
	}

	suspend fun testGenre() {
		Connector(retriever)
		if (types[5]) {
			progressUpdate()
			val animePageCompletableFuture =
				AnimeGenres.ACTION.getSearchUrl(1)
			animePageCompletableFuture.thenAccept { obj ->
				p(
					obj
				)
			}
			animePageCompletableFuture.await()

			progressUpdate()
			val mangaPageCompletableFuture =
				MangaGenres.ACTION.getSearchUrl(1)
			mangaPageCompletableFuture.thenAccept { obj ->
				p(
					obj
				)
			}
			mangaPageCompletableFuture.await()

		}
	}

	suspend fun testUser() {
		val connector = Connector(retriever)
		if (types[6]) {
			progressUpdate()
			val userCompletableFuture =
				User.getByName(connector.retriever, USER_NAME)
			userCompletableFuture.thenAccept { obj -> p(obj) }
			userCompletableFuture.await().handle { user ->
				progressUpdate()
				val animeListCompletableFuture =
					user.getAnimeListSearch(retriever).list
				animeListCompletableFuture.thenAccept { obj -> p(obj) }
				animeListCompletableFuture.await()

				progressUpdate()
				val mangaListCompletableFuture =
					user.getMangaListSearch(retriever).list
				mangaListCompletableFuture.thenAccept { obj -> p(obj) }
				mangaListCompletableFuture.await()

				progressUpdate()
				val friendsCompletableFuture = user.getFriends(retriever, 1)
				friendsCompletableFuture.thenAccept { obj -> p(obj) }
				friendsCompletableFuture.await()

				progressUpdate()
				val animeHistoryPageCompletableFuture =
					user.getHistory(retriever, HistoryTypes.ANIME)
				animeHistoryPageCompletableFuture.thenAccept { obj ->
					p(
						obj
					)
				}
				animeHistoryPageCompletableFuture.await()

				progressUpdate()
				val mangaHistoryPageCompletableFuture =
					user.getHistory(retriever, HistoryTypes.MANGA)
				mangaHistoryPageCompletableFuture.thenAccept { obj ->
					p(
						obj
					)
				}
				mangaHistoryPageCompletableFuture.await()
			}
		}
	}

	suspend fun testClub() {
		if (types[7]) {
			progressUpdate()
			val clubCompletableFuture = Club.getUrlById(1)
			clubCompletableFuture.thenAccept { obj -> p(obj) }
			clubCompletableFuture.await().handle { club ->
				progressUpdate()
				val clubMemberPageCompletableFuture =
					club.getMembers(retriever, 1)
				clubMemberPageCompletableFuture.thenAccept { obj ->
					p(
						obj
					)
				}
				clubMemberPageCompletableFuture.await()
			}
		}
	}

	*/
	fun finally() {
		// Gets any and all errors from code
		exceptions.forEach { (line, exception) ->
			println("\nException at line $line\n")
			exception.printStackTrace()
		}
		println("\n=== Completed ===\n")
	}
}