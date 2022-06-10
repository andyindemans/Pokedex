package app.wise.pokedex.main.home

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import app.wise.pokedex.data.models.Pokemon
import app.wise.pokedex.data.repository.PokemonRepository


class HomeViewModel() : ViewModel() {
    private val repository = PokemonRepository()
    val favoriteCount = repository.getFavoritesCount()
    val teamCount = repository.getTeamCount()
    val searchString = MutableLiveData("")

    val pokemonList: LiveData<List<Pokemon>> = Transformations.switchMap(searchString) {
        if (TextUtils.isEmpty(it)) {
            repository.getAllPokemon()
        } else {
            repository.getPokemonBySearch(it)
        }
    }


    init {
        repository.fetchAllPokemon()
    }

}