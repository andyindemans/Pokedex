package app.wise.pokedex.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.wise.pokedex.data.converters.PokemonConverter
import app.wise.pokedex.data.dao.PokemonDao
import app.wise.pokedex.data.models.Pokemon

@Database(entities = [Pokemon::class], version = 1)
@TypeConverters(PokemonConverter::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao?
}