package com.desafiocoodesh.dictionary.view.ui.search

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafiocoodesh.dictionary.model.Definition
import com.dictionarycoodesh.databinding.FragmentSearchBinding

import com.desafiocoodesh.dictionary.model.ListModel
import com.desafiocoodesh.dictionary.view.viewholder.repository.remote.RetrofitInstance
import com.desafiocoodesh.dictionary.viewmodel.GalleryViewModel
import com.desafiocoodesh.dictionary.viewmodel.adapter.WordAdapter
import com.desafiocoodesh.dictionary.view.listener.OnWordsListener
import com.desafiocoodesh.dictionary.viewmodel.HomeViewModel
import com.desafiocoodesh.dictionary.viewmodel.WordsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var word: String
    private lateinit var adapter: WordAdapter
    private lateinit var mediaPlayer: MediaPlayer
    private var listId = 0
    lateinit var nome: String
    lateinit var phonetics: String
    lateinit var model: ListModel
    lateinit var modell: ListModel
     var favorites: Boolean = true


    private val viewModel: HomeViewModel by lazy {
        HomeViewModel(requireActivity().application)
    }

    private val viewModelWords: WordsViewModel by lazy {
        WordsViewModel(requireActivity().application)
    }

    private val viewModelFavorites: GalleryViewModel by lazy {
        GalleryViewModel(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnSearch.setOnClickListener {
            word = binding.searchWord.text.toString()
            searchWord(word)
        }

        adapter = WordAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        observe()


        val listener = object : OnWordsListener {
            override fun onClick(id: Int) {

            }


            override fun onDelete(id: Int) {
                viewModelWords.delete(id)
                viewModelWords.getAll()
            }



        }
        adapter.attachListener(listener)
        viewModelWords.getAll()

        return root
    }
    private fun playAudio(audioUrl: String) {
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(audioUrl)
        mediaPlayer.prepare()
        mediaPlayer.start()
    }




    private fun searchWord(word: String) {
        val api = RetrofitInstance.getRetrofitInstance()
        val call = api.getDefinition(word)
        call.enqueue(object : Callback<List<Definition>> {
            override fun onResponse(
                call: Call<List<Definition>>,
                response: Response<List<Definition>>
            ) {
                if (response.isSuccessful) {
                    val definitions = response.body()!!
                    for (definition in definitions) {
                        binding.wordTextView.text = definition.word
                        for (meaning in definition.meanings) {
                            if (meaning.partOfSpeech == "noun") {
                                var noun = meaning.definitions[0].definition
                                binding.nounTextView.text = "Noun: $noun"
                            } else if (meaning.partOfSpeech == "verb") {
                                var verb = meaning.definitions[0].definition
                                binding.verbTextView.text = "Verb: $verb"
                            }
                        }

                        if (definition.phonetics.isNotEmpty()) {

                            val audioUrl = definition.phonetics[0].audio
                            val phonetics = definition.phonetics[0].text

                            binding.btnAudio.setOnClickListener {
                                if (audioUrl != null) {
                                    try {
                                        playAudio(audioUrl)
                                        binding.view.setBackgroundColor(Color.parseColor("#1D42FA"))
                                    } catch (e: Exception) {
                                        val toast = Toast.makeText(activity,"Audio URL is null, cannot play audio.", Toast.LENGTH_SHORT)
                                        toast.show()
                                    }
                                } else {
                                    val toast = Toast.makeText(activity,"O URL do áudio é nulo, não é possível reproduzir o áudio.", Toast.LENGTH_SHORT)
                                    toast.show()
                                }
                                binding.view.setBackgroundColor(Color.parseColor("#BAB8B8"))
                            }


                                binding.phonectsTextView.text = "Phonetc: $phonetics"


                        }



                         nome = definition.word
                         model = ListModel(listId ,nome, favorites)



                    }


                    viewModel.save(model)
                    viewModelWords.getAll()


                    binding.cardView.visibility = View.VISIBLE
                    adapter.notifyDataSetChanged()
                   // wordList.add(word)

                //Tratamento de erro
                }else{
                    val toast = Toast.makeText(activity,"Palavra não encontrada!", Toast.LENGTH_SHORT)
                    toast.show()
                    binding.cardView.visibility = View.GONE
                }

            }
            override fun onFailure(call: Call<List<Definition>>, t: Throwable) {

                Log.e("Retrofit", "Error", t)

            }
        })
    }

    fun favoritar(){
//        binding.imageView2.setOnClickListener {
//            binding.imageView2.setImageResource(android.R.drawable.btn_star_big_on)
//            viewModelFavorite.save(model)
//        }
    }

    private fun observe(){
        viewModelWords.words.observe(viewLifecycleOwner) {
            adapter.updatedWord(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
     //   mediaPlayer.pause()
    }

    override fun onPause() {
        super.onPause()
        viewModelWords.getAll()
//        mediaPlayer.release()
    }
}