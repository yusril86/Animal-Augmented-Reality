package com.skripsi.hewanlangka.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skripsi.hewanlangka.R
import com.skripsi.hewanlangka.ShowObjectActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_back.view.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_LOKASI = "extra_lokasi"
        const val EXTRA_KRITERIA = "extra_kriteria"
        const val EXTRA_PASAL = "extra_pasal"
        const val EXTRA_OBJECT = "extra_object"
        const val EXTRA_SIKLUS = "extra_siklus"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val namaHewan = intent.getStringExtra(EXTRA_NAMA)
        val photoHewan = intent.getIntExtra(EXTRA_PHOTO,0)
        val kriteria = intent.getStringExtra(EXTRA_KRITERIA)
        val lokasi = intent.getStringExtra(EXTRA_LOKASI)
        val pasal = intent.getStringExtra(EXTRA_PASAL)
        val namaObject = intent.getStringExtra(EXTRA_OBJECT)
        val siklus = intent.getStringExtra(EXTRA_SIKLUS)

        tvNamaHewanDetail.text = namaHewan
        ivHewanDetail.setImageResource(photoHewan)
        tvKriteriaHewanDetail.text = kriteria
        tvPulauHewanDetail.text = lokasi
        tvPasalHewanDetail.text = pasal
        tvSiklusHewanDetail.text = siklus

        btnAr.setOnClickListener {
            val intent = Intent(this, ShowObjectActivity::class.java)
            intent.putExtra("status",namaObject)
            startActivity(intent)
        }
        toolbarDetail.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}