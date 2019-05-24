package com.example.taller_4_pdm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
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
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_book.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var id = p0.itemId
        when(id){
            R.id.nav_1 ->{
                bookViewModel.allBooks().observe(this, Observer {
                    viewAdapter.dataChange(it)
                })
                return true
            }
            R.id.nav_2 ->{
                bookViewModel.getFavoBooks(1).observe(this, Observer {
                    viewAdapter.dataChange(it)
                })
                return true
            }
            else->{
                return false
            }
        }
    }

    private lateinit var bookViewModel: BookViewModel
    var twoPane = false
    private lateinit var viewAdapter: BookAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mainContentFragment: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(fragment_content != null){
            twoPane = true
            mainContentFragment = ContentFragment.newInstance(BookEntity())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, ContentFragment()).commit()
        }else{
            twoPane = false
        }

       fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewBookActivity::class.java)
            startActivity(intent)
        }

        nav_view.setNavigationItemSelectedListener(this)

        initRecycle(emptyList())



       bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        bookViewModel.allBooks().observe(this, Observer {
            viewAdapter.dataChange(it)
        })
    }

    fun initRecycle(books : List<BookEntity>){
        viewManager = LinearLayoutManager(this)


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
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content,mainContentFragment).commit()
                Log.d("Click", "Esta haciendo click en: "+ item.Titulo)
        }else{
            val extras = Bundle()
            extras.putString(Constants.TEXT_KEY_TITULO,item.Titulo)
            startActivity(Intent(this, Activity_Book::class.java).putExtras(extras))
            Log.d("Book: ", item.Titulo)
        }
    }
}
