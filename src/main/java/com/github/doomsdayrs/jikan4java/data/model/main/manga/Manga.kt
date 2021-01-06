package com.github.doomsdayrs.jikan4java.data.model.main.manga

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.endpoint.*
import com.github.doomsdayrs.jikan4java.data.base.endpoint.direct.MyAnimeListDirectPicturesEndPoint
import com.github.doomsdayrs.jikan4java.data.base.values.*
import com.github.doomsdayrs.jikan4java.data.model.main.manga.published.Published
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Authors
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.data.model.support.related.Related
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.manga.MangaReviewPage
import com.github.doomsdayrs.jikan4java.data.model.support.stats.MangaStats
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.manga.MangaUserUpdatesPage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
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
@Serializable
data class Manga(
	@SerialName("request_hash") val request_hash: String? = "",
	@SerialName("request_cached") val request_cached: Boolean = false,
	@SerialName("request_cache_expiry") val request_cache_expiry: Int = 0,
	@SerialName("mal_id") override val malID: Int = 0,
	@SerialName("url") override val url: String,
	@SerialName("title") override val title: String,
	@SerialName("title_english") val title_english: String = "",
	@SerialName("title_synonyms") val title_synonyms: List<String>,
	@SerialName("title_japanese") val title_japanese: String?,
	@SerialName("status") override val status: String = "",
	@SerialName("image_url") override val imageURL: String = "",
	@SerialName("type") val type: String = "",
	@SerialName("volumes") val volumes: Int = 0,
	@SerialName("chapters") val chapters: Int = 0,
	@SerialName("publishing") val publishing: Boolean = false,
	@SerialName("published") val published: Published?,
	@SerialName("rank") val rank: Int = 0,
	@SerialName("score") val score: Double = 0.0,
	@SerialName("scored_by") val scored_by: Int = 0,
	@SerialName("popularity") val popularity: Int = 0,
	@SerialName("members") val members: Int = 0,
	@SerialName("favorites") override val favoritesCount: Int = 0,
	@SerialName("synopsis") val synopsis: String = "",
	@SerialName("background") val background: String = "",
	@SerialName("related") override val related: Related?,
	@SerialName("genres") override val genres: List<Genre>,
	@SerialName("authors") val authors: List<Authors>,
	@SerialName("serializations") val serializations: List<Serializations>
) :
	MyAnimeListID,
	MyAnimeListURL,
	MyAnimeListTitle,
	MyAnimeListImageURL,
	MyAnimeListStatus,
	MyAnimeListRelated,
	MyAnimeListGenres,
	MyAnimeListFavoriteCount,
	MyAnimeListNewsEndPoint,
	MyAnimeListForumEndPoint,
	MyAnimeListPicturesEndPoint,
	MyAnimeListMoreInfoEndPoint {

	override val urlPoint: String
		get() = "manga"

	/**
	 * Returns MangaCharacters object
	 *
	 * @return [MangaCharacters]
	 */
	fun getCharacters(retriever: Retriever): CompletableFuture<JikanResult<MangaCharacters>> =
		retriever("$JIKAN_URL/manga/$malID/characters")

	/**
	 * Gets manga reviews
	 *
	 * @return [MangaReviewPage]
	 */
	fun getReviewPage(retrieve: Retriever): CompletableFuture<JikanResult<MangaReviewPage>> =
		retrieve("$JIKAN_URL/manga/$malID/reviews")

	/**
	 * Gets stats about Manga object
	 *
	 * @return [MangaStats]
	 */
	fun getStats(retrieve: Retriever): CompletableFuture<JikanResult<MangaStats>> =
		retrieve("$JIKAN_URL/manga/$malID/stats")

	/**
	 * Gets a page of userUpdates
	 *
	 * @param page which page to get, default is 1
	 * @return MangaUserUpdatesPage
	 */
	fun getUserUpdatesPage(
		retriever: Retriever,
		page: Int
	): CompletableFuture<JikanResult<MangaUserUpdatesPage>> =
		retriever("$JIKAN_URL/manga/$malID/userupdates/$page")


	companion object : MyAnimeListSelfType<Manga>,
		MyAnimeListDirectPicturesEndPoint {
		override fun getByID(retriever: Retriever, id: Int) =
			retriever<Manga>("$JIKAN_URL/manga/$id")

		override val urlPoint: String by lazy { "manga" }
	}
}