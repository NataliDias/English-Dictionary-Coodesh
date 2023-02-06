package com.desafiocoodesh.dictionary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.desafiocoodesh.dictionary.model.ListModel
import com.desafiocoodesh.dictionary.view.viewholder.repository.WordRepository

class WordsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository =
        WordRepository.getInstance(application.applicationContext)

    private val listAllWords = MutableLiveData<List<ListModel>>()
    val words: LiveData<List<ListModel>> = listAllWords

    fun getAll(){
        listAllWords.value = repository.getAll()
    }

    fun delete(id: Int){
        repository.delete(id)
    }

//    fun update(id: Int){
//        repository.update()
//    }

    fun getFavorites(){
        listAllWords.value = repository.getFavorites()
    }

}