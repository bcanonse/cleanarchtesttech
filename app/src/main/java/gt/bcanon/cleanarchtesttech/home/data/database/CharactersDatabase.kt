package gt.bcanon.cleanarchtesttech.home.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import gt.bcanon.cleanarchtesttech.home.data.database.dao.CharactersDao
import gt.bcanon.cleanarchtesttech.home.data.database.entity.CharactersEntity

@Database(
    entities = [CharactersEntity::class],
    version = 1,
    exportSchema = false
)

abstract class CharactersDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}