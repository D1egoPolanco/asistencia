package com.example.taller_4_pdm.RoomDataBase.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4_pdm.RoomDataBase.Entities.TagEntity

@Dao
interface TagDao {

    @Query("SELECT * FROM tagtable")
    fun getAll() : LiveData<List<TagEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(table : TagEntity)

    @Query("SELECT * FROM tagtable WHERE id_tag = :id")
    fun getById(id : Long) : LiveData<TagEntity>
}