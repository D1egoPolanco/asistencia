package com.example.taller_4_pdm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taller_4_pdm.Adapters.BookAdapter
import com.example.taller_4_pdm.Fragments.ContentFragment
import com.example.taller_4_pdm.R
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.Utils.Constants
import com.example.taller_4_pdm.ViewModel.BookViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    var twoPane = false
    private lateinit var viewAdapter: BookAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mainContentFragment: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        val floatingButton = findViewById<FloatingActionButton>(R.id.fab)
        floatingButton.setOnClickListener {
            val intent = Intent(this@MainActivity, NewBookActivity::class.java)
            startActivity(intent)
        }

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)


        bookViewModel.allBooks.observe(this, Observer {result ->
            viewAdapter.dataChange(result)
        })

    }

    fun initRecycle(books : List<BookEntity>){
        if(twoPane){
            viewManager = LinearLayoutManager(this)
        }else{
            viewManager = GridLayoutManager(this, 2)
        }

        viewAdapter = BookAdapter(books,{ bookitem: BookEntity-> bookItemClicked(bookitem)})

        book_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun bookItemClicked(item: BookEntity){
        if(twoPane){
            mainContentFragment = ContentFragment.newInstance(item)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, ContentFragment()).commit()
        }else{
            val it = Bundle()
            it.putString(Constants.TEXT_KEY_CARATULA, item.Caratula)
            it.putString(Constants.TEXT_KEY_TITULO, item.Titulo)
            it.putString(Constants.TEXT_KEY_AUTORES, item.Autores.toString())
            it.putString(Constants.TEXT_KEY_RESUMEN, item.Resumen)
            it.putString(Constants.TEXT_KEY_EDITORIAL, item.Editorial)
            it.putString(Constants.TEXT_KEY_EDITORIAL, item.ISBN)
            it.putInt(Constants.TEXT_KEY_EDICION, item.Edicion)
            it.putString(Constants.TEXT_KEY_TAG, item.Tag.toString())
            it.putBoolean(Constants.TEXT_KEY_FAVORITE, item.Favorito)

            startActivity(Intent(this, Activity_Book::class.java).putExtras(it))
            bookViewModel.allBooks.value
        }
    }
}
