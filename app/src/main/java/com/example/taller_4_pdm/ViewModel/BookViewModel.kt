package com.example.taller_4_pdm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller_4_pdm.Repository.BookRepository
import com.example.taller_4_pdm.RoomDataBase.Entities.AuthorEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.RoomDataBase.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application){
    private val repository : BookRepository
    val allBooks: LiveData<List<BookEntity>>

    init {
        val booksDao = RoomDB.getInstance(application,viewModelScope).bookDao()
        val authorsDao = RoomDB.getInstance(application,viewModelScope).authorDao()
        val editorialsDao = RoomDB.getInstance(application,viewModelScope).editorialDao()
        val tagsDao = RoomDB.getInstance(application,viewModelScope).tagDao()
        repository = BookRepository(booksDao,authorsDao,editorialsDao,tagsDao)
        allBooks = repository.allBooks

    }

    fun insertAutor(authorEntity: AuthorEntity){
        viewModelScope.launch ( Dispatchers.IO){
            repository.insertAutor(authorEntity)
        }
    }



}