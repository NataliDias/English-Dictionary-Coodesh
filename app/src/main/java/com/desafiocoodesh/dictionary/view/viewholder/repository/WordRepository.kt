package com.desafiocoodesh.dictionary.view.viewholder.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.desafiocoodesh.dictionary.constants.DataBaseConstants
import com.desafiocoodesh.dictionary.model.ListModel
import com.desafiocoodesh.dictionary.view.viewholder.repository.helper.WordDataBase

class WordRepository private constructor(context: Context) {

    private val guestDataBase = WordDataBase(context)

    //Singleton
    companion object {
        private lateinit var repository: WordRepository

        fun getInstance(context: Context): WordRepository {
            if (!Companion::repository.isInitialized) {
                repository = WordRepository(context)
            }
            return repository
        }
    }

    fun insert(word: ListModel): Boolean {
        return try {
            val db = guestDataBase.writableDatabase

            val presence = if (word.favorites) 0 else 1
            val values = ContentValues()
            values.put(DataBaseConstants.WORD.COLUMNS.FAVORITES, presence)
            values.put(DataBaseConstants.WORD.COLUMNS.WORDS, word.word)

            db.insert(DataBaseConstants.WORD.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(word: ListModel): Boolean {
        return try {
            val db = guestDataBase.writableDatabase
            val presence = if (word.favorites) 0 else 1
            val values = ContentValues()
            values.put(DataBaseConstants.WORD.COLUMNS.WORDS, word.word)
            values.put(DataBaseConstants.WORD.COLUMNS.FAVORITES, presence)

            val selection = DataBaseConstants.WORD.COLUMNS.ID + "= ?"
            val args = arrayOf(word.id.toString())

            db.update(DataBaseConstants.WORD.TABLE_NAME, values, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun favorites(id: Int): Boolean {
        return try {
            val db = guestDataBase.writableDatabase

            val selection = DataBaseConstants.WORD.COLUMNS.ID + "= ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.WORD.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }


    }

    fun delete(id: Int): Boolean {
        return try {
            val db = guestDataBase.writableDatabase

            val selection = DataBaseConstants.WORD.COLUMNS.ID + "= ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.WORD.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }


    }


    @SuppressLint("Range")
    fun getFavorites(): List<ListModel> {

        val list = mutableListOf<ListModel>()
        try {
            val db = guestDataBase.readableDatabase

            val cursor = db.rawQuery("SELECT id, words, favorites FROM Word WHERE favorites = 1", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.WORD.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.WORD.COLUMNS.WORDS))
                    val favorites =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.WORD.COLUMNS.FAVORITES))


                    list.add(ListModel(id, name, favorites == 1))


                }
            }

            cursor.close()

        }catch (e: Exception){
            return list
        }
            return list
    }


    @SuppressLint("Range")
    fun getAll(): List<ListModel> {

        val list = mutableListOf<ListModel>()
        try {
            val db = guestDataBase.readableDatabase

            val selection = arrayOf(
                DataBaseConstants.WORD.COLUMNS.ID,
                DataBaseConstants.WORD.COLUMNS.WORDS,
                DataBaseConstants.WORD.COLUMNS.FAVORITES
            )

            val cursor = db.query(
                DataBaseConstants.WORD.TABLE_NAME, selection,
                null, null,
                null, null, null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.WORD.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.WORD.COLUMNS.WORDS))
                    val favorites =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.WORD.COLUMNS.FAVORITES))


                    list.add(ListModel(id, name, favorites == 1))


                }
            }


            cursor.close()

        }catch (e: Exception){
            return list
        }
        return list
    }

}
