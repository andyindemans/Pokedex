package app.wise.pokedex.main.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import app.wise.pokedex.databinding.FragmentDetailBinding
import app.wise.pokedex.main.MainActivity
import com.bumptech.glide.Glide


class DetailFragment(private val pokemonId: Int) : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels{
        DetailViewModelFactory(pokemonId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        val activity = requireActivity() as MainActivity

        binding.detailBackButton.setOnClickListener{
            activity.onBackPressed()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pokemon.observe(viewLifecycleOwner){
            Glide.with(binding.root).load(it.sprites?.front_default).into(binding.pokemonDetailImage)
        }

    }

}