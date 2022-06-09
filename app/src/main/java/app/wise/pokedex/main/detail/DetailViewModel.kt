package app.wise.pokedex.main.detail

import androidx.lifecycle.*
import app.wise.pokedex.data.repository.PokemonRepository

class DetailViewModel(val pokemonId: Int) : ViewModel() {
    private val repository = PokemonRepository()
    val pokemon = repository.getPokemonDetails(pokemonId)

    init {
        repository.fetchPokemonDetails(pokemonId)
    }

    fun favoriteButtonClick() {
        if (pokemon.value != null) {
            repository.setFavoriteStatus(pokemonId, !pokemon.value!!.favorite)
        }
    }

    fun teamButtonClick() {
        if (pokemon.value != null) {
            repository.setTeamStatus(pokemonId, !pokemon.value!!.team)
        }
    }

}

class DetailViewModelFactory(val id: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(id) as T
    }
}