package com.example.coque_design

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.Gallery
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException

class ChoixActivity : AppCompatActivity() {
    lateinit var photoPath : String
    val REQUEST_TAKE_PHOTO =1
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choix)

        val prendrephoto = findViewById<Button>(R.id.filmer)
        val retouranous = findViewById<TextView>(R.id.retour)
        val importer = findViewById<Button>(R.id.Importergallerie)

        prendrephoto.setOnClickListener{
            val intent = Intent(this, PictureActivity::class.java)
            startActivity(intent);
        }

        importer.setOnClickListener{
            val intent = Intent(this, galleryActivity::class.java)
            startActivity(intent);
        }

        retouranous.setOnClickListener {
            val intent = Intent(this, NousActivity::class.java)
            startActivity(intent);
        }
    }


}