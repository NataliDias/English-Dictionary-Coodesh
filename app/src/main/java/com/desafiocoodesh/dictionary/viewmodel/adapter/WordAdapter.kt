package com.desafiocoodesh.dictionary.viewmodel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dictionarycoodesh.databinding.ItemWordBinding
import com.desafiocoodesh.dictionary.model.ListModel
import com.desafiocoodesh.dictionary.view.viewholder.WordViewHolder
import com.desafiocoodesh.dictionary.view.listener.OnWordsListener


class WordAdapter : RecyclerView.Adapter<WordViewHolder>() {
    private var wordslist: List<ListModel> = listOf()
    private lateinit var listener: OnWordsListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val item = ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordslist[position])
    }

    override fun getItemCount(): Int {
        return wordslist.count()
    }

    fun updatedWord(list: List<ListModel>){
        wordslist = list
        notifyDataSetChanged()
    }

    fun attachListener(wordsListener: OnWordsListener){
        listener = wordsListener
    }
}