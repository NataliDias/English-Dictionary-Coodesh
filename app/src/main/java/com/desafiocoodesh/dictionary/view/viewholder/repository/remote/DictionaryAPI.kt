package com.desafiocoodesh.dictionary.view.viewholder.repository.remote

import com.desafiocoodesh.dictionary.model.Definition
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {
    @GET("api/v2/entries/en/{word}")
    fun getDefinition(@Path("word") word: String): Call<List<Definition>>
}