package com.example.coque_design.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Utilisateur::class], version = 1, exportSchema = false)
abstract class UtilisateurDatabase:RoomDatabase() {
    abstract fun utilisateurDao(): UtilisateurDao

    companion object{
        @Volatile
        private var INSTANCE : UtilisateurDatabase? = null
        fun getInstance(context: Context): UtilisateurDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        UtilisateurDatabase :: class.java,
                        "utilisateur_data_base"
                    ).build()
                }
                return instance
            }
        }
    }
}