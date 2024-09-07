package gt.bcanon.cleanarchtesttech.home.data.datasources

import gt.bcanon.cleanarchtesttech.home.data.network.CharactersApi
import gt.bcanon.cleanarchtesttech.home.data.network.dto.CharactersDto
import kotlin.coroutines.cancellation.CancellationException

interface RemoteCharactersDataSource {
    suspend fun getTeams(): List<CharactersDto>
}

class RemoteCharactersDataSourceImpl(
    private val charactersApi: CharactersApi
) : RemoteCharactersDataSource {
    override suspend fun getTeams(): List<CharactersDto> {
        try {
            val response = charactersApi.getTeams()
            if (response.isSuccessful && response.code() == 200) {
                return response.body()?.results ?: emptyList()
            }
            throw CancellationException()
        } catch (e: Exception) {
            throw e
        }
    }
}