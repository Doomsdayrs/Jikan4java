package com.github.doomsdayrs.jikan4java.data.model.main.club

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListTitle
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListType
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.BasicMeta
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
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
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class Club(
	@SerialName("request_hash") override val requestHash: String,
	@SerialName("request_cached") override val requestCached: Boolean = false,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int = 0,
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("url") val url: String? = null,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("title") override val title: String,
	@SerialName("members_count") val members_count: Float = 0f,
	@SerialName("pictures_count") val pictures_count: Float = 0f,
	@SerialName("category") val category: String? = null,
	@SerialName("created") val created: String? = null,
	@SerialName("type") override val type: String? = null,
	@SerialName("staff") val staff: List<BasicMeta> = listOf(),
	@SerialName("anime_relations") val anime_relations: List<BasicMeta> = listOf(),
	@SerialName("manga_relations") val manga_relations: List<BasicMeta> = listOf(),
	@SerialName("character_relations") val character_relations: List<BasicMeta> = listOf()
) : RequestHashing, MyAnimeListID, MyAnimeListImageURL, MyAnimeListTitle,
	MyAnimeListType {

	/**
	 * 35 per page
	 * @param page page
	 * @return Members
	 */
	fun getMembers(
		retriever: Retriever,
		page: Int
	): CompletableFuture<JikanResult<ClubMemberPage>> {
		return retriever("$JIKAN_URL/club/$malID/members/$page")
	}

	companion object {
		fun getByID(retriever: Retriever, id: Int) =
			retriever<Club>("$JIKAN_URL/club/$id")
	}
}