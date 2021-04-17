package com.github.doomsdayrs.jikan4java.data.model.main.club

import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.model.main.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class ClubMember(
	@SerialName("username") val username: String = "",
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = ""
) : MyAnimeListURL, MyAnimeListImageURL {

	/**
	 * Returns a user object
	 *
	 * @return [User]
	 */
	fun userRetrieve(retriever: Retriever) =
		User.getByName(retriever, username)
}