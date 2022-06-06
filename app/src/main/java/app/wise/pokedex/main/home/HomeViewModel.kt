package app.wise.pokedex.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.wise.pokedex.data.api.PokemonApiResponse
import app.wise.pokedex.data.api.PokemonResult
import app.wise.pokedex.data.service.PokeApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {
    private val retrofit  = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokeApiService = retrofit.create(PokeApiService::class.java)
    val pokemonList = MutableLiveData<List<PokemonResult>>()

    fun getPokemonList() {
        val call = service.getPokemonList(151, 0)

        call.enqueue(object : Callback<PokemonApiResponse> {
            override fun onResponse(call: Call<PokemonApiResponse>, response: Response<PokemonApiResponse>) {
                response.body()?.results?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<PokemonApiResponse>, t: Throwable) {
                call.cancel()
            }
        })
    }

}