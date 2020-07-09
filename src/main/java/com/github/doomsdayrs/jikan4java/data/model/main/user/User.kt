package com.github.doomsdayrs.jikan4java.data.model.main.user

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.core.userlisting.AnimeUserListingSearch
import com.github.doomsdayrs.jikan4java.core.userlisting.MangaUserListingSearch
import com.github.doomsdayrs.jikan4java.data.enums.HistoryTypes
import com.github.doomsdayrs.jikan4java.data.model.main.user.friends.Friends
import com.github.doomsdayrs.jikan4java.data.model.main.user.history.HistoryPage
import java.util.*
import java.util.concurrent.CompletableFuture
import kotlin.collections.HashMap

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
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class User(
		@field:JsonProperty("request_hash") var request_hash: String? = null,
		@field:JsonProperty("request_cached") var request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") var request_cache_expiry: Int = 0,
		@field:JsonProperty("user_id") var user_id: Int = 0,
		@field:JsonProperty("username") var username: String? = null,
		@field:JsonProperty("url") var url: String? = null,
		@field:JsonProperty("image_url") var image_url: String? = null,
		@field:JsonProperty("last_online") var last_online: String? = null,
		@field:JsonProperty("gender") var gender: String? = null,
		@field:JsonProperty("birthday") var birthday: String? = null,
		@field:JsonProperty("location") var location: String? = null,
		@field:JsonProperty("joined") var joined: String? = null,
		@field:JsonProperty("anime_stats") var animeStats: ArrayList<AnimeStats>? = null,
		@field:JsonProperty("manga_stats") var mangaStats: ArrayList<MangaStats>? = null,
		@field:JsonProperty("favorites") var favorites: Favorites? = null,
		@field:JsonProperty("about") var about: String? = null
) : Retriever() {
	val historyHash = HashMap<HistoryTypes, CompletableFuture<HistoryPage>>()
	val friendsHash = HashMap<Int, CompletableFuture<Friends>>()
	val animeListSearch: AnimeUserListingSearch by lazy { AnimeUserListingSearch(username) }
	val mangaListSearch: MangaUserListingSearch by lazy { MangaUserListingSearch(username) }

	/**
	 * Returns history of the person
	 *
	 * @param type Anime or Manga
	 * @return History object
	 */
	fun getHistory(type: HistoryTypes): CompletableFuture<HistoryPage> =
			historyHash.takeIf { it.containsKey(type) }?.get(type)
					?: historyHash.also {
						historyHash[type] = retrieve("$baseURL/user/$username/history$type")
					}[type]!!

	/**
	 * Returns friends of the person
	 *
	 * @param page Page to call for
	 * @return Friends object
	 */
	fun getFriends(page: Int): CompletableFuture<Friends> =
			friendsHash.takeIf { it.containsKey(page) }?.get(page)
					?: friendsHash.also {
						friendsHash[page] = retrieve("$baseURL/user/$username/friends/$page")
					}[page]!!
}