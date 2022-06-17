package com.example.coque_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NousActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nous)
        val  telephone = findViewById<TextView>(R.id.telselector)
        val  ordinateur = findViewById<TextView>(R.id.ordiselector)


        telephone.setOnClickListener{
            val intent = Intent(this, ChoixActivity::class.java)
            startActivity(intent);
        }

        ordinateur.setOnClickListener{
            val intent = Intent(this, ChoixActivity::class.java)
            startActivity(intent);
        }
    }
}