package com.example.taller_4_pdm.Activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.taller_4_pdm.Fragments.ContentFragment
import com.example.taller_4_pdm.R
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.Utils.Constants
import com.example.taller_4_pdm.ViewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_book.*
import kotlinx.android.synthetic.main.content_main.*

class Activity_Book : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    var twoPane = false
    private lateinit var mainContentFragment: ContentFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        if (fragment_content != null) {
            twoPane = true
            mainContentFragment = ContentFragment.newInstance(BookEntity())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, mainContentFragment).commit()
        }else{
            twoPane = false
        }
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        val intento = intent
        if(intento != null){

            bookViewModel.getBookByName(intento.getStringExtra(Constants.TEXT_KEY_TITULO)).observe(this, Observer {book ->
                tv_caratula.text = book.Caratula
                tv_title_book_activity.text = book.Titulo
                tv_autores.text = book.Autores
                tv_edicion.text = book.Edicion.toString()
                tv_editoriales.text = book.Editorial
                tv_isbn.text = book.ISBN
                tv_resumen.text = book.Resumen
                tv_tag.text = book.Tag
                if(book.Favorito == 0){
                    bt_agregar_favorito.visibility = View.VISIBLE
                    bt_agregar_favorito.setOnClickListener {
                        bt_borrar_favorito.visibility = View.VISIBLE
                        bt_agregar_favorito.visibility = View.INVISIBLE
                        book.Favorito = 1
                        bookViewModel.insertBook(book)
                    }
                }else{
                    bt_borrar_favorito.visibility = View.VISIBLE
                    bt_borrar_favorito.setOnClickListener {
                        bt_borrar_favorito.visibility = View.INVISIBLE
                        bt_agregar_favorito.visibility = View.VISIBLE
                        book.Favorito = 0
                        bookViewModel.insertBook(book)
                    }
                }
            })

        }
    }


}