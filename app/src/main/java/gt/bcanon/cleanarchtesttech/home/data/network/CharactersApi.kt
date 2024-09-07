package gt.bcanon.cleanarchtesttech.home.data.network

import gt.bcanon.cleanarchtesttech.home.data.network.dto.CharactersReponseWrapper
import retrofit2.Response
import retrofit2.http.GET

interface CharactersApi {
    @GET("character/")
    suspend fun getTeams(): Response<CharactersReponseWrapper>
}