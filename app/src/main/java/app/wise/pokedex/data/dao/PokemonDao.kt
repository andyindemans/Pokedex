package app.wise.pokedex.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import app.wise.pokedex.data.models.Move
import app.wise.pokedex.data.models.Pokemon
import app.wise.pokedex.data.models.Stat
import app.wise.pokedex.data.models.Type

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pokemonList: List<Pokemon>)

    @Query("UPDATE pokemon SET height=:height, moves=:moves, stats=:stats, types=:types, weight=:weight WHERE id=:id")
    fun updatePokemonDetails(id: Int, height: Int, moves: List<Move>, stats: List<Stat>, types: List<Type>, weight: Int)

    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id=:id ")
    fun getPokemonDetails(id: Int): LiveData<Pokemon>

    @Query("UPDATE pokemon SET favorite = :favorite WHERE id=:id")
    fun setFavoriteStatus(id: Int, favorite: Boolean)

    @Query("UPDATE pokemon SET team=:team WHERE id=:id")
    fun setTeamStatus(id: Int, team: Boolean)

    @Query("SELECT * FROM pokemon WHERE favorite")
    fun getFavoritePokemons(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE team")
    fun getTeam(): LiveData<List<Pokemon>>
}