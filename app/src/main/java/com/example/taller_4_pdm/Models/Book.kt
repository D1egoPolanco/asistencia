package com.example.taller_4_pdm.Models

data class Book (
    val Caratula : String,
    val Titulo : String,
    val Autores : ArrayList<String>,
    val Edicion : Int,
    val Editorial : String,
    val ISBN: String,
    val Resumen : String,
    val Tag : ArrayList<String>,
    val Favorito : Boolean
)