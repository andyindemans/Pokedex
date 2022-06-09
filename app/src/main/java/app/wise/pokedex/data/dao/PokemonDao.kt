package app.wise.pokedex.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import app.wise.pokedex.data.models.Pokemon

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pokemonList: List<Pokemon>)

    @Update
    fun updatePokemonDetails(pokemonDetails: Pokemon)

    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id=:id ")
    fun getPokemonDetails(id: Int): LiveData<Pokemon>
}