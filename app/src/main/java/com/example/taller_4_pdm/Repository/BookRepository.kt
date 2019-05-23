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


    fun allBooks(): LiveData<List<BookEntity>> = bookDao.getAll()
    fun allAuthors(): LiveData<List<AuthorEntity>> = authorDao.getAll()
    fun allEditorials(): LiveData<List<EditorialEntity>> = editorialDao.getAll()
    fun allTags(): LiveData<List<TagEntity>> = tagsDao.getAll()


    fun getAuthorById(id: Long) = authorDao.getById(id)
    fun getTagById(id: Long) = tagsDao.getById(id)
    fun getEditorialById(id: Long) = editorialDao.getById(id)

    //Funciones de BookDao

    fun addToFavorites(id: Long) = bookDao.addToFavorites(id)
    fun removeFromFavorites(id: Long) = bookDao.removeFromFavorites(id)
    fun nuke() = bookDao.nuke()
    fun getBookById(id: Long) = bookDao.getByBookId(id)
    fun getBookByName(name: String) = bookDao.getByName(name)
    fun getBookByEditorial(editorial: String) = bookDao.getByEditoral(editorial)
    fun getBookByEdicion(edicion: Int) = bookDao.getByEdicion(edicion)
    fun getBookByISBN(isbn: String) = bookDao.getByISBN(isbn)
    fun getFavoBooks(fav: Boolean) = bookDao.getFavoritos(fav)


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

   @WorkerThread
   suspend fun insertTag (tagEntity: TagEntity){
       tagsDao.insert(tagEntity)
   }



 }





