package app.wise.pokedex.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.wise.pokedex.R
import app.wise.pokedex.data.api.PokemonResult

class PokemonListAdapter(val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokemonListAdapter.PokeViewHolder>() {
    var pokemonList: List<PokemonResult>  = emptyList<PokemonResult>()

    fun setData(list: List<PokemonResult>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        return PokeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent,false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.findViewById<TextView>(R.id.pokemon_list_name_text).text = pokemon.name
        holder.itemView.findViewById<TextView>(R.id.pokemon_list_number_text).text = (position + 1).toString()

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }

    class PokeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}