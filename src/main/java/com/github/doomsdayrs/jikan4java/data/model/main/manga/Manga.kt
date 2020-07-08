package com.github.doomsdayrs.jikan4java.data.model.main.manga

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.model.main.manga.published.Published
import com.github.doomsdayrs.jikan4java.data.model.support.MoreInfo
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Authors
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.data.model.support.forum.Forum
import com.github.doomsdayrs.jikan4java.data.model.support.news.News
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures
import com.github.doomsdayrs.jikan4java.data.model.support.recommendations.RecommendationPage
import com.github.doomsdayrs.jikan4java.data.model.support.related.Related
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.manga.MangaReviewPage
import com.github.doomsdayrs.jikan4java.data.model.support.stats.MangaStats
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.manga.MangaUserUpdatesPage
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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
data class Manga(
		@field:JsonProperty("request_hash") var request_hash: String? = null,
		@field:JsonProperty("request_cached") var request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") var request_cache_expiry: Int = 0,
		@field:JsonProperty("mal_id") var mal_id: Int = 0,
		@field:JsonProperty("url") var url: String? = null,
		@field:JsonProperty("title") var title: String? = null,
		@field:JsonProperty("title_english") var title_english: String? = null,
		@field:JsonProperty("title_synonyms") var title_synonyms: ArrayList<String>? = null,
		@field:JsonProperty("title_japanese") var title_japanese: String? = null,
		@field:JsonProperty("status") var status: String? = null,
		@field:JsonProperty("image_url") var image_url: String? = null,
		@field:JsonProperty("type") var type: String? = null,
		@field:JsonProperty("volumes") var volumes: Int = 0,
		@field:JsonProperty("chapters") var chapters: Int = 0,
		@field:JsonProperty("publishing") var publishing: Boolean = false,
		@field:JsonProperty("published") var published: Published? = null,
		@field:JsonProperty("rank") var rank: Int = 0,
		@field:JsonProperty("score") var score: Double = 0.0,
		@field:JsonProperty("scored_by") var scored_by: Int = 0,
		@field:JsonProperty("popularity") var popularity: Int = 0,
		@field:JsonProperty("members") var members: Int = 0,
		@field:JsonProperty("favorites") var favorites: Int = 0,
		@field:JsonProperty("synopsis") var synopsis: String? = null,
		@field:JsonProperty("background") var background: String? = null,
		@field:JsonProperty("related") var related: ArrayList<Related>? = null,
		@field:JsonProperty("genres") var genres: ArrayList<Genre>? = null,
		@field:JsonProperty("authors") var authors: ArrayList<Authors>? = null,
		@field:JsonProperty("serializations") var serializations: ArrayList<Serializations>? = null
) : Retriever() {

	/**
	 * Returns MangaCharacters object
	 *
	 * @return MangaCharacters
	 */
	@get:JsonProperty
	val characters: CompletableFuture<MangaCharacters> by lazy { retrieve<MangaCharacters>("$baseURL/manga/$mal_id/characters") }

	/**
	 * Gets news about Manga
	 *
	 * @return News object
	 */
	@get:JsonProperty
	val news: CompletableFuture<News> by lazy { retrieve<News>("$baseURL/manga/$mal_id/news") }

	/**
	 * Gets pictures related to Manga
	 *
	 * @return Pictures object
	 */
	@get:JsonProperty
	val pictures: CompletableFuture<Pictures> by lazy { retrieve<Pictures>("$baseURL/manga/$mal_id/pictures") }

	/**
	 * Gets stats about Manga object
	 *
	 * @return Stats object
	 */
	@get:JsonProperty
	val stats: CompletableFuture<MangaStats> by lazy { retrieve<MangaStats>("$baseURL/manga/$mal_id/stats") }

	/**
	 * Returns forum object
	 *
	 * @return Forum object
	 */
	@get:JsonProperty
	val forum: CompletableFuture<Forum> by lazy { retrieve<Forum>("$baseURL/manga/$mal_id/forum") }

	/**
	 * Returns Moreinfo object
	 *
	 * @return MoreInfo
	 */
	@get:JsonProperty
	val moreInfo: CompletableFuture<MoreInfo> by lazy { retrieve<MoreInfo>("$baseURL/manga/$mal_id/moreinfo") }

	/**
	 * Gets manga reviews
	 *
	 * @return MangaReviewPage
	 */
	@get:JsonProperty
	val reviews: CompletableFuture<MangaReviewPage> by lazy { retrieve<MangaReviewPage>("$baseURL/manga/$mal_id/reviews") }

	/**
	 * Gets recommendations for this manga
	 *
	 * @return RecommendationPage
	 */
	@get:JsonProperty
	val recommendationPage: CompletableFuture<RecommendationPage> by lazy { retrieve<RecommendationPage>("$baseURL/manga/$mal_id/recommendations") }

	/**
	 * Gets first page of user updates
	 *
	 * @return MangaUserUpdatesPage
	 */
	@get:JsonProperty
	val userUpdatesPage: CompletableFuture<MangaUserUpdatesPage> by lazy { getUserUpdatesPage(1) }

	/**
	 * Gets a page of userUpdates
	 *
	 * @param page which page to get, default is 1
	 * @return MangaUserUpdatesPage
	 */
	@JsonProperty
	fun getUserUpdatesPage(page: Int): CompletableFuture<MangaUserUpdatesPage> =
			retrieve<MangaUserUpdatesPage>("$baseURL/manga/$mal_id/userupdates/$page")
}