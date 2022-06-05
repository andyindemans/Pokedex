package app.wise.pokedex.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import app.wise.pokedex.R
import app.wise.pokedex.databinding.FragmentHomeBinding
import app.wise.pokedex.main.MainActivity
import app.wise.pokedex.main.favorites.FavoritesFragment
import app.wise.pokedex.main.team.TeamFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        val activity = requireActivity() as MainActivity

        binding.favoritesCard.setOnClickListener{activity.loadFragment(FavoritesFragment())}

        binding.myTeamCard.setOnClickListener { activity.loadFragment(TeamFragment()) }
        return binding.root
    }

}