package com.example.taller_4_pdm.RoomDataBase.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.taller_4_pdm.RoomDataBase.Entities.AuthorEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity

@Dao
interface AuthorxBookDao {
    @Insert
    suspend fun insert(aXb : AuthorxBookDao)

    @Query("SELECT * FROM authortable AS a INNER JOIN author_book_join AS abj ON a.id_author = abj.FK_author_id WHERE abj.FK_book_id = :bookID ")
    fun getAuthorsPerBookByID(bookID : Long) : LiveData<List<AuthorEntity>>

    @Query("SELECT * FROM booktable AS b INNER JOIN author_book_join AS abj ON b.id_book = abj.FK_book_id WHERE abj.FK_author_id = :authorID ")
    fun getBooksPerAuthorByID(authorID : Long) : LiveData<List<BookEntity>>
}