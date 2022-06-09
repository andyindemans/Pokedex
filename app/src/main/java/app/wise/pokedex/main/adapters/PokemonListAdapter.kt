package app.wise.pokedex.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.wise.pokedex.data.models.Pokemon
import app.wise.pokedex.databinding.PokemonListItemBinding
import com.bumptech.glide.Glide

class PokemonListAdapter(val pokemonClick: (Int) -> Unit) :
    RecyclerView.Adapter<PokemonListAdapter.PokeViewHolder>() {
    var pokemonList: List<Pokemon> = emptyList()

    fun setData(list: List<Pokemon>) {
        pokemonList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        return PokeViewHolder(
            PokemonListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bindViewHolder(pokemon)

        holder.itemView.setOnClickListener { pokemonClick(pokemonList[position].id) }
    }

    class PokeViewHolder(val pokemonListItemBinding: PokemonListItemBinding) :
        RecyclerView.ViewHolder(pokemonListItemBinding.root) {
        fun bindViewHolder(pokemon: Pokemon) {
            pokemonListItemBinding.pokemonListNameText.text = pokemon.name
            pokemonListItemBinding.pokemonListNumberText.text =
                "Nr. " + (pokemon.id).toString().padStart(3, '0')
            Glide.with(pokemonListItemBinding.root).load(pokemon.sprites?.front_default)
                .into(pokemonListItemBinding.pokemonListImage)
        }
    }

}