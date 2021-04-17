package com.github.doomsdayrs.jikan4java.core.userlisting

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.filters.MangaListFilters
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.status.MangaListingStati
import com.github.doomsdayrs.jikan4java.data.model.main.user.listing.mangalist.MangaList
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
	retriever: Retriever
) : UserListingSearch<MangaList, MangaListingStati, MangaUserListingSearch>(
	username = username,
	retriever = retriever,
) {

	private var magazine = 0
	val list: CompletableFuture<JikanResult<MangaList>>
		@Throws(InvalidParameterException::class)
		get() = retriever("$JIKAN_URL/user/$username${createURL()}")

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