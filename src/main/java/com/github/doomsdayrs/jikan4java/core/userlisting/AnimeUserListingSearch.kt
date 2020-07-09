package com.github.doomsdayrs.jikan4java.core.userlisting

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.doomsdayrs.jikan4java.data.enums.Season
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.filters.AnimeListFilters
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.status.AnimeListingStati
import com.github.doomsdayrs.jikan4java.data.model.main.user.listing.animelist.AnimeList
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
class AnimeUserListingSearch(
		username: String = "",
		client: OkHttpClient = OkHttpClient(),
		objectMapper: ObjectMapper = ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true),
		jsonParser: JSONParser = JSONParser(),
		builder: Request.Builder = Request.Builder()
) : UserListingSearch<AnimeList, AnimeListingStati, AnimeUserListingSearch>(
		username,
		client,
		objectMapper,
		jsonParser,
		builder
) {

	private var producer = 0
	private var year = 0
	private var season: Season? = null
	val list: CompletableFuture<AnimeList>
		@Throws(InvalidParameterException::class)
		get() = retrieve("$baseURL/user/$username${createURL()}")

	init {
		setUserListFilters(AnimeListFilters.ALL)
	}

	fun setProducer(producer: Int): AnimeUserListingSearch {
		this.producer = producer
		return this
	}

	fun setYear(year: Int): AnimeUserListingSearch {
		this.year = year
		return this
	}

	fun setSeason(season: Season?): AnimeUserListingSearch {
		this.season = season
		return this
	}

	@Throws(InvalidParameterException::class)
	override fun createURL(): StringBuilder {
		val stringBuilder = super.createURL()
		if (producer != 0) stringBuilder.append("&producer=").append(producer)
		if (year != 0) stringBuilder.append("&year=").append(year)
		if (season != null) stringBuilder.append("&season=").append(season)
		return stringBuilder
	}
}