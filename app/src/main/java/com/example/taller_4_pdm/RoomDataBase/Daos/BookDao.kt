package com.example.taller_4_pdm.RoomDataBase.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity

@Dao
interface BookDao {

    @Query("SELECT * FROM BookTable")
    fun getAll(): LiveData<List<BookEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(table : BookEntity)

    @Query("UPDATE booktable SET b_favorito = 1 WHERE id_book = :id")
    fun addToFavorites(id : Long)

    @Query("UPDATE booktable SET b_favorito = 0 WHERE id_book = :id")
    fun removeFromFavorites(id : Long)

    @Query("DELETE FROM booktable")
    fun nuke()

    @Query("SELECT * FROM BookTable WHERE id_book = :id")
    fun getByBookId(id : Long) : LiveData<BookEntity>
    @Query("SELECT * FROM BookTable WHERE b_titulo = :name")
    fun getByName(name: String) : LiveData<BookEntity>
    //@Query("SELECT * FROM Booktable WHERE b_autores = :autor")
    //fun getByAutor(autor : ArrayList<Author>)
    @Query("SELECT * FROM BookTable WHERE b_edicion = :edicion")
    fun getByEdicion(edicion : Int) : LiveData<List<BookEntity>>
    @Query("SELECT * FROM BookTable WHERE b_editorial = :editorial")
    fun getByEditoral(editorial : String) : LiveData<List<BookEntity>>
    @Query("SELECT * FROM BookTable WHERE b_isbn = :ISBN")
    fun getByISBN(ISBN : String) : LiveData<BookEntity>
    /*@Query("SELECT * FROM BookTable WHERE b_tags = :tag")
    fun getByTag(tag : ArrayList<String>){
        for(i in tag){
        }
    }*/
    @Query("SELECT * FROM BookTable WHERE b_favorito = :fav")
    fun getFavoritos(fav : Boolean) : LiveData<List<BookEntity>>
}