package gt.bcanon.cleanarchtesttech.home.data.datasources

import gt.bcanon.cleanarchtesttech.home.data.network.CharactersApi
import gt.bcanon.cleanarchtesttech.home.data.network.dto.CharactersDto
import kotlin.coroutines.cancellation.CancellationException

interface RemoteCharactersDataSource {
    suspend fun getCharacters(): List<CharactersDto>
}

class RemoteCharactersDataSourceImpl(
    private val charactersApi: CharactersApi
) : RemoteCharactersDataSource {
    override suspend fun getCharacters(): List<CharactersDto> {
        try {
            val response = charactersApi.getCharacters()
            if (response.isSuccessful && response.code() == 200) {
                return response.body()?.results ?: emptyList()
            }
            throw CancellationException()
        } catch (e: Exception) {
            throw e
        }
    }
}