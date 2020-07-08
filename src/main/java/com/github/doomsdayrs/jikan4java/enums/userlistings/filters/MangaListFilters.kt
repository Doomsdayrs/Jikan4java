package com.github.doomsdayrs.jikan4java.enums.userlistings.filters

import com.github.doomsdayrs.jikan4java.model.main.user.listing.mangalist.MangaList

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
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
enum class MangaListFilters(private val type: String) : UserListFilters {
	ALL("all"),
	READING("reading"),
	COMPLETED("completed"),
	ONHOLD("onhold"),
	DROPPED("dropped"),
	PLANTOREAD("plantoread"),
	PTR(PLANTOREAD.type);


	override fun toString(): String = type

	override val form: String = "mangalist"

	override fun getaClass(): Class<*> =  MangaList::class.java

}