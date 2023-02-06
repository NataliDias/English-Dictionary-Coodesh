package com.desafiocoodesh.dictionary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.desafiocoodesh.dictionary.model.ListModel
import com.desafiocoodesh.dictionary.view.viewholder.repository.WordRepository

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = WordRepository.getInstance(application)

    private val wordsModel = MutableLiveData<ListModel>()
    val listFavorites: LiveData<ListModel> = wordsModel

    private val _saveFavorites = MutableLiveData<String>()
    val saveFavorites: LiveData<String> = _saveFavorites



    fun save(word: ListModel){
        if (word.id == 0){
            if (repository.update(word)){
                _saveFavorites.value = "Atualizaçao com sucesso"
            } else {
                _saveFavorites.value = "Falha"
            }

        } else {
//            if (repository.insert(word)){
//                _saveFavorite.value = "Inserçao com sucesso"
//            } else {
//                _saveFavorite.value = "Falha"
//            }
        }

    }



}