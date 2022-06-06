package app.wise.pokedex.data.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonApiResponse (
    @Expose @SerializedName("id") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<PokemonResult>
)

data class PokemonResult (
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)