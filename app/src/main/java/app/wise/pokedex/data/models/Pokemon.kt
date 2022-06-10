package app.wise.pokedex.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey
    val id: Int,
    val abilities: List<Ability>?,
    val height: Int?,
    val moves: List<Move>?,
    val name: String?,
    val sprites: Sprites?,
    val stats: List<Stat>?,
    val types: List<Type>,
    val weight: Int?,
    val favorite: Boolean = false,
    val team: Boolean = false
)