package com.desafiocoodesh.dictionary.view.viewholder

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.dictionarycoodesh.databinding.ItemWordBinding
import com.desafiocoodesh.dictionary.model.ListModel
import com.desafiocoodesh.dictionary.view.listener.OnWordsListener

class WordViewHolder(var bind: ItemWordBinding, private val listener: OnWordsListener) : RecyclerView.ViewHolder(bind.root) {

    fun bind(list: ListModel){
        if (list.favorites) {
           bind.imageView3.setImageResource(android.R.drawable.btn_star_big_on)
        } else {
            bind.imageView3.setImageResource(android.R.drawable.btn_star_big_off)
        }

        bind.textView2.text = list.word.toString()

        bind.buttonRemove.setOnClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Deletando palavra")
                .setMessage("Tem certeza da remoçao?")
                .setPositiveButton("Sim") { dialog, which -> listener.onDelete(list.id) }
                .setNegativeButton("Não", null)
                .create()
                .show()


            true
        }

        bind.imageView3.setOnClickListener {
            if (list.favorites == true) {
                bind.imageView3.setImageResource(android.R.drawable.btn_star_big_off)


            } else {
                bind.imageView3.setImageResource(android.R.drawable.btn_star_big_on)


            }



        }

    }
}