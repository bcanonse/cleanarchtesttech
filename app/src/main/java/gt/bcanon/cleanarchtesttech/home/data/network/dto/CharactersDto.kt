package gt.bcanon.cleanarchtesttech.home.data.network.dto

import com.squareup.moshi.Json

data class CharactersDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "image") val image: String,
)

