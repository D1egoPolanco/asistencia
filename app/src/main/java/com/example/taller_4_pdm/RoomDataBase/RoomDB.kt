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
            var book1 = BookEntity(
                "El extrangero.jpg",
                "El extranjero",
                "albert camus",
                1,
                "Mateu Cromo S.A.",
                "8489669457",
                "Meursault recibe un mañana un telegrama en el que se le notifica la muerte de su madre. " +
                        "En una playa de Argelia mata inesperadamente a un hombre y es sometido a juicio absurdo." +
                        "¿Cuales son las razones por las que vale la pena nacer, morir y matar? la historia de Meursault " +
                        "reaviva nuestro intento por dar respuesta a estas preguntas",
                "SCI-FI,ACTION,ADVENTURE",
                0
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
            ////////////////////libro 2//////////////////////
            var book2 = BookEntity(
                "La luna.jpg",
                "El principito",
                "Antoine de Saint-Exupéry",
                1,
                "Santillana S.A.",
                "9788478886289",
                "Viví así, solo, sin nadie con quien hablar verdaderamente, hasta que tuve una avería en el desierto del Sahara, " +
                        "hace seis años. Algo se había roto en mi motor. Y como no tenía conmigo ni mecánico ni pasajeros, me dispuse a realizar, " +
                        "solo, una reparación difícil. Era, para mí, cuestión de vida o muerte. Tenía agua apenas para ocho días.\n",
                "AVENTURA, NIÑOS, SCI-FI, CLASICO, BEST SELLER",
                1
            )
            var editorial2 = EditorialEntity("Santillana S.A.", "El principito")
            var author2 = AuthorEntity("Antoine de Saint-Exupéry", "El principito")
            bookDao.insert(book2)
            authorDao.insert(author2)
            editorialDao.insert(editorial2)
            //////////////LIBRO 3///////////////
            var book3 = BookEntity(
                "Quijote a caballo.jpg",
                "DON QUIJOTE DE LA MANCHA",
                "Miguel de Cervantes",
                1,
                "PLUTON EDICIONES",
                "9788493806125",
                "El ingenioso hidalgo don Quijote de la Mancha narra las aventuras de Alonso Quijano, " +
                        "un hidalgo pobre que de tanto leer novelas de caballería acaba enloqueciendo y creyendo ser " +
                        "un caballero andante, nombrándose a sí mismo como don Quijote de la Mancha. Sus intenciones " +
                        "son ayudar a los pobres y desfavorecidos, y lograr el amor de la supuesta Dulcinea del Toboso," +
                        " que es en realidad es una campesina llamada Aldonza Lorenzo. Decide nombrar a Sancho Panza, " +
                        "un empleado suyo, su escudero.",
                "AVENTURA, SCI-FI, CLASICO, BEST SELLER",
                1
            )
            var editorial3 = EditorialEntity("PLUTON EDICIONES", "DON QUIJOTE DE LA MANCHA")
            var author3 = AuthorEntity("Miguel de Cervantes", "DON QUIJOTE DE LA MANCHA")
            bookDao.insert(book3)
            authorDao.insert(author3)
            editorialDao.insert(editorial3)
            /////////////LIBRO ////////////
            var book4 = BookEntity(
                "Ciegos.jpg",
                "Ensayo sobre la ceguera",
                "Jose Saramago",
                1,
                "Alfaguara",
                "9788490628720",
                "Ensayo sobre la ceguera es la ficción de un autor que nos alerta sobre «la responsabilidad" +
                        " de tener ojos cuando otros los perdieron».«Dentro de nosotros hay algo que no tiene nombre," +
                        " esa cosa es lo que somos.»Un hombre parado ante un semáforo en rojo se queda ciego " +
                        "súbitamente. Es el primer caso de una «ceguera blanca» que se expande de manera fulminante. " +
                        "Internados en cuarentena o perdidos en la ciudad, los ciegos tendrán que enfrentarse con lo " +
                        "que existe de más primitivo en la naturaleza humana: la voluntad de sobrevivir a cualquier " +
                        "precio.",
                "FILOSOFIA, BEST SELLER, SCI-FI",
                0
            )
            var editorial4 = EditorialEntity("Alfaguara", "Ensayo sobre la ceguera")
            var author4 = AuthorEntity("Jose Saramago", "Ensayo sobre la ceguera")
            bookDao.insert(book4)
            authorDao.insert(author4)
            editorialDao.insert(editorial4)
        }
    }
}