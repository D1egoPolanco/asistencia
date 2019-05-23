package com.example.taller_4_pdm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taller_4_pdm.Adapters.BookAdapter
import com.example.taller_4_pdm.Models.Book
import com.example.taller_4_pdm.R
import com.example.taller_4_pdm.Utils.Constants
import com.example.taller_4_pdm.ViewModel.BookViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.coin_list)
        val adapter = BookAdapter(listOf<Book>()){
            startActivity(Intent(this, Activity_Book::class.java).putExtra(Constants.TEXT_KEY_CARATULA,it.Caratula)
                .putExtra(Constants.TEXT_KEY_AUTORES,it.Autores as Array<out String>)
                .putExtra(Constants.TEXT_KEY_EDICION,it.Edicion)
                .putExtra(Constants.TEXT_KEY_EDITORIAL,it.Editorial)
                .putExtra(Constants.TEXT_KEY_FAVORITE,it.Favorito)
                .putExtra(Constants.TEXT_KEY_ISBN,it.ISBN)
                .putExtra(Constants.TEXT_KEY_RESUMEN,it.Resumen)
                .putExtra(Constants.TEXT_KEY_TAG,it.Tag as Array<out String>)
                .putExtra(Constants.TEXT_KEY_TITULO,it.Titulo)

                )
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        bookViewModel.allBooks.observe(this, Observer { words ->

        })

    }
}
