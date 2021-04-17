package com.github.doomsdayrs.jikan4java.data.model.support.reviews.manga

import com.github.doomsdayrs.jikan4java.data.model.support.reviews.Review
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
 * ====================================================================*/
/**
 * Jikan4java
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class MangaReview(
	@SerialName("mal_id") override val malID: Int,
	@SerialName("url") override val url: String,
	@SerialName("helpful_count") override val helpfulCount: Int,
	@SerialName("date") override val date: String?,
	@SerialName("reviewer") override val reviewer: MangaReviewer,
	@SerialName("content") override val content: String?,
	@SerialName("type") override val type: String?
) : Review