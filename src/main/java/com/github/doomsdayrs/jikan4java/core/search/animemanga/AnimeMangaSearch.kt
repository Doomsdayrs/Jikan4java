package com.github.doomsdayrs.jikan4java.core.search.animemanga

import com.github.doomsdayrs.jikan4java.core.search.Search
import com.github.doomsdayrs.jikan4java.data.enums.SortBy
import com.github.doomsdayrs.jikan4java.data.enums.genres.Genres
import com.github.doomsdayrs.jikan4java.data.enums.search.Types
import com.github.doomsdayrs.jikan4java.data.enums.search.animemanga.Ratings
import com.github.doomsdayrs.jikan4java.data.enums.search.animemanga.orderby.OrderBy
import com.github.doomsdayrs.jikan4java.data.enums.search.animemanga.subtype.SubTypes
import com.github.doomsdayrs.jikan4java.data.enums.status.Stati
import java.util.*

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
 * 13 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
open class AnimeMangaSearch<PAGE, SINGLE, SET, STATI, GENRE, ORDER_BY>(
		type: Types
) : Search<PAGE, SINGLE, SET>(type)
		where SET : AnimeMangaSearch<PAGE, SINGLE, SET, STATI, GENRE, ORDER_BY>,
		      STATI : Stati,
		      GENRE : Genres,
		      ORDER_BY : OrderBy {
	/**
	 * Returns page count
	 *
	 * @return page count
	 */
	var page = 0
		protected set
	var subTypes: SubTypes? = null
	var status: Stati? = null
	var startDate: IntArray? = null
	var genres: ArrayList<Int>? = null
	var score = 0f
	var endDate: IntArray? = null
	var rating: Ratings? = null

	/**
	 * Current state of genre
	 *
	 * @return genre inclusion state
	 */
	var isGenreToggle = true
		private set

	private
	var orderBy: OrderBy? = null
	private var sortBy: SortBy? = null

	/**
	 * Creates the URL, but with addons respective of this class
	 *
	 * @return StringBuilder so far
	 */
	override fun createURL(): String {
		val builder = StringBuilder(super.createURL())
		if (page != 0) builder.append("&page=").append(page)
		if (subTypes != null) builder.append("&type=").append(subTypes)
		if (status != null) builder.append("&status=").append(status)
		if (rating != null) builder.append("&rated=").append(rating)
		if (genres != null) {
			builder.append("&genre=")
			for (integer in genres!!) builder.append(integer).append(",")
			builder.replace(builder.lastIndexOf(","), builder.lastIndexOf(",") + 1, "")
			println(builder.toString())
		}
		if (!isGenreToggle) builder.append("&genre_exclude=").append(0)
		if (score != 0f) builder.append("&score=").append(score)
		if (startDate != null) builder.append(String.format("&start_date=%02d-%02d-%02d", startDate!![0], startDate!![1], startDate!![2]))
		if (endDate != null) builder.append(String.format("&end_date=%02d-%02d-%02d", endDate!![0], endDate!![1], endDate!![2]))
		if (orderBy != null) builder.append("&order_by=").append(orderBy)
		if (sortBy != null) builder.append("&sort=").append(sortBy)
		return builder.toString()
	}

	fun removeStartDate() {
		startDate = null
	}

	fun removeEndDate() {
		endDate = null
	}

	/**
	 * Set page to core through
	 *
	 * @param page page number
	 * @return this
	 */
	open fun setPage(page: Int): SET {
		this.page = page
		return this as SET
	}

	open fun setType(subTypes: SubTypes?): SET {
		this.subTypes = subTypes
		return this as SET
	}

	/**
	 * What status should results have?
	 *
	 * @param status Status
	 * @return this
	 */
	fun setStatus(status: STATI?): SET {
		this.status = status
		return this as SET
	}

	/**
	 * What rating should results have?
	 *
	 * @param rating Rating
	 * @return this
	 */
	open fun setRating(rating: Ratings?): SET {
		this.rating = rating
		return this as SET
	}

	/**
	 * Adds genres to queue
	 *
	 * @param genre Genre ID
	 * @return this
	 */
	protected fun addGenre(genre: GENRE): SET {
		if (genres == null) genres = ArrayList()
		genres!!.add(genre.id)
		return this as SET
	}

	/**
	 * Sets score that results will have
	 *
	 * @param score score, IE 5.9
	 * @return this
	 */
	open fun setScore(score: Float): SET {
		this.score = score
		return this as SET
	}

	open fun setStartDate(yyyy: Int, mm: Int, dd: Int): SET {
		startDate = intArrayOf(yyyy, mm, dd)
		return this as SET
	}

	open fun setEndDate(yyyy: Int, mm: Int, dd: Int): SET {
		endDate = intArrayOf(yyyy, mm, dd)
		return this as SET
	}

	/**
	 * Toggles if the genres should be included or excluded. Default is included
	 *
	 * @return this
	 */
	open fun toggleGenres(): SET {
		isGenreToggle = !isGenreToggle
		return this as SET
	}

	/**
	 * Limit of results per page
	 *
	 * @param limit how many results per page
	 * @return this
	 */
	override fun setLimit(limit: Int): SET {
		super.setLimit(limit)
		return this as SET
	}

	fun orderBy(orderBy: ORDER_BY?): SET {
		this.orderBy = orderBy
		return this as SET
	}

	open fun sortBy(sortBy: SortBy?): SET {
		this.sortBy = sortBy
		return this as SET
	}

}

