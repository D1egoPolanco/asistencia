package com.example.taller_4_pdm.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
//import androidx.lifecycle.LiveData
//import com.example.taller_4_pdm.Models.Author
//import com.example.taller_4_pdm.Models.Book
import com.example.taller_4_pdm.RoomDataBase.Daos.AuthorDao
import com.example.taller_4_pdm.RoomDataBase.Daos.BookDao
import com.example.taller_4_pdm.RoomDataBase.Daos.EditorialDao
import com.example.taller_4_pdm.RoomDataBase.Daos.TagDao
import com.example.taller_4_pdm.RoomDataBase.Entities.AuthorEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.EditorialEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.TagEntity


class BookRepository  (private val bookDao:BookDao, private val authorDao: AuthorDao,
                       private val editorialDao:EditorialDao, private val tagsDao: TagDao){


    val allBooks: LiveData<List<BookEntity>> = bookDao.getAll()

    @WorkerThread
    suspend fun insertBook(bookEntity: BookEntity){
        bookDao.insert(bookEntity)
    }

    @WorkerThread
    suspend fun insertAutor(authorEntity: AuthorEntity){
        authorDao.insert(authorEntity)
    }

    @WorkerThread
    suspend fun insertEditorial(editorialEntity: EditorialEntity){
        editorialDao.insert(editorialEntity)
    }

  /* @WorkerThread
   suspend fun insertTag (tagEntity: TagEntity){
       editorialDao.insert(tagEntity)
   }
*/
    }





