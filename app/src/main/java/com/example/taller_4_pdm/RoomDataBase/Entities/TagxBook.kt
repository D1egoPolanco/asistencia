package com.example.taller_4_pdm.RoomDataBase.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "tag_book_join",
    foreignKeys = [
        ForeignKey(entity = TagEntity::class,
            parentColumns = arrayOf("id_tag"),
            childColumns = arrayOf("FK_tag_id")),
        ForeignKey(entity = BookEntity::class,
            parentColumns = arrayOf("id_book"),
            childColumns = arrayOf("FK_book_id"))
    ])
data class TagxBook (
    var FK_tag_id : Long,
    var FK_book_id : Long
)