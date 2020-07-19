package com.github.doomsdayrs.jikan4java.core.userlisting

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.filters.MangaListFilters
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.status.MangaListingStati
import com.github.doomsdayrs.jikan4java.data.model.main.user.listing.mangalist.MangaList
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.simple.parser.JSONParser
import java.security.InvalidParameterException
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
 * 25 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
class MangaUserListingSearch(
		username: String = "",
		client: OkHttpClient = OkHttpClient(),
		objectMapper: ObjectMapper = ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true),
		jsonParser: JSONParser = JSONParser(),
		builder: Request.Builder = Request.Builder()
) : UserListingSearch<MangaList, MangaListingStati, MangaUserListingSearch>(
		username = username,
		client = client,
		objectMapper = objectMapper,
		jsonParser = jsonParser,
		builder = builder
) {

	private var magazine = 0
	val list: CompletableFuture<MangaList>
		@Throws(InvalidParameterException::class)
		get() = retrieve("$jikanURL/user/$username${createURL()}")

	init {
		setUserListFilters(MangaListFilters.ALL)
	}

	fun setMagazine(magazine: Int): MangaUserListingSearch {
		this.magazine = magazine
		return this
	}

	@Throws(InvalidParameterException::class)
	override fun createURL(): StringBuilder {
		val stringBuilder = super.createURL()
		if (magazine != 0) stringBuilder.append("&magazine=").append(magazine)
		return stringBuilder
	}
}