package app.wise.pokedex.data.retrofit

import app.wise.pokedex.data.models.Pokemon
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeDetailApiService {
    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: Int): Call<Pokemon>

    companion object {
        var retrofitService: PokeDetailApiService? = null
        fun getInstance(): PokeDetailApiService {
            if (retrofitService == null) {
                val gson = Gson()
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                retrofitService = retrofit.create(PokeDetailApiService::class.java)
            }
            return retrofitService!!
        }
    }
}