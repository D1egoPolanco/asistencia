package com.example.taller_4_pdm.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taller_4_pdm.R
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import kotlinx.android.synthetic.main.book_cardview.view.*

class BookAdapter( var items : List<BookEntity>, val clickListener : (BookEntity) -> Unit) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.book_cardview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }


    fun dataChange(lista_books : List<BookEntity>){
        items = lista_books
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: BookEntity,clickListener: (BookEntity) -> Unit) = with(itemView) {
            tv_title_book.text = item.Titulo
            this.setOnClickListener{clickListener(item)}

        }
    }
}