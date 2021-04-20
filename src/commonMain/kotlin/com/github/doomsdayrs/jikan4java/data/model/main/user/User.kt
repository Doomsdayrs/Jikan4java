package com.github.doomsdayrs.jikan4java.data.model.main.user

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.userlisting.AnimeUserListingSearch
import com.github.doomsdayrs.jikan4java.core.userlisting.MangaUserListingSearch
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.enums.HistoryTypes
import com.github.doomsdayrs.jikan4java.data.model.main.user.history.HistoryPage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmStatic

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
 */
/**
 * Jikan4java
 * 02 / November / 2018
 *
 * @author github.com/doomsdayrs
 * @param about HTML section that the user wrote about themselves
 */
@Serializable
data class User(
	@SerialName("request_hash") val request_hash: String?,
	@SerialName("request_cached") val request_cached: Boolean = false,
	@SerialName("request_cache_expiry") val request_cache_expiry: Int = 0,
	@SerialName("user_id") val user_id: Int = 0,
	@SerialName("username") val username: String = "",
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("last_online") val last_online: String = "",
	@SerialName("gender") val gender: String = "",
	@SerialName("birthday") val birthday: String = "",
	@SerialName("location") val location: String = "",
	@SerialName("joined") val joined: String = "",
	@SerialName("anime_stats") val animeStats: AnimeStats,
	@SerialName("manga_stats") val mangaStats: MangaStats,
	@SerialName("favorites") val favorites: Favorites?,
	@SerialName("about") var about: String = ""
) : MyAnimeListURL, MyAnimeListImageURL {


	fun getAnimeListSearch() = AnimeUserListingSearch(username,)

	fun getMangaListSearch() = MangaUserListingSearch(username,)

	/**
	 * Returns history of the person
	 *
	 * @param type Anime or Manga
	 * @return [HistoryPage]
	 */
	fun getHistory(
		type: HistoryTypes
	) = "$JIKAN_URL/user/$username/history/$type"


	/**
	 * Returns friends of the person
	 *
	 * @param page Page to call for
	 * @return Friends object
	 */
	fun getFriends(
		page: Int
	) = "$JIKAN_URL/user/$username/friends/$page"

	companion object {
		@JvmStatic
		fun getUrlByName(name: String) = "$JIKAN_URL/user/$name"
	}
}