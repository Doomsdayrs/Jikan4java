package com.github.doomsdayrs.jikan4java.data.model.main.anime

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.endpoint.*
import com.github.doomsdayrs.jikan4java.data.base.endpoint.direct.MyAnimeListDirectPicturesEndPoint
import com.github.doomsdayrs.jikan4java.data.base.values.*
import com.github.doomsdayrs.jikan4java.data.model.main.anime.characterStaff.AnimeCharacterStaffPage
import com.github.doomsdayrs.jikan4java.data.model.main.anime.episodes.EpisodesPage
import com.github.doomsdayrs.jikan4java.data.model.main.anime.videos.AnimeVideos
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Producer
import com.github.doomsdayrs.jikan4java.data.model.support.recommendations.AnimeRecommendationPage
import com.github.doomsdayrs.jikan4java.data.model.support.related.Related
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.anime.AnimeReviewPage
import com.github.doomsdayrs.jikan4java.data.model.support.stats.AnimeStats
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.anime.AnimeUserUpdatesPage
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
 */
/**
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */

@Serializable
data class Anime(
	@SerialName("request_hash") override val requestHash: String,
	@SerialName("request_cached") override val requestCached: Boolean,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
	@SerialName("mal_id") override val malID: Int,
	@SerialName("url") override val url: String,
	@SerialName("trailer_url") val trailer_url: String = "",
	@SerialName("title") override val title: String,
	@SerialName("title_english") val title_english: String = "",
	@SerialName("title_japanese") val title_japanese: String = "",
	@SerialName("title_synonyms") val title_synonyms: List<String>,
	@SerialName("type") override val type: String = "",
	@SerialName("source") override val source: String = "",
	@SerialName("episodes") override val episodeCount: Int,
	@SerialName("status") override val status: String = "",
	@SerialName("aired") val aired: Aired?,
	@SerialName("airing") val airing: Boolean,
	@SerialName("duration") val duration: String = "",
	@SerialName("rating") val rating: String = "",
	@SerialName("score") override val score: Double,
	@SerialName("scored_by") val scored_by: Int,
	@SerialName("rank") val rank: Int,
	@SerialName("popularity") val popularity: Int,
	@SerialName("members") val members: Int,
	@SerialName("favorites") override val favoritesCount: Int,
	@SerialName("synopsis") val synopsis: String = "",
	@SerialName("background") val background: String = "",
	@SerialName("premiered") val premiered: String = "",
	@SerialName("broadcast") val broadcast: String = "",
	@SerialName("related") override val related: Related? = null,
	@SerialName("producers") val producers: List<Producer>,
	@SerialName("licensors") val licensors: List<Licensors>,
	@SerialName("studios") val studios: List<Studios>,
	@SerialName("genres") override val genres: List<Genre>,
	@SerialName("opening_themes") val opening_themes: List<String>,
	@SerialName("ending_themes") val ending_themes: List<String>,
	@SerialName("image_url") override val imageURL: String = ""
) :
	RequestHashing,
	MyAnimeListID,
	MyAnimeListURL,
	MyAnimeListTitle,
	MyAnimeListImageURL,
	MyAnimeListType,
	MyAnimeListStatus,
	MyAnimeListSource,
	MyAnimeListEpisodeCount,
	MyAnimeListScore,
	MyAnimeListRelated,
	MyAnimeListGenres,
	MyAnimeListFavoriteCount,
	MyAnimeListNewsEndPoint,
	MyAnimeListPicturesEndPoint,
	MyAnimeListMoreInfoEndPoint,
	MyAnimeListForumEndPoint {

	override val urlPoint: String
		get() = "anime"

	/**
	 * Gets character and staff object
	 *
	 * @return [AnimeCharacterStaffPage]
	 */
	fun getCharacterStaffs(retriever: Retriever): CompletableFuture<JikanResult<AnimeCharacterStaffPage>> =
		retriever("$JIKAN_URL/anime/$malID/characters_staff")

	/**
	 * Gets episodes, Please be aware that if the amount
	 * of episodes is greater than 100, the
	 * episode list will be split into two pages.
	 *
	 * @return [EpisodesPage]
	 */
	fun getEpisodesPage(
		retriever: Retriever,
		pageNumber: Int
	): CompletableFuture<JikanResult<EpisodesPage>> {
		val pagesEndpoint = if (pageNumber != 0) "/$pageNumber" else ""
		return retriever("$JIKAN_URL/anime/$malID/episodes$pagesEndpoint")
	}

	/**
	 * Gets videos related to anime
	 *
	 * @return [AnimeVideos]
	 */
	fun getVideos(retriever: Retriever): CompletableFuture<JikanResult<AnimeVideos>> =
		retriever("$JIKAN_URL/anime/$malID/videos")

	/**
	 * Gets stats about anime object
	 *
	 * @return [AnimeStats]
	 */
	fun getStats(retriever: Retriever): CompletableFuture<JikanResult<AnimeStats>> =
		retriever("$JIKAN_URL/anime/$malID/stats")


	/**
	 *
	 * @return [AnimeReviewPage]
	 */
	fun getReviewPage(retriever: Retriever): CompletableFuture<JikanResult<AnimeReviewPage>> =
		retriever("$JIKAN_URL/anime/$malID/reviews")


	/**
	 *
	 * @return [AnimeRecommendationPage]
	 */
	fun getRecommendationPage(retriever: Retriever): CompletableFuture<JikanResult<AnimeRecommendationPage>> =
		retriever("$JIKAN_URL/anime/$malID/recommendations")


	/**
	 *
	 * @return [AnimeUserUpdatesPage]
	 */
	fun getUserUpdatesPage(
		retriever: Retriever,
		page: Int
	): CompletableFuture<JikanResult<AnimeUserUpdatesPage>> =
		retriever("$JIKAN_URL/anime/$malID/userupdates/$page")

	companion object : MyAnimeListSelfType<Anime>,
		MyAnimeListDirectPicturesEndPoint {
		@JvmStatic
		override fun getByID(retriever: Retriever, id: Int) =
			retriever<Anime>("$JIKAN_URL/$urlPoint/$id")

		override val urlPoint: String by lazy { "anime" }

	}
}