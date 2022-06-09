package app.wise.pokedex.data.retrofit

import app.wise.pokedex.data.models.Pokemon
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokeApiService {
    @GET("pokemon")
    fun getPokemonList(): Call<List<Pokemon>>

    companion object {
        var retrofitService: PokeApiService? = null
        fun getInstance(): PokeApiService {
            if (retrofitService == null) {
                val gson = Gson()
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://stoplight.io/mocks/appwise-be/pokemon/57519009/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                retrofitService = retrofit.create(PokeApiService::class.java)
            }
            return retrofitService!!
        }
    }
}

