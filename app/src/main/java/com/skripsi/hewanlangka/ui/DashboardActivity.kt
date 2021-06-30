package com.skripsi.hewanlangka.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skripsi.hewanlangka.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnIndonesiaBarat.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("indonesiaStatus","Indonesia Barat")
            startActivity(intent)
        }

        btnIndonesiaTimur.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("indonesiaStatus","Indonesia Timur")
            startActivity(intent)
        }

        btnIndonesiaTengah.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("indonesiaStatus","Indonesia Tengah")
            startActivity(intent)
        }
    }
}