package gt.bcanon.cleanarchtesttech.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gt.bcanon.cleanarchtesttech.home.data.database.CharactersDatabase
import gt.bcanon.cleanarchtesttech.home.data.database.dao.CharactersDao
import gt.bcanon.cleanarchtesttech.home.data.datasources.LocalCharactersDataSource
import gt.bcanon.cleanarchtesttech.home.data.datasources.LocalCharactersDataSourceImpl
import gt.bcanon.cleanarchtesttech.home.data.datasources.RemoteCharactersDataSource
import gt.bcanon.cleanarchtesttech.home.data.datasources.RemoteCharactersDataSourceImpl
import gt.bcanon.cleanarchtesttech.home.data.network.CharactersApi
import gt.bcanon.cleanarchtesttech.home.data.repositories.CharactersRepository
import gt.bcanon.cleanarchtesttech.home.data.repositories.CharactersRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Scope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): CharactersApi = retrofit.create(CharactersApi::class.java)


    @Singleton
    @Provides
    fun provideCharactersDao(db: CharactersDatabase) = db.charactersDao()

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: CharactersApi): RemoteCharactersDataSource =
        RemoteCharactersDataSourceImpl(api)


    @Provides
    @Singleton
    fun provideLocalDataSource(dao: CharactersDao): LocalCharactersDataSource =
        LocalCharactersDataSourceImpl(dao)


    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSource: RemoteCharactersDataSource,
        localDataSource: LocalCharactersDataSource
    ): CharactersRepository = CharactersRepositoryImpl(
        remoteDataSource, localDataSource
    )
}