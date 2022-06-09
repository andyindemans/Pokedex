package app.wise.pokedex.main.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.wise.pokedex.R
import app.wise.pokedex.databinding.FragmentFavoritesBinding
import app.wise.pokedex.main.MainActivity
import app.wise.pokedex.main.adapters.PokemonListAdapter
import app.wise.pokedex.main.detail.DetailFragment

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel: FavoritesViewModel by viewModels()
    private lateinit var pokemonListRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        val activity = requireActivity() as MainActivity

        binding.toolbar.setNavigationIcon(R.drawable.ic_chevron_left)

        binding.toolbar.setNavigationOnClickListener{
            activity.onBackPressed()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonListRecyclerView = binding.favoritePokemonList
        pokemonListRecyclerView.layoutManager = LinearLayoutManager(context)
        pokemonListRecyclerView.adapter = PokemonListAdapter{
            val pokemon = it
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DetailFragment(pokemon)).commit()
        }

        viewModel.favoriteList.observe(viewLifecycleOwner, Observer { list -> (pokemonListRecyclerView.adapter as PokemonListAdapter).setData(list) })
    }

}