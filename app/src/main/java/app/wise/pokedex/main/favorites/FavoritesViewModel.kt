package app.wise.pokedex.main.favorites

import androidx.lifecycle.ViewModel
import app.wise.pokedex.data.repository.PokemonRepository

class FavoritesViewModel : ViewModel() {
    private val repository = PokemonRepository()
    val favoriteList = repository.getFavoritePokemons()
}