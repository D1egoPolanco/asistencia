package com.example.taller_4_pdm.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.taller_4_pdm.R
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.ViewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_new_book.*

class NewBookActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var book : BookEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        bt_agregar.setOnClickListener {
            book = BookEntity("N/A",
                et_titulo.text.toString(),
                et_autores.text.toString(),
                et_edicion.text.toString().toInt(),
                et_editorial.text.toString(),
                et_isbn.text.toString(),
                et_resumen.text.toString(),
                "N/A",
                0
            )

            bookViewModel.insertBook(book)

        }


    }
}
