package gt.bcanon.cleanarchtesttech.home.domain.usecase

import gt.bcanon.cleanarchtesttech.home.data.repositories.CharactersRepository
import gt.bcanon.cleanarchtesttech.home.domain.model.Character
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(): Result<List<Character>> = repository.getCharacters()
}