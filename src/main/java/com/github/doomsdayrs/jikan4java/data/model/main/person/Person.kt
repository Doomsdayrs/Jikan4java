package com.github.doomsdayrs.jikan4java.data.model.main.person

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.endpoint.MyAnimeListPicturesEndPoint
import com.github.doomsdayrs.jikan4java.data.base.endpoint.MyAnimeListSelfType
import com.github.doomsdayrs.jikan4java.data.base.endpoint.direct.MyAnimeListDirectPicturesEndPoint
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
 * 07 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class Person(
	@SerialName("request_hash") override val requestHash: String,
	@SerialName("request_cached") override val requestCached: Boolean = false,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int = 0,
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("website_url") val website_url: String = "",
	@SerialName("name") val name: String,
	@SerialName("given_name") val given_name: String = "",
	@SerialName("family_name") val family_name: String = "",
	@SerialName("alternate_names") val alternate_names: List<String>,
	@SerialName("birthday") val birthday: String = "",
	@SerialName("member_favorites") val member_favorites: Int = 0,
	@SerialName("about") val about: String = "",
	@SerialName("voice_acting_roles") val voiceActingRoles: List<VoiceActingRoles>,
	@SerialName("anime_staff_positions") val animeStaffPositions: List<AnimeStaffPosition>,
	@SerialName("published_manga") val publishedMangas: List<PublishedManga>
) : RequestHashing, MyAnimeListID, MyAnimeListURL, MyAnimeListImageURL,
	MyAnimeListPicturesEndPoint {
	override val urlPoint: String
		get() = "person"

	companion object : MyAnimeListSelfType<Person>,
		MyAnimeListDirectPicturesEndPoint {
		override fun getByID(retriever: Retriever, id: Int) =
			retriever<Person>("$JIKAN_URL/person/$id")

		override val urlPoint: String by lazy { "person" }
	}
}