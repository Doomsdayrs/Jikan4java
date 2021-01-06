package com.github.doomsdayrs.jikan4java.data.model.main.season

import com.github.doomsdayrs.jikan4java.data.base.type.MyAnimeListAnimeType
import com.github.doomsdayrs.jikan4java.data.base.values.*
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Producer
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
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class SeasonSearchAnime(
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("url") val url: String = "",
	@SerialName("title") override val title: String,
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("synopsis") val synopsis: String = "",
	@SerialName("type") override val type: String = "",
	@SerialName("airing_start") val airing_start: String = "",
	@SerialName("episodes") override val episodeCount: Int = 0,
	@SerialName("members") val members: Int = 0,
	@SerialName("genres") override val genres: List<Genre>,
	@SerialName("source") override val source: String = "",
	@SerialName("producers") val producers: List<Producer>,
	@SerialName("score") override val score: Double,
	@SerialName("licensors") val licensors: List<String>,
	@SerialName("r18") val r18: Boolean = false,
	@SerialName("kids") val kids: Boolean = false,
	@SerialName("continuing") val continuing: Boolean = false
) :
	MyAnimeListID,
	MyAnimeListTitle,
	MyAnimeListImageURL,
	MyAnimeListType,
	MyAnimeListSource, MyAnimeListEpisodeCount, MyAnimeListScore,
	MyAnimeListGenres, MyAnimeListAnimeType