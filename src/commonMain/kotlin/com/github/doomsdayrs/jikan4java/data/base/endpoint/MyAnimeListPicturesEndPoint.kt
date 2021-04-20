package com.github.doomsdayrs.jikan4java.data.base.endpoint

import com.github.doomsdayrs.jikan4java.data.base.endpoint.direct.MyAnimeListDirectPicturesEndPoint
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures


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
 */

/**
 * jikan4java
 * 05 / 01 / 2021
 *
 * @author github.com/doomsdayrs
 */
interface MyAnimeListPicturesEndPoint : MyAnimeListID, MyAnimeListEntityPoint,
	MyAnimeListDirectPicturesEndPoint {

	/**
	 * Gets pictures related to this
	 *
	 * @return [JikanResult] of [Pictures]
	 */
	val picturesUrl
		get() = getPicturesUrl(malID)
}

