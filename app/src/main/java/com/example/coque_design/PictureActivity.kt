package com.example.coque_design

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.FileProvider
import com.example.coque_design.UI.ui.login.LoginActivity
import java.io.File
import java.io.IOException

class PictureActivity : AppCompatActivity() {
    lateinit var photoPath : String
    val REQUEST_TAKE_PHOTO =1
    val image = findViewById<ImageView>(R.id.picture)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val prendrephoto = findViewById<Button>(R.id.filmer)
        val boutonretour =findViewById<TextView>(R.id.Boutonretour)

        prendrephoto.setOnClickListener{
            prendrephoto()
        }

        boutonretour.setOnClickListener {
            val intent = Intent(this, NousActivity::class.java)
            startActivity(intent);
        }
    }

    private fun prendrephoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null){

            var photoFile : File? =  null
            try{
                photoFile = createImageFile()
            }catch (e: IOException){}
            if (photoFile != null){
                val photoUri =  FileProvider.getUriForFile(
                    this,
                    "com.example.android.fileprovider",
                    photoFile
                )
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
                startActivityForResult(intent,REQUEST_TAKE_PHOTO)
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
            image.rotation = 90f
            image.setImageURI(Uri.parse(photoPath))
        }
    }


    private fun createImageFile(): File? {
        val fileName ="MyPicture"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            fileName,
            "jpg",
            storageDir
        )
        photoPath = image.absolutePath
        return image

    }
}