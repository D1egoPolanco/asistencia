package com.example.taller_4_pdm.RoomDataBase

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taller_4_pdm.RoomDataBase.Daos.AuthorDao
import com.example.taller_4_pdm.RoomDataBase.Daos.BookDao
import com.example.taller_4_pdm.RoomDataBase.Daos.EditorialDao
import com.example.taller_4_pdm.RoomDataBase.Daos.TagDao
import com.example.taller_4_pdm.RoomDataBase.Entities.AuthorEntity
import kotlinx.coroutines.CoroutineScope
import com.example.taller_4_pdm.RoomDataBase.Entities.BookEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.EditorialEntity
import com.example.taller_4_pdm.RoomDataBase.Entities.TagEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [AuthorEntity::class,BookEntity::class,EditorialEntity::class,TagEntity::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase(){

    abstract fun bookDao() : BookDao
    abstract fun authorDao() : AuthorDao
    abstract fun editorialDao() : EditorialDao
    abstract fun tagDao() : TagDao

    companion object {
        //para notificar a todos los hilos
        @Volatile
        private var INSTANCE : RoomDB? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Book_DB")
                    .addCallback(DataBaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class DataBaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {

                    populateDatabase(
                        database.bookDao(),
                        database.editorialDao(),
                        database.tagDao(),
                        database.authorDao()
                    )
                }
            }
        }

        suspend fun populateDatabase(
            bookDao: BookDao,
            editorialDao: EditorialDao,
            tagDao: TagDao,
            authorDao: AuthorDao
        ) {
            bookDao.nuke()

            var book1 = BookEntity(
                "El extrangero.jpg",
                "El extranjero",
                "albert camus",
                1,
                "Mateu Cromo S.A.",
                "84-89669-45-7",
                "Meursault recibe un mañana un telegrama en el que se le notifica la muerte de su madre. " +
                        "En una playa de Argelia mata inesperadamente a un hombre y es sometido a juicio absurdo." +
                        "¿Cuales son las razones por las que vale la pena nacer, morir y matar? la historia de Meursault " +
                        "reaviva nuestro intento por dar respuesta a estas preguntas",
                "SCI-FI,ACTION,ADVENTURE",
                true
            )
            var editorial1 = EditorialEntity("Mateu Cromo S.A.", "El extranjero")
            /*var tag11 = Tag("Morir")
            var tag12 = Tag("Nacer")
            var tag13 = Tag("Matar")*/
            var author1 = AuthorEntity("Albert Camus", "El extranjero")

            bookDao.insert(book1)
            /*tagDao.insert(tag11)
            tagDao.insert(tag12)
            tagDao.insert(tag13)*/
            authorDao.insert(author1)
            editorialDao.insert(editorial1)
        }
    }
}