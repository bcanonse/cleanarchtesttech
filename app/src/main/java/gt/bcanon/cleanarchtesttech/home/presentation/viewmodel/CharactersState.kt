package gt.bcanon.cleanarchtesttech.home.presentation.viewmodel

import gt.bcanon.cleanarchtesttech.home.domain.model.Character

data class CharactersState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList(),
    val error: String? = null
)
