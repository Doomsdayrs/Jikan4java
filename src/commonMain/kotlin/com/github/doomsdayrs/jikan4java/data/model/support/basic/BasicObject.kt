package com.github.doomsdayrs.jikan4java.data.model.support.basic

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListName
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
 */ /**
 * com.github.doomsdayrs.jikan4java.types.support.basic
 * 17 / November / 2019
 *
 * @author github.com/doomsdayrs
 */
interface BasicObject : MyAnimeListID, MyAnimeListImageURL, MyAnimeListName,
	MyAnimeListURL {

	@Deprecated("Changed to proper naming format", ReplaceWith("malID"))
	@Suppress("PropertyName")
	val mal_id
		get() = malID

	@Deprecated("Changed to proper naming format", ReplaceWith("imageURL"))
	@Suppress("PropertyName")
	val image_url
		get() = imageURL
}