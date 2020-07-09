package com.github.doomsdayrs.jikan4java.data.model.main.anime

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.*
import com.github.doomsdayrs.jikan4java.data.model.main.anime.characterStaff.CharacterStaff
import com.github.doomsdayrs.jikan4java.data.model.main.anime.episodes.Episodes
import com.github.doomsdayrs.jikan4java.data.model.main.anime.videos.Video
import com.github.doomsdayrs.jikan4java.data.model.support.MoreInfo
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Producer
import com.github.doomsdayrs.jikan4java.data.model.support.forum.Forum
import com.github.doomsdayrs.jikan4java.data.model.support.news.News
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures
import com.github.doomsdayrs.jikan4java.data.model.support.recommendations.RecommendationPage
import com.github.doomsdayrs.jikan4java.data.model.support.related.Related
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.anime.AnimeReviewPage
import com.github.doomsdayrs.jikan4java.data.model.support.stats.AnimeStats
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.anime.AnimeUserUpdatesPage
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
 */
/**
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
data class Anime(
		@field:JsonProperty("request_hash") override val request_hash: String? = null,
		@field:JsonProperty("request_cached") override val request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") override val request_cache_expiry: Int = 0,
		@field:JsonProperty("mal_id") override val malID: Int = 0,
		@field:JsonProperty("url") override val url: String,
		@field:JsonProperty("trailer_url") val trailer_url: String? = null,
		@field:JsonProperty("title") override val title: String,
		@field:JsonProperty("title_english") val title_english: String? = null,
		@field:JsonProperty("title_japanese") val title_japanese: String? = null,
		@field:JsonProperty("title_synonyms") val title_synonyms: ArrayList<String>? = null,
		@field:JsonProperty("type") override val type: String? = null,
		@field:JsonProperty("source") val source: String? = null,
		@field:JsonProperty("episodes") val episodes: Int = 0,
		@field:JsonProperty("status") override val status: String? = null,
		@field:JsonProperty("aired") val aired: Aired? = null,
		@field:JsonProperty("airing") val airing: Boolean = false,
		@field:JsonProperty("duration") val duration: String? = null,
		@field:JsonProperty("rating") val rating: String? = null,
		@field:JsonProperty("score") val score: Double = 0.0,
		@field:JsonProperty("scored_by") val scored_by: Int = 0,
		@field:JsonProperty("rank") val rank: Int = 0,
		@field:JsonProperty("popularity") val popularity: Int = 0,
		@field:JsonProperty("members") val members: Int = 0,
		@field:JsonProperty("favorites") val favorites: Int = 0,
		@field:JsonProperty("synopsis") val synopsis: String? = null,
		@field:JsonProperty("background") val background: String? = null,
		@field:JsonProperty("premiered") val premiered: String? = null,
		@field:JsonProperty("broadcast") val broadcast: String? = null,
		@field:JsonProperty("related") val related: Related? = null,
		@field:JsonProperty("producers") val producers: ArrayList<Producer>? = null,
		@field:JsonProperty("licensors") val licensors: ArrayList<Licensors>? = null,
		@field:JsonProperty("studios") val studios: ArrayList<Studios>? = null,
		@field:JsonProperty("genres") val genres: ArrayList<Genre>? = null,
		@field:JsonProperty("opening_themes") val opening_themes: ArrayList<String>? = null,
		@field:JsonProperty("ending_themes") val ending_themes: ArrayList<String>? = null,
		@field:JsonProperty("image_url") override val imageURL: String? = null
) :
		Retriever(),
		RequestHashing,
		MyAnimeListID,
		MyAnimeListURL,
		MyAnimeListTitle,
		MyAnimeListImageURL,
		MyAnimeListType,
		MyAnimeListStatus {

	/**
	 * Gets character and staff object
	 *
	 * @return Character_Staff
	 */
	@get:JsonProperty
	val characterStaffs: CompletableFuture<CharacterStaff> by lazy { retrieve<CharacterStaff>("$baseURL/anime/$malID/characters_staff") }

	/**
	 * Gets episodes, Please be aware that if the amount of episodes is greater than 100, the episode list will be split into two pages.
	 *
	 * @return Episode object
	 */
	@JsonProperty
	fun getEpisodes(pageNumber: Int): CompletableFuture<Episodes> = retrieve("$baseURL/anime/$malID${if (pageNumber != 0) "/episodes/$pageNumber" else "/episodes"}")

	@JsonProperty
	fun getEpisodes(): CompletableFuture<Episodes> = getEpisodes(0)

	/**
	 * Gets news about anime
	 *
	 * @return News object
	 */
	@get:JsonProperty
	val news: CompletableFuture<News> by lazy { retrieve<News>("$baseURL/anime/$malID/news") }

	/**
	 * Gets pictures related to anime
	 *
	 * @return Pictures object
	 */
	@get:JsonProperty
	val pictures: CompletableFuture<Pictures> by lazy { retrieve<Pictures>("$baseURL/anime/$malID/pictures") }

	/**
	 * Gets videos related to anime
	 *
	 * @return Pictures object
	 */
	@get:JsonProperty
	val videos: CompletableFuture<Video> by lazy { retrieve<Video>("$baseURL/anime/$malID/videos") }

	/**
	 * Gets stats about anime object
	 *
	 * @return Stats object
	 */
	@get:JsonProperty
	val stats: CompletableFuture<AnimeStats> by lazy { retrieve<AnimeStats>("$baseURL/anime/$malID/stats") }

	/**
	 * Returns forum object
	 *
	 * @return Forum object
	 */
	@get:JsonProperty
	val forum: CompletableFuture<Forum> by lazy { retrieve<Forum>("$baseURL/anime/$malID/forum") }

	/**
	 * Returns MoreInfo object
	 *
	 * @return MoreInfo
	 */
	@get:JsonProperty
	val moreInfo: CompletableFuture<MoreInfo> by lazy { retrieve<MoreInfo>("$baseURL/anime/$malID/moreinfo") }

	@get:JsonProperty
	val reviewPage: CompletableFuture<AnimeReviewPage> by lazy { retrieve<AnimeReviewPage>("$baseURL/anime/$malID/reviews") }

	@get:JsonProperty
	val recommendationPage: CompletableFuture<RecommendationPage> by lazy { retrieve<RecommendationPage>("$baseURL/anime/$malID/recommendations") }

	@get:JsonProperty
	val userUpdatesPage: CompletableFuture<AnimeUserUpdatesPage> by lazy { getUserUpdatesPage(0) }

	@JsonProperty
	fun getUserUpdatesPage(page: Int): CompletableFuture<AnimeUserUpdatesPage> {
		return retrieve("$baseURL/anime/$malID/userupdates/$page")
	}
}