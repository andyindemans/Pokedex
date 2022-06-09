package app.wise.pokedex.main.home

import androidx.lifecycle.ViewModel
import app.wise.pokedex.data.repository.PokemonRepository


class HomeViewModel() : ViewModel() {
    private val repository = PokemonRepository()
    val pokemonList = repository.getAllPokemon()

    init {
        repository.fetchAllPokemon()
    }


}
