package com.desafiocoodesh.dictionary.view.viewholder.repository.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.desafiocoodesh.dictionary.constants.DataBaseConstants

class WordDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

        companion object{
            private const val NAME = "worddb"
            private const val VERSION = 1
        }

    override fun onCreate(db: SQLiteDatabase) {
            db.execSQL("CREATE TABLE " + DataBaseConstants.WORD.TABLE_NAME + "(" +
                    DataBaseConstants.WORD.COLUMNS.ID +  " integer primary key autoincrement, " +
                    DataBaseConstants.WORD.COLUMNS.WORDS + " text, " +
                    DataBaseConstants.WORD.COLUMNS.FAVORITES + " integer);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

}