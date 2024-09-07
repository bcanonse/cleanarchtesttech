package gt.bcanon.cleanarchtesttech.home.data.database

import gt.bcanon.cleanarchtesttech.home.data.database.entity.CharactersEntity
import gt.bcanon.cleanarchtesttech.home.data.network.dto.CharactersDto

fun CharactersDto.toDatabase() = CharactersEntity(
    id, name, status, image
)