package com.desafiocoodesh.dictionary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.desafiocoodesh.dictionary.model.ListModel
import com.desafiocoodesh.dictionary.view.viewholder.repository.WordRepository

class HomeViewModel(application: Application) : AndroidViewModel (application) {

    private val repository = WordRepository.getInstance(application)

    private val wordsModel = MutableLiveData<ListModel>()
    val list: LiveData<ListModel> = wordsModel

    private val _saveWord = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveWord

    fun save(word: ListModel){
        if (word.id == 0){
            if (repository.insert(word)){
                _saveWord.value = "Inserçao com sucesso"
            } else {
                _saveWord.value = "Falha"
            }
        } else {
            if (repository.update(word)){
                _saveWord.value = "Atualizaçao com sucesso"
            } else {
                _saveWord.value = "Falha"
            }
        }

    }



}