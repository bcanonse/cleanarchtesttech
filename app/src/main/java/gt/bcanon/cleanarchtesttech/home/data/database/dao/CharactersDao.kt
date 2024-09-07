package gt.bcanon.cleanarchtesttech.home.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gt.bcanon.cleanarchtesttech.home.data.database.entity.CharactersEntity

@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters ORDER BY id ASC")
    fun getCharacters(): List<CharactersEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharactersEntity>)

    @Query("DELETE FROM characters")
    suspend fun deleteAllCharacters()
}