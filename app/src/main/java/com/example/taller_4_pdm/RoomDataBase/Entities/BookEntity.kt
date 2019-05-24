package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BookTable")
data class BookEntity (
    //val id_author_book : Long,

    @ColumnInfo(name = "b_caratula")
    var Caratula: String = "N/A",
    @ColumnInfo(name = "b_titulo")
    var Titulo: String = "N/A",
    @ColumnInfo(name = "b_autores")
    var Autores: String = "N/A",
    @ColumnInfo(name = "b_edicion")
    var Edicion: Int = 0,
    @ColumnInfo(name = "b_editorial")
    var Editorial: String = "N/A",
    @ColumnInfo(name = "b_isbn")
    var ISBN: String = "N/A",
    @ColumnInfo(name = "b_resumen")
    var Resumen: String = "N/A",
    @ColumnInfo(name = "b_tags")
    var Tag: String = "N/A",
    @ColumnInfo(name = "b_favorito")
    var Favorito: Int = 0
)
{
    @PrimaryKey(autoGenerate = true)
    var id_book : Long = 0
}