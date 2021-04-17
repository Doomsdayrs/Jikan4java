package com.github.doomsdayrs.jikan4java.data.model.main.top.model.anime

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListEpisodeCount
import com.github.doomsdayrs.jikan4java.data.base.type.MyAnimeListAnimeType
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.TopListingMedia
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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class TopAnime(
	@SerialName("mal_id") override val malID: Int,
	@SerialName("rank") override val rank: Int,
	@SerialName("title") override val title: String,
	@SerialName("url") override val url: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("type") override val type: String,
	@SerialName("score") override val score: Double,
	@SerialName("members") override val members: Int,
	@SerialName("start_date") override val startDate: String,
	@SerialName("end_date") override val endDate: String = "",
	@SerialName("episodes") override val episodeCount: Int = 0
) : TopListingMedia(), MyAnimeListEpisodeCount, MyAnimeListAnimeType