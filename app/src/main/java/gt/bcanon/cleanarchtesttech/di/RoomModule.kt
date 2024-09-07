package gt.bcanon.cleanarchtesttech.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gt.bcanon.cleanarchtesttech.BuildConfig
import gt.bcanon.cleanarchtesttech.home.data.database.CharactersDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DB_NAME = BuildConfig.DB_NAME

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CharactersDatabase::class.java, DB_NAME).build()
}