package com.github.doomsdayrs.jikan4java.data.enums.top

import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.manga.MangaTop

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
 * 15 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
enum class MangaSubTops(private val type: String) : TopSubType {
	MANGA("manga"), NOVELS("novels"), ONESHOTS("oneshots"), DOUJIN("doujin"), MANHWA("manhwa"), MANHUA("manhua");

	override fun toString(): String = type

	override fun compatible(tops: Top<*>): Boolean = tops is MangaTop
}