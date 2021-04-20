package com.github.doomsdayrs.jikan4java.data.base.endpoint.direct

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.data.base.endpoint.MyAnimeListEntityPoint

interface MyAnimeListDirectPicturesEndPoint : MyAnimeListEntityPoint {

	fun getPicturesUrl(
		malID: Int
	): String = "$JIKAN_URL/$urlPoint/$malID/pictures"
}