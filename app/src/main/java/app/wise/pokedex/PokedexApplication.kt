package app.wise.pokedex

import android.app.Application
import androidx.room.Room
import app.wise.pokedex.data.db.PokemonDatabase

class PokedexApplication: Application() {
    companion object {
        var database: PokemonDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, PokemonDatabase::class.java, "pokemon_db").fallbackToDestructiveMigration().build()
    }
}