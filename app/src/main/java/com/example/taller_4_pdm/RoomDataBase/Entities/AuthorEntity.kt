package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.taller_4_pdm.Models.Book
@Entity(tableName = "AuthorTable")
data class AuthorEntity (
    @PrimaryKey(autoGenerate = true) val id_author : Long,

    @ColumnInfo(name = "a_name")
    val name:String,
    @ColumnInfo(name = "a_books_written")
    val books_written: ArrayList<Book>
)
/*
@Entity
    (foreignKeys = arrayOf(
    ForeignKey(entity = AuthorEntity::class,
    parentColumns = arrayOf("id_author"),
    childColumns = arrayOf("id_author_book")
)))*/

