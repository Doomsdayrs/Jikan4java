package com.github.doomsdayrs.jikan4java.data.model.main.schedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Producer
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
class SubAnime(
		@field:JsonProperty("mal_id") var mal_id: Int = 0,
		@field:JsonProperty("url") var url: String? = null,
		@field:JsonProperty("title") var title: String? = null,
		@field:JsonProperty("image_url") var image_url: String? = null,
		@field:JsonProperty("synopsis") var synopsis: String? = null,
		@field:JsonProperty("type") var type: String? = null,
		@field:JsonProperty("airing_start") var airing_start: String? = null,
		@field:JsonProperty("episodes") var episodes: Int = 0,
		@field:JsonProperty("members") var members: Int = 0,
		@field:JsonProperty("genres") var genres: ArrayList<Genre>? = null,
		@field:JsonProperty("source") var source: String? = null,
		@field:JsonProperty("producers") var producers: ArrayList<Producer>? = null,
		@field:JsonProperty("score") var score: Float = 0f,
		@field:JsonProperty("licensors") var licensors: ArrayList<String>? = null,
		@field:JsonProperty("r18") var r18: Boolean = false,
		@field:JsonProperty("kids") var kids: Boolean = false
) : Retriever() {

	/**
	 * Returns the Anime object of this object
	 *
	 * @return Anime Object
	 */
	val anime: CompletableFuture<Anime> by lazy { retrieve<Anime>("$baseURL/anime/$mal_id") }
}