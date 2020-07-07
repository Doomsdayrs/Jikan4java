package com.github.doomsdayrs.jikan4java.model.main.club

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.model.support.basic.meta.BasicMeta
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
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
class Club(
		@field:JsonProperty("request_hash") override val request_hash: String? = null,
		@field:JsonProperty("request_cached") override val request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") override val request_cache_expiry: Int = 0,
		@field:JsonProperty("mal_id") val mal_id: Int = 0,
		@field:JsonProperty("url") val url: String? = null,
		@field:JsonProperty("image_url") val image_url: String? = null,
		@field:JsonProperty("title") val title: String? = null,
		@field:JsonProperty("members_count") val members_count: Float = 0f,
		@field:JsonProperty("pictures_count") val pictures_count: Float = 0f,
		@field:JsonProperty("category") val category: String? = null,
		@field:JsonProperty("created") val created: String? = null,
		@field:JsonProperty("type") val type: String? = null,
		@field:JsonProperty("staff") val staff: ArrayList<BasicMeta>? = null,
		@field:JsonProperty("anime_relations") val anime_relations: ArrayList<BasicMeta>? = null,
		@field:JsonProperty("manga_relations") val manga_relations: ArrayList<BasicMeta>? = null,
		@field:JsonProperty("character_relations") val character_relations: ArrayList<BasicMeta>? = null
) : Retriever(), RequestHashing {

	/**
	 * 35 per page
	 * @param page page
	 * @return Members
	 */
	fun getMembers(page: Int): CompletableFuture<ClubMemberPage> {
		return retrieve("$baseURL/club/$mal_id/members/$page")
	}

	/**
	 * Returns first page, 35 count
	 * @return Members
	 */
	val members: CompletableFuture<ClubMemberPage>
		get() = getMembers(1)
}