package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "author_book_join",
    foreignKeys = [
        ForeignKey(entity = AuthorEntity::class,
                parentColumns = arrayOf("id_author"),
            childColumns = arrayOf("FK_author_id")),
        ForeignKey(entity = BookEntity::class,
                parentColumns = arrayOf("id_book"),
            childColumns = arrayOf("FK_book_id"))
        ])
data class AuthorxBook (
    var FK_author_id : Long,
    var FK_book_id : Long
)