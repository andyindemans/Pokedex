package app.wise.pokedex.data.converters

import androidx.room.TypeConverter
import app.wise.pokedex.data.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PokemonConverter {
    @TypeConverter
    fun toAbilities(value: String): List<Ability>? {
        val listType: java.lang.reflect.Type? = object : TypeToken<List<Ability>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromAbility(ability: List<Ability>?): String {
        return Gson().toJson(ability)
    }

    @TypeConverter
    fun toMoves(value: String): List<Move>? {
        val listType: java.lang.reflect.Type? = object : TypeToken<List<Move>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromMove(move: List<Move>?): String {
        return Gson().toJson(move)
    }

    @TypeConverter
    fun toSprites(value: String): Sprites {
        return Gson().fromJson(value, Sprites::class.java)
    }

    @TypeConverter
    fun fromSprites(sprites: Sprites): String {
        return Gson().toJson(sprites)
    }

    @TypeConverter
    fun toStat(value: String): List<Stat>? {
        val listType: java.lang.reflect.Type? = object : TypeToken<List<Stat>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromStat(stat: List<Stat>?): String {
        return Gson().toJson(stat)
    }

    @TypeConverter
    fun toType(value: String): List<Type>? {
        val listType: java.lang.reflect.Type? = object : TypeToken<List<Type>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromType(type: List<Type>?): String {
        return Gson().toJson(type)
    }
}