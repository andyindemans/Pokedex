package app.wise.pokedex.main.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.wise.pokedex.R
import app.wise.pokedex.databinding.FragmentHomeBinding
import app.wise.pokedex.main.MainActivity
import app.wise.pokedex.main.adapters.PokemonListAdapter
import app.wise.pokedex.main.detail.DetailFragment
import app.wise.pokedex.main.favorites.FavoritesFragment
import app.wise.pokedex.main.team.TeamFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var pokemonListRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        val activity = requireActivity() as MainActivity

        binding.favoritesCard.setOnClickListener { activity.loadFragment(FavoritesFragment()) }
        binding.myTeamCard.setOnClickListener { activity.loadFragment(TeamFragment()) }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonListRecyclerView = view.findViewById(R.id.pokemon_list)
        pokemonListRecyclerView.layoutManager = LinearLayoutManager(context)
        pokemonListRecyclerView.adapter = PokemonListAdapter {
            val pokemon = it
            requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailFragment(pokemon)).commit()
        }

        viewModel.pokemonList.observe(
            viewLifecycleOwner,
            Observer { list -> (pokemonListRecyclerView.adapter as PokemonListAdapter).setData(list) })
    }


}
