package com.github.doomsdayrs.jikan4java.core.userlisting

import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.enums.SortBy
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.filters.UserListFilters
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.orderby.ListOrderBy
import com.github.doomsdayrs.jikan4java.data.enums.userlistings.status.ListingStati
import java.security.InvalidParameterException

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
 * 21 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
open class UserListingSearch<T, LS : ListingStati, out O>(
	var username: String = "",
	val retriever: Retriever
) where O : UserListingSearch<T, LS, O> {

	@Suppress("MemberVisibilityCanBePrivate")
	var from: IntArray? = null

	@Suppress("MemberVisibilityCanBePrivate")
	var listingStati: LS? = null

	@Suppress("MemberVisibilityCanBePrivate")
	var orderBy: ListOrderBy? = null

	@Suppress("MemberVisibilityCanBePrivate")
	var orderBy2: ListOrderBy? = null

	@Suppress("MemberVisibilityCanBePrivate")
	var page = 0

	@Suppress("MemberVisibilityCanBePrivate")
	var query: String? = null

	@Suppress("MemberVisibilityCanBePrivate")
	var sortBy: SortBy? = null

	@Suppress("MemberVisibilityCanBePrivate")
	var to: IntArray? = null

	@Suppress("MemberVisibilityCanBePrivate")
	var userListFilters: UserListFilters? = null

	@Throws(InvalidParameterException::class)
	protected open fun createURL(): StringBuilder {
		val options = StringBuilder()
		if (userListFilters != null)
			options.append("/").append(userListFilters!!.form).append("/")
				.append(userListFilters)
		else throw InvalidParameterException("Expected userListingFilters")
		if (page != 0) options.append("/").append(page)
		if (query != null) options.append("?q=").append(query)
		var ordering = false
		if (orderBy != null) {
			options.append("&order_by").append(orderBy)
			ordering = true
		}
		if (orderBy2 != null) {
			options.append("&order_by2").append(orderBy2)
			ordering = true
		}
		if (ordering) if (sortBy != null) options.append("&sort=")
			.append(sortBy)
		return options
	}

	fun setFrom(yyyy: Int, mm: Int, dd: Int): O {
		from = intArrayOf(yyyy, mm, dd)
		return this as O
	}

	fun setFrom(from: IntArray): O {
		this.from = from
		return this as O
	}

	fun setListingStati(listingStati: LS): O {
		this.listingStati = listingStati
		return this as O
	}

	fun setOrderBy(orderBy: ListOrderBy): O {
		this.orderBy = orderBy
		return this as O
	}

	fun setOrderBy2(orderBy2: ListOrderBy): O {
		this.orderBy2 = orderBy2
		return this as O
	}

	fun setPage(page: Int): O {
		this.page = page
		return this as O
	}

	fun setQuery(query: String): O {
		this.query = query
		return this as O
	}

	fun setSortBy(sortBy: SortBy): O {
		this.sortBy = sortBy
		return this as O
	}

	fun setTo(yyyy: Int, mm: Int, dd: Int): O {
		to = intArrayOf(yyyy, mm, dd)
		return this as O
	}

	fun setTo(to: IntArray): O {
		this.to = to
		return this as O
	}

	/**
	 * @param userListFilters The type of list you wish, and what filtering. Default with all
	 * @return this
	 */
	fun setUserListFilters(userListFilters: UserListFilters): O {
		this.userListFilters = userListFilters
		return this as O
	}

	fun setUsername(username: String): O {
		this.username = username
		return this as O
	}
}