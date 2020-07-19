package com.github.doomsdayrs.jikan4java.data.model.main.anime

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
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
		@JsonProperty("request_hash") override val request_hash: String?,
		@JsonProperty("request_cached") override val request_cached: Boolean,
		@JsonProperty("request_cache_expiry") override val request_cache_expiry: Int,
		@JsonProperty("mal_id") override val malID: Int,
		@JsonProperty("url") override val url: String,
		@JsonProperty("trailer_url") val trailer_url: String = "",
		@JsonProperty("title") override val title: String,
		@JsonProperty("title_english") val title_english: String = "",
		@JsonProperty("title_japanese") val title_japanese: String = "",
		@JsonProperty("title_synonyms") val title_synonyms: List<String>,
		@JsonProperty("type") override val type: String = "",
		@JsonProperty("source") override val source: String = "",
		@JsonProperty("episodes") override val episodeCount: Int,
		@JsonProperty("status") override val status: String = "",
		@JsonProperty("aired") val aired: Aired?,
		@JsonProperty("airing") val airing: Boolean,
		@JsonProperty("duration") val duration: String = "",
		@JsonProperty("rating") val rating: String = "",
		@JsonProperty("score") override val score: Double,
		@JsonProperty("scored_by") val scored_by: Int,
		@JsonProperty("rank") val rank: Int,
		@JsonProperty("popularity") val popularity: Int,
		@JsonProperty("members") val members: Int,
		@JsonProperty("favorites") override val favoritesCount: Int,
		@JsonProperty("synopsis") val synopsis: String = "",
		@JsonProperty("background") val background: String = "",
		@JsonProperty("premiered") val premiered: String = "",
		@JsonProperty("broadcast") val broadcast: String = "",
		@JsonProperty("related") override val related: Related?,
		@JsonProperty("producers") val producers: List<Producer>,
		@JsonProperty("licensors") val licensors: List<Licensors>,
		@JsonProperty("studios") val studios: List<Studios>,
		@JsonProperty("genres") override val genres: List<Genre>,
		@JsonProperty("opening_themes") val opening_themes: List<String>,
		@JsonProperty("ending_themes") val ending_themes: List<String>,
		@JsonProperty("image_url") override val imageURL: String = ""
) :
		Retriever(),
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
		MyAnimeListFavoriteCount {

	/**
	 * Gets character and staff object
	 *
	 * @return Character_Staff
	 */
	@get:JsonIgnore
	val characterStaffs: CompletableFuture<CharacterStaff> by lazy { retrieve<CharacterStaff>("$jikanURL/anime/$malID/characters_staff") }

	/**
	 * Gets episodes, Please be aware that if the amount of episodes is greater than 100, the episode list will be split into two pages.
	 *
	 * @return Episode object
	 */
	@JsonIgnore
	fun getEpisodes(pageNumber: Int): CompletableFuture<Episodes> = retrieve("$jikanURL/anime/$malID${if (pageNumber != 0) "/episodes/$pageNumber" else "/episodes"}")

	@JsonIgnore
	fun getEpisodeCount(): CompletableFuture<Episodes> = getEpisodes(0)

	/**
	 * Gets news about anime
	 *
	 * @return News object
	 */
	@get:JsonIgnore
	val news: CompletableFuture<News> by lazy { retrieve<News>("$jikanURL/anime/$malID/news") }

	/**
	 * Gets pictures related to anime
	 *
	 * @return Pictures object
	 */
	@get:JsonIgnore
	val pictures: CompletableFuture<Pictures> by lazy { retrieve<Pictures>("$jikanURL/anime/$malID/pictures") }

	/**
	 * Gets videos related to anime
	 *
	 * @return Pictures object
	 */
	@get:JsonIgnore
	val videos: CompletableFuture<Video> by lazy { retrieve<Video>("$jikanURL/anime/$malID/videos") }

	/**
	 * Gets stats about anime object
	 *
	 * @return Stats object
	 */
	@get:JsonIgnore
	val stats: CompletableFuture<AnimeStats> by lazy { retrieve<AnimeStats>("$jikanURL/anime/$malID/stats") }

	/**
	 * Returns forum object
	 *
	 * @return Forum object
	 */
	@get:JsonIgnore
	val forum: CompletableFuture<Forum> by lazy { retrieve<Forum>("$jikanURL/anime/$malID/forum") }

	/**
	 * Returns MoreInfo object
	 *
	 * @return MoreInfo
	 */
	@get:JsonIgnore
	val moreInfo: CompletableFuture<MoreInfo> by lazy { retrieve<MoreInfo>("$jikanURL/anime/$malID/moreinfo") }

	@get:JsonIgnore
	val reviewPage: CompletableFuture<AnimeReviewPage> by lazy { retrieve<AnimeReviewPage>("$jikanURL/anime/$malID/reviews") }

	@get:JsonIgnore
	val recommendationPage: CompletableFuture<RecommendationPage> by lazy { retrieve<RecommendationPage>("$jikanURL/anime/$malID/recommendations") }

	@get:JsonIgnore
	val userUpdatesPage: CompletableFuture<AnimeUserUpdatesPage> by lazy { getUserUpdatesPage(0) }

	@JsonIgnore
	fun getUserUpdatesPage(page: Int): CompletableFuture<AnimeUserUpdatesPage> {
		return retrieve("$jikanURL/anime/$malID/userupdates/$page")
	}
}