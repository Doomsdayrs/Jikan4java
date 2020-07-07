package com.github.doomsdayrs.jikan4java.model.main.season

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.model.support.basic.meta.Producer
import java.util.*
import java.util.concurrent.CompletableFuture

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
data class SeasonSearchAnime(
		@field:JsonProperty("mal_id") val mal_id: Int = 0,
		@field:JsonProperty("url") val url: String? = null,
		@field:JsonProperty("title") val title: String? = null,
		@field:JsonProperty("image_url") val image_url: String? = null,
		@field:JsonProperty("synopsis") val synopsis: String? = null,
		@field:JsonProperty("type") val type: String? = null,
		@field:JsonProperty("airing_start") val airing_start: String? = null,
		@field:JsonProperty("episodes") val episodes: Int = 0,
		@field:JsonProperty("members") val members: Int = 0,
		@field:JsonProperty("genres") val genres: ArrayList<Genre>? = null,
		@field:JsonProperty("source") val source: String? = null,
		@field:JsonProperty("producers") val producers: ArrayList<Producer>? = null,
		@field:JsonProperty("score") val score: Float = 0f,
		@field:JsonProperty("licensors") val licensors: ArrayList<String>? = null,
		@field:JsonProperty("r18") val r18: Boolean = false,
		@field:JsonProperty("kids") val kids: Boolean = false,
		@field:JsonProperty("continuing") val continuing: Boolean = false
) : Retriever() {

	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	val anime: CompletableFuture<Anime> by lazy { retrieve<Anime>("$baseURL/anime/$mal_id") }
}