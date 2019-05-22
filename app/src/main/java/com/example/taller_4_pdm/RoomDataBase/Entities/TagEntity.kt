package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TagTable")
data class TagEntity (
    @ColumnInfo(name = "c_name")
    val name : String
){
    @PrimaryKey(autoGenerate = true)
    val id_tag : Long = 0
}