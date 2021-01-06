package com.github.doomsdayrs.jikan4java.data.model.main.character

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListName
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.base.endpoint.MyAnimeListPicturesEndPoint
import com.github.doomsdayrs.jikan4java.data.base.endpoint.MyAnimeListSelfType
import com.github.doomsdayrs.jikan4java.data.base.endpoint.direct.MyAnimeListDirectPicturesEndPoint
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.data.model.support.VoiceActors
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*
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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class Character(
	@SerialName("request_hash") override val requestHash: String = "",
	@SerialName("request_cached") override val requestCached: Boolean = false,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int = 0,
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("url") override val url: String,
	@SerialName("name") override val name: String,
	@SerialName("name_kanji") val name_kanji: String = "",
	@SerialName("nicknames") val nicknames: ArrayList<String> = arrayListOf(),
	@SerialName("about") val about: String = "",
	@SerialName("member_favorites") val member_favorites: Int = 0,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("animeography") val animeography: ArrayList<Animeography>,
	@SerialName("mangaography") val mangaography: ArrayList<Mangaography>,
	@SerialName("voice_actors") val voice_actors: ArrayList<VoiceActors>
) : RequestHashing, MyAnimeListID, MyAnimeListURL, MyAnimeListName,
	MyAnimeListImageURL, MyAnimeListPicturesEndPoint {
	override val urlPoint: String by lazy { "character" }

	companion object : MyAnimeListSelfType<Character>,
		MyAnimeListDirectPicturesEndPoint {
		override val urlPoint: String by lazy { "character" }

		override fun getByID(
			retriever: Retriever,
			id: Int
		): CompletableFuture<JikanResult<Character>> =
			retriever("$JIKAN_URL/$urlPoint/$id")
	}
}