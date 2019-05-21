package com.example.taller_4_pdm.Models

import android.os.Parcel
import android.os.Parcelable
//Falta Modificar
data class Book(
    val Caratula: String = "N/A",
    val Titulo: String = "N/A",
    val Autores: ArrayList<Author>? = null ,
    val Edicion: Int = 0,
    val Editorial: String = "N/A",
    val ISBN: String = "N/A",
    val Resumen: String = "N/A",
    val Tag: ArrayList<String>? = null,
    val Favorito: Boolean = false
): Parcelable {
    constructor(parcel : Parcel):this(
            Caratula = parcel.readString(),
            Titulo = parcel.readString(),
            Autores = parcel.readArrayList(Book.javaClass.classLoader) as ArrayList<Author>?,
            Edicion = parcel.readInt(),
            Editorial = parcel.readString(),
            ISBN = parcel.readString(),
            Resumen = parcel.readString(),
            Tag = parcel.readArrayList(Book.javaClass.classLoader) as ArrayList<String>?,
            Favorito = parcel.readByte() != 0.toByte()
    )
    //Falta modificar
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Caratula)
        parcel.writeString(Titulo)
        parcel.writeArray(arrayOf(Autores))
        parcel.writeInt(Edicion)
        parcel.writeString(Editorial)
        parcel.writeString(ISBN)
        parcel.writeString(Resumen)
        parcel.writeArray(arrayOf(Tag))
        parcel.writeByte(if (Favorito) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

}