package com.example.coque_design.db

import android.provider.ContactsContract
import androidx.room.*

@Dao
interface UtilisateurDao {
    @Insert
    fun insertUtilisateur(utilisateur: Utilisateur):Long

    @Update
    fun updateUtilisateur(utilisateur: Utilisateur)

    @Delete
    fun deleteUtilisateur(utilisateur: Utilisateur)

    @Query("SELECT EXISTS (SELECT * FROM UTILISATEUR_DATA_TABLE where utilisateur_name = :name )")
    fun is_name(name: String):Boolean

    @Query("SELECT EXISTS (SELECT * FROM UTILISATEUR_DATA_TABLE where utilisateur_prenom = :prenom)")
    fun is_prenom(prenom: String):Boolean

    @Query("SELECT EXISTS (SELECT * FROM UTILISATEUR_DATA_TABLE where utilisateur_email = :email AND utilisateur_password = :password)")
    fun login(email: String, password: String):Boolean

    @Query("SELECT EXISTS (SELECT * FROM UTILISATEUR_DATA_TABLE where utilisateur_id = :id)")
    fun getUserById(id: Int):Boolean

}