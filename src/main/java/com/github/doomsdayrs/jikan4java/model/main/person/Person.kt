package com.github.doomsdayrs.jikan4java.model.main.person

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.model.support.pictures.Pictures
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
 * 07 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class Person(
		@field:JsonProperty("request_hash") override val request_hash: String? = null,
		@field:JsonProperty("request_cached") override val request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") override val request_cache_expiry: Int = 0,
		@field:JsonProperty("mal_id") val mal_id: Int = 0,
		@field:JsonProperty("url") val url: String? = null,
		@field:JsonProperty("image_url") val image_url: String? = null,
		@field:JsonProperty("website_url") val website_url: String? = null,
		@field:JsonProperty("name") val name: String? = null,
		@field:JsonProperty("given_name") val given_name: String? = null,
		@field:JsonProperty("family_name") val family_name: String? = null,
		@field:JsonProperty("alternate_names") val alternate_names: ArrayList<String>? = null,
		@field:JsonProperty("birthday") val birthday: String? = null,
		@field:JsonProperty("member_favorites") val member_favorites: Int = 0,
		@field:JsonProperty("about") val about: String? = null,
		@field:JsonProperty("voice_acting_roles") val voiceActingRoles: ArrayList<VoiceActingRoles>? = null,
		@field:JsonProperty("anime_staff_positions") val animeStaffPositions: ArrayList<AnimeStaffPosition>? = null,
		@field:JsonProperty("published_manga") val publishedMangas: ArrayList<PublishedManga>? = null
) : Retriever(),RequestHashing {

	@get:JsonIgnore
	val pictures: CompletableFuture<Pictures> by lazy { retrieve<Pictures>("$baseURL/person/$mal_id/pictures") }
}