package com.example.coque_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.coque_design.UI.ui.login.LoginActivity

import com.example.coque_design.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val lien = findViewById<TextView>(R.id.dejacompte)
        val username= findViewById<EditText>(R.id.inputusername)
        val userprenom= findViewById<EditText>(R.id.inputuserprenom)
        val connexion = findViewById<Button>(R.id.inscription)


        connexion.setOnClickListener{
            if(username.text.trim().isNotEmpty() || userprenom.text.trim().isNotEmpty()){
                val intent = Intent(this,NousActivity::class.java)
                startActivity(intent);
            }
        }


        lien.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent);
        }
    }
}