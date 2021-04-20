package com.github.doomsdayrs.jikan4java.data.enums

import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.anime.AnimeTop
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.character.CharacterTop
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.manga.MangaTop
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.person.PersonTop

sealed class TopType<T : Top<*>>(
	val name: String
) {
	object PERSON : TopType<PersonTop>("people")
	object MANGA : TopType<MangaTop>("manga")
	object CHARACTER : TopType<CharacterTop>("characters")
	object ANIME : TopType<AnimeTop>("anime")
}