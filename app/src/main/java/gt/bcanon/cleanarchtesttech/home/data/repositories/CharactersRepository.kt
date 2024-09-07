package gt.bcanon.cleanarchtesttech.home.data.repositories

import gt.bcanon.cleanarchtesttech.home.data.database.toDatabase
import gt.bcanon.cleanarchtesttech.home.data.datasources.LocalCharactersDataSource
import gt.bcanon.cleanarchtesttech.home.data.datasources.RemoteCharactersDataSource
import gt.bcanon.cleanarchtesttech.home.domain.mappers.toDomain
import gt.bcanon.cleanarchtesttech.home.domain.model.Character
import java.net.SocketTimeoutException
import kotlin.coroutines.cancellation.CancellationException

interface CharactersRepository {
    suspend fun getCharacters(): Result<List<Character>>
}

class CharactersRepositoryImpl(
    private val remoteDataSource: RemoteCharactersDataSource,
    private val localDataSource: LocalCharactersDataSource
) : CharactersRepository {
    override suspend fun getCharacters(): Result<List<Character>> {
        return try {
            val remoteData = remoteDataSource.getTeams()
            if (remoteData.isNotEmpty()) {
                localDataSource.deleteAllCharacters()
                localDataSource.insertCharacters(remoteData.map { it.toDatabase() })
                return Result.success(remoteData.map { it.toDomain() })
            } else {
                Result.success(localDataSource.getCharacters().map { it.toDomain() })
            }
        } catch (exception: Exception) {
            when (exception) {
                is SocketTimeoutException,
                is CancellationException -> {
                    return Result.success(localDataSource.getCharacters().map { it.toDomain() })
                }
                else -> {
                    return Result.failure(exception)
                }
            }
        }
    }
}