package gt.bcanon.cleanarchtesttech.home.data.datasources

import gt.bcanon.cleanarchtesttech.home.data.database.dao.CharactersDao
import gt.bcanon.cleanarchtesttech.home.data.database.entity.CharactersEntity

interface LocalCharactersDataSource {
    suspend fun getCharacters(): List<CharactersEntity>

    suspend fun insertCharacters(characters: List<CharactersEntity>)

    suspend fun deleteAllCharacters()
}


internal class LocalCharactersDataSourceImpl(
    private val dao: CharactersDao

) : LocalCharactersDataSource {
    override suspend fun getCharacters(): List<CharactersEntity> =
        dao.getCharacters()

    override suspend fun insertCharacters(characters: List<CharactersEntity>) =
        dao.insertCharacters(characters)

    override suspend fun deleteAllCharacters() = dao.deleteAllCharacters()

}