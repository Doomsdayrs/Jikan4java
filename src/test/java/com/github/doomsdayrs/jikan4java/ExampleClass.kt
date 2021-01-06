package com.github.doomsdayrs.jikan4java

import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import kotlinx.coroutines.future.await

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
 */
/**
 * Jikan4java
 * 28 / October / 2018
 */
internal object ExampleClass {
	/**
	 * Example method
	 *
	 * @param args Args
	 */
	@JvmStatic
	suspend fun main(args: Array<String>) {
		//37765 = Hathaway's Flash
		AnimeSearch(Retriever()).getByID<Anime>(37765).await()
			.handle { anime ->
				println("Title: ${anime.title}")
				println("Release date: ${anime.aired?.string}")
				println("Status: ${anime.status}")
			}
	}

}