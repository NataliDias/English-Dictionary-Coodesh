package com.desafiocoodesh.dictionary.constants

class DataBaseConstants private constructor(){

    object WORD {

        const val ID = "wordid"
        const val TABLE_NAME = "Word"

        object COLUMNS {
            const val ID = "id"
            const val WORDS = "words"
            const val FAVORITES = "favorites"
        }


    }

}