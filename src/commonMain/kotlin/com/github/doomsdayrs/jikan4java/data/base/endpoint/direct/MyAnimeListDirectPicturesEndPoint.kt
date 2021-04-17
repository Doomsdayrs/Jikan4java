package com.github.doomsdayrs.jikan4java.data.base.endpoint.direct

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.endpoint.MyAnimeListEntityPoint
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures
import java.util.concurrent.CompletableFuture

interface MyAnimeListDirectPicturesEndPoint : MyAnimeListEntityPoint {

	/**
	 * Gets pictures related to [malID]
	 *
	 * @return [JikanResult] of [Pictures]
	 */
	fun getPictures(
		retrieve: Retriever,
		malID: Int
	): CompletableFuture<JikanResult<Pictures>> =
		retrieve("$JIKAN_URL/$urlPoint/$malID/pictures")
}