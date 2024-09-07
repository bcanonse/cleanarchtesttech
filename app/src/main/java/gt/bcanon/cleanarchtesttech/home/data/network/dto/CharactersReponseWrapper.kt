package gt.bcanon.cleanarchtesttech.home.data.network.dto

import com.squareup.moshi.Json

data class CharactersReponseWrapper(
    @field:Json(name = "info") val information: InfoResponse,
    @field:Json(name ="results") val results: List<CharactersDto>,
)