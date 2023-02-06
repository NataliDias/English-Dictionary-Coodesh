package com.desafiocoodesh.dictionary.view.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dictionarycoodesh.databinding.FragmentFavoritesBinding
import com.desafiocoodesh.dictionary.view.listener.OnWordsListener
import com.desafiocoodesh.dictionary.viewmodel.adapter.WordAdapter
import com.desafiocoodesh.dictionary.viewmodel.WordsViewModel
import com.desafiocoodesh.dictionary.viewmodel.HomeViewModel
import com.desafiocoodesh.dictionary.viewmodel.GalleryViewModel

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null

    private val binding get() = _binding!!


    private val adapter = WordAdapter()


    private val viewModel: HomeViewModel by lazy {
        HomeViewModel(requireActivity().application)
    }

    private val viewModelWords: WordsViewModel by lazy {
        WordsViewModel(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listener = object : OnWordsListener {
            override fun onClick(id: Int) {

            }

            // adicionando click do onlistener
            override fun onDelete(id: Int) {
                viewModelWords.delete(id)
                viewModelWords.getFavorites()
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        adapter.attachListener(listener)
        viewModelWords.getFavorites()
        observe()
        return root
    }

    override fun onResume(){
        super.onResume()
        viewModelWords.getFavorites()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe(){
        viewModelWords.words.observe(viewLifecycleOwner) {
            adapter.updatedWord(it)
        }
    }
}