package com.github.doomsdayrs.jikan4java.data.enums.search

import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.data.model.main.anime.animePage.AnimePage
import com.github.doomsdayrs.jikan4java.data.model.main.character.characterPage.CharacterPage
import com.github.doomsdayrs.jikan4java.data.model.main.manga.Manga
import com.github.doomsdayrs.jikan4java.data.model.main.manga.mangapage.MangaPage
import com.github.doomsdayrs.jikan4java.data.model.main.person.Person
import com.github.doomsdayrs.jikan4java.data.model.main.person.personPage.PersonPage

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
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
enum class Types(
	private val type: String,
	@Deprecated("Useless with kotlin")
	val a: Class<*>,
	@Deprecated("Useless with kotlin")
	val b: Class<*>
) {
	ANIME("anime", AnimePage::class.java, Anime::class.java),
	MANGA("manga", MangaPage::class.java, Manga::class.java),
	PERSON("person", PersonPage::class.java, Person::class.java),
	CHARACTER("character", CharacterPage::class.java, Char::class.java);

	override fun toString(): String = type
}