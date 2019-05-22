package com.example.taller_4_pdm.RoomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taller_4_pdm.RoomDataBase.Daos.AuthorDao
import com.example.taller_4_pdm.RoomDataBase.Daos.BookDao
import com.example.taller_4_pdm.RoomDataBase.Daos.EditorialDao
import com.example.taller_4_pdm.RoomDataBase.Daos.TagDao

@Database(entities = [AuthorDao::class,BookDao::class,EditorialDao::class,TagDao::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase(){

    abstract fun bookDao() : BookDao

    companion object {
        //para notificar a todos los hilos
        @Volatile
        private var INSTANCE : RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Book_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}