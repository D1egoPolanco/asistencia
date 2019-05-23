package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EditorialTable")
data class EditorialEntity(
    @ColumnInfo(name = "e_name")
    val name : String,
    @ColumnInfo(name = "e_printed_books")
    val printed_books : String
)
{
    @PrimaryKey(autoGenerate = true)
    var id_editorial : Long = 0
}