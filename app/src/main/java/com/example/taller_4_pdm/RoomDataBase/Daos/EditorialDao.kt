package com.example.taller_4_pdm.RoomDataBase.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4_pdm.RoomDataBase.Entities.EditorialEntity

@Dao
interface EditorialDao {

    @Query("SELECT * FROM editorialtable")
    fun getAll() : LiveData<List<EditorialEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(table : EditorialEntity)

    @Query("SELECT * FROM editorialtable WHERE id_editorial = :id")
    fun getById(id : Long) : LiveData<EditorialEntity>
}