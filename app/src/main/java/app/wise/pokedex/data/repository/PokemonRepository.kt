package app.wise.pokedex.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import app.wise.pokedex.PokedexApplication
import app.wise.pokedex.data.models.Pokemon
import app.wise.pokedex.data.retrofit.PokeApiService
import app.wise.pokedex.data.retrofit.PokeDetailApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository() {
    private val database = PokedexApplication.database!!
    val pokemonDao = database.pokemonDao()!!

    fun getAllPokemon(): LiveData<List<Pokemon>> {
        return pokemonDao.getAllPokemon()
    }

    fun getPokemonDetails(id: Int): LiveData<Pokemon> {
        return pokemonDao.getPokemonDetails(id)
    }

    fun fetchAllPokemon() {
        PokeApiService.getInstance().getPokemonList().enqueue(object : Callback<List<Pokemon>> {
            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                Log.e("Error", "OOPS!! something went wrong..")
            }

            override fun onResponse(
                call: Call<List<Pokemon>>?,
                response: Response<List<Pokemon>>?
            ) {

                if (response != null) {
                    when (response.code()) {
                        200 -> {
                            Thread(Runnable {

                                pokemonDao.insert(response.body()!!)

                            }).start()
                        }
                    }
                }
            }
        })


    }

    fun fetchPokemonDetails(id: Int) {
        PokeDetailApiService.getInstance().getPokemonDetails(id)
            .enqueue(object : Callback<Pokemon> {
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    Log.e("Error", "OOPS!! something went wrong..")
                }

                override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {

                    if (response != null) {
                        when (response.code()) {
                            200 -> {
                                Thread(Runnable {

                                    pokemonDao.updatePokemonDetails(response.body()!!)

                                }).start()
                            }
                        }
                    }
                }
            })
    }


}