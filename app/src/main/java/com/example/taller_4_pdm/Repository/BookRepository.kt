package com.example.taller_4_pdm.Repository

import androidx.lifecycle.LiveData
import com.example.taller_4_pdm.Models.Book
import com.example.taller_4_pdm.RoomDataBase.Daos.AuthorDao
import com.example.taller_4_pdm.RoomDataBase.Daos.BookDao
import com.example.taller_4_pdm.RoomDataBase.Daos.EditorialDao


class BookRepository  (private val bookDao:BookDao, private val autorDao:AuthorDao, private val editorialDao:EditorialDao, private val tagsDao: EditorialDao){





}