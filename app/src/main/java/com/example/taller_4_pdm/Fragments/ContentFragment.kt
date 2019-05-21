package com.example.taller_4_pdm.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taller_4_pdm.Models.Book
import com.example.taller_4_pdm.R
import kotlinx.android.synthetic.main.fragment_content.view.*

class ContentFragment : Fragment() {

    var book = Book()
    private var listener: OnFragmentInteractionListener? = null

    companion object{
        fun newInstance(book: Book):ContentFragment{
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

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

}
