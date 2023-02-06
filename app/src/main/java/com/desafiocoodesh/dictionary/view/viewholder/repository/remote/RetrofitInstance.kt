package com.desafiocoodesh.dictionary.view.viewholder.repository.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private const val BASE_URL = "https://api.dictionaryapi.dev/"

        fun getRetrofitInstance(): DictionaryAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DictionaryAPI::class.java)
        }
    }
}