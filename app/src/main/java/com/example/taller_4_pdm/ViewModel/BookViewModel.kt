package com.example.taller_4_pdm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller_4_pdm.Repository.BookRepository
import com.example.taller_4_pdm.RoomDataBase.Entities.AuthorEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.EditorialEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.TagEntity
import com.example.taller_4_pdm.RoomDataBase.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application){
    private val repository : BookRepository

    init {
        val booksDao = RoomDB.getInstance(application,viewModelScope).bookDao()
        val authorsDao = RoomDB.getInstance(application,viewModelScope).authorDao()
        val editorialsDao = RoomDB.getInstance(application,viewModelScope).editorialDao()
        val tagsDao = RoomDB.getInstance(application,viewModelScope).tagDao()
        repository = BookRepository(booksDao,authorsDao,editorialsDao,tagsDao)


    }

    //Funciones obtener todos

    fun allBooks() = repository.allBooks()
    fun allAuthors() = repository.allAuthors()
    fun allEditorials() = repository.allEditorials()
    fun allTags() = repository.allTags()

    //Funciones obtener por id

    fun getAuthorById(id: Long) = repository.getAuthorById(id)
    fun getTagById(id: Long) = repository.getTagById(id)
    fun getEditorialById(id: Long) = repository.getEditorialById(id)


    //Funciones de Book

    fun addToFavorites(id: Long) = repository.addToFavorites(id)
    fun removeFromFavorites(id: Long) = repository.removeFromFavorites(id)
    fun nuke() = repository.nuke()
    fun getBookById(id: Long) = repository.getBookById(id)
    fun getBookByName(name: String) = repository.getBookByName(name)
    fun getBookByEditorial(editorial: String) = repository.getBookByEditorial(editorial)
    fun getBookByEdicion(edicion: Int) = repository.getBookByEdicion(edicion)
    fun getBookByISBN(isbn: String) = repository.getBookByISBN(isbn)
    fun getFavoBooks(fav: Int) = repository.getFavoBooks(fav)

    // Funciones de insertar

    fun insertBook(book : BookEntity) = viewModelScope.launch ( Dispatchers.IO ){
        repository.insertBook(book)
    }

    fun insertAuthor(author : AuthorEntity) = viewModelScope.launch (Dispatchers.IO){
        repository.insertAutor(author)
    }

    fun insertEditorial( editorial : EditorialEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.insertEditorial(editorial)
    }

    fun insertTag(tag : TagEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.insertTag(tag)
    }


}