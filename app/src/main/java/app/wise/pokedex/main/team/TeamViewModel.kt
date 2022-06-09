package app.wise.pokedex.main.team

import androidx.lifecycle.ViewModel
import app.wise.pokedex.data.repository.PokemonRepository

class TeamViewModel : ViewModel() {
    private val repository = PokemonRepository()
    val teamList = repository.getTeam()
}