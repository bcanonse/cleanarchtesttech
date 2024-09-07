package gt.bcanon.cleanarchtesttech.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gt.bcanon.cleanarchtesttech.home.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    var state by mutableStateOf(CharactersState())
        private set

    init {
        viewModelScope.launch {
            getCharacters()
        }
    }

    private suspend fun getCharacters() {
        state = state.copy(
            isLoading = true
        )
        val result = getCharactersUseCase()
        result.onSuccess {
            state = state.copy(
                characters = it
            )
        }.onFailure {
            state = state.copy(
                error = it.message.toString()
            )
        }
        state = state.copy(
            isLoading = false
        )
    }
}