package com.example.taller_4_pdm.Activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.taller_4_pdm.R
import com.example.taller_4_pdm.Utils.Constants
import com.example.taller_4_pdm.ViewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_book.*

class Activity_Book : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        val intento = intent
        if(intento != null){

            //Log.d("Data", intento.getStringExtra(Constants.TEXT_KEY_TITULO))

            bookViewModel.getBookByName(intento.getStringExtra(Constants.TEXT_KEY_TITULO)).observe(this, Observer {
                tv_caratula.text = it.Caratula
                tv_title_book_activity.text = it.Titulo
                tv_autores.text = it.Autores
                tv_edicion.text = it.Edicion.toString()
                tv_editoriales.text = it.Editorial
                tv_isbn.text = it.ISBN
                tv_resumen.text = it.Resumen
                tv_tag.text = it.Tag
            })
            /*
            tv_caratula.text = intento.getStringExtra(Constants.TEXT_KEY_CARATULA)
            tv_title_book_activity.text = intento.getStringExtra(Constants.TEXT_KEY_TITULO)
            tv_autores.text = intento.getStringExtra(Constants.TEXT_KEY_AUTORES)
            tv_edicion.text = intento.getStringExtra(Constants.TEXT_KEY_EDICION)
            tv_editoriales.text = intento.getStringExtra(Constants.TEXT_KEY_EDITORIAL)
            tv_isbn.text = intento.getStringExtra(Constants.TEXT_KEY_ISBN)
            tv_resumen.text = intento.getStringExtra(Constants.TEXT_KEY_RESUMEN)
            tv_tag.text = intento.getStringExtra(Constants.TEXT_KEY_TAG)*/
        }
    }


}