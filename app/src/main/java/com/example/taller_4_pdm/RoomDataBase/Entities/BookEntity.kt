package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.taller_4_pdm.Models.Author
import java.security.PrivateKey

@Entity(tableName = "BookTable")
data class BookEntity (
    //val id_author_book : Long,

    @ColumnInfo(name = "b_caratula")
    val Caratula: String,
    @ColumnInfo(name = "b_titulo")
    val Titulo: String,
    @ColumnInfo(name = "b_autores")
    val Autores: String,
    @ColumnInfo(name = "b_edicion")
    val Edicion: Int,
    @ColumnInfo(name = "b_editorial")
    val Editorial: String,
    @ColumnInfo(name = "b_isbn")
    val ISBN: String,
    @ColumnInfo(name = "b_resumen")
    val Resumen: String,
    @ColumnInfo(name = "b_tags")
    val Tag: String,
    @ColumnInfo(name = "b_favorito")
    val Favorito: Boolean
)
{
    @PrimaryKey(autoGenerate = true)
    var id_book : Long = 0
}