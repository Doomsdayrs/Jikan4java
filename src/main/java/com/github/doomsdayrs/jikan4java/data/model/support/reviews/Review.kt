package com.github.doomsdayrs.jikan4java.data.model.support.reviews

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListType
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL

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
 * ====================================================================*/
/**
 * Jikan4java
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
interface Review : MyAnimeListID, MyAnimeListURL, MyAnimeListType {

	val helpfulCount: Int

	@Deprecated("Changed to proper naming format", ReplaceWith("helpful_count"))
	@Suppress("PropertyName")
	val helpful_count: Int
		get() = helpfulCount


	val date: String?
	val reviewer: Reviewer
	val content: String?
}