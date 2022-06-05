package app.wise.pokedex.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val searchText = MutableLiveData("")

}