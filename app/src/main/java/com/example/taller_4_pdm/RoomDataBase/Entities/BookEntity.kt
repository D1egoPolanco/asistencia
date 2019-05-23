package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BookTable")
data class BookEntity (
    //val id_author_book : Long,

    @ColumnInfo(name = "b_caratula")
    val Caratula: String = "N/A",
    @ColumnInfo(name = "b_titulo")
    val Titulo: String = "N/A",
    @ColumnInfo(name = "b_autores")
    val Autores: String = "N/A",
    @ColumnInfo(name = "b_edicion")
    val Edicion: Int = 0,
    @ColumnInfo(name = "b_editorial")
    val Editorial: String = "N/A",
    @ColumnInfo(name = "b_isbn")
    val ISBN: String = "N/A",
    @ColumnInfo(name = "b_resumen")
    val Resumen: String = "N/A",
    @ColumnInfo(name = "b_tags")
    val Tag: String = "N/A",
    @ColumnInfo(name = "b_favorito")
    val Favorito: Boolean = false
)
{
    @PrimaryKey(autoGenerate = true)
    var id_book : Long = 0
}