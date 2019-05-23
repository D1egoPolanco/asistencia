package com.example.taller_4_pdm.RoomDataBase.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.TagEntity

@Dao
interface TagxBookDao {
    @Insert
    suspend fun insert(tXb : TagxBookDao)

    @Query("SELECT * FROM tagtable AS t INNER JOIN tag_book_join AS abj ON t.id_tag = abj.FK_tag_id WHERE abj.FK_book_id = :bookID ")
    fun getTagsPerBookByID(bookID : Long) : LiveData<List<TagEntity>>

    @Query("SELECT * FROM booktable AS b INNER JOIN tag_book_join AS abj ON b.id_book = abj.FK_book_id WHERE abj.FK_tag_id = :tagID ")
    fun getBooksPerTagByID(tagID : Long) : LiveData<List<BookEntity>>
}