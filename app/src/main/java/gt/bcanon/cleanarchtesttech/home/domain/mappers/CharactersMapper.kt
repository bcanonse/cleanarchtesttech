package gt.bcanon.cleanarchtesttech.home.domain.mappers

import gt.bcanon.cleanarchtesttech.home.data.database.entity.CharactersEntity
import gt.bcanon.cleanarchtesttech.home.data.network.dto.CharactersDto
import gt.bcanon.cleanarchtesttech.home.domain.model.Character

fun CharactersDto.toDomain() = Character(
    id, name, status == "Alive", image
)


fun CharactersEntity.toDomain() = Character(
    id, name, status == "Alive", image
)