package com.example.taller_4_pdm.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taller_4_pdm.R
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import kotlinx.android.synthetic.main.fragment_content.view.*

class ContentFragment : Fragment() {

    var book = BookEntity()

    companion object{
        fun newInstance(book: BookEntity):ContentFragment{
            val newFragment = ContentFragment()
            newFragment.book = book
            return newFragment
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_content, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View){
        view.tv_title_book_activity
        view.tv_autores
        view.tv_caratula
        view.tv_edicion
        view.tv_editoriales
        view.tv_isbn
        view.tv_resumen
        view.tv_tag
    }


}
