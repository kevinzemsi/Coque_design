package com.example.coque_design.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "utilisateur_data_table")
data class Utilisateur(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="utilisateur_id")
    var id:Int = 0,
    @ColumnInfo(name="utilisateur_name")
    var name:String,
    @ColumnInfo(name="utilisateur_prenom")
    var prenon: String,
    @ColumnInfo(name="utilisateur_email")
    var email: String,
    @ColumnInfo(name="utilisateur_password")
    var password:String
)
