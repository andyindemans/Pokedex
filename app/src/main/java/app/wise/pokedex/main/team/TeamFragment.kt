package app.wise.pokedex.main.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import app.wise.pokedex.R
import app.wise.pokedex.databinding.FragmentFavoritesBinding
import app.wise.pokedex.databinding.FragmentTeamBinding
import app.wise.pokedex.main.favorites.FavoritesViewModel


class TeamFragment : Fragment() {
    private lateinit var binding: FragmentTeamBinding
    private val viewModel: TeamViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
        return binding.root
    }

}