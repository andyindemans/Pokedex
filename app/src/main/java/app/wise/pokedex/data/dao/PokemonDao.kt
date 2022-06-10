package app.wise.pokedex.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.wise.pokedex.data.models.*

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pokemonList: List<Pokemon>)

    @Query("UPDATE pokemon SET height=:height, moves=:moves, stats=:stats, types=:types, weight=:weight, abilities=:abilities WHERE id=:id")
    fun updatePokemonDetails(id: Int, height: Int, moves: List<Move>, stats: List<Stat>, types: List<Type>, weight: Int, abilities: List<Ability>)

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

    @Query("SELECT COUNT(id) FROM pokemon WHERE favorite")
    fun getFavoriteCount(): LiveData<Int>

    @Query("SELECT COUNT(id) FROM pokemon WHERE team")
    fun getTeamCount(): LiveData<Int>

    @Query("SELECT * FROM pokemon where name LIKE  :name or LOWER(name) like LOWER(:name) order by id")
    fun getAllPokemonBySearch(name: String): LiveData<List<Pokemon>>
}