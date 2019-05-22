package com.example.taller_4_pdm.RoomDataBase.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4_pdm.RoomDataBase.Entities.AuthorEntity

@Dao
interface AuthorDao {

    @Query("SELECT * FROM authortable")
    fun getAll() : LiveData<List<AuthorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(table : AuthorEntity)

    @Query("SELECT * FROM authortable WHERE id_author = :id")
    fun getById(id : Long) : LiveData<AuthorEntity>
}