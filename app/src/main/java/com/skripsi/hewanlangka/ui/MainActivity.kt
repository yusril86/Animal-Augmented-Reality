package com.skripsi.hewanlangka.ui

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skripsi.hewanlangka.R
import com.skripsi.hewanlangka.adapter.HewanListAdapter
import com.skripsi.hewanlangka.model.ModelHewan
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var namaHewan : Array<String>
    private lateinit var photoHewan : TypedArray
    private lateinit var kriteria : Array<String>
    private lateinit var lokasiHewan : Array<String>
    private lateinit var pasalHewan : Array<String>
    private lateinit var namaObject : Array<String>
    private lateinit var siklusHewan : Array<String>

    private val adapterHewan : HewanListAdapter = HewanListAdapter()
    private var list = arrayListOf<ModelHewan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvHewan.apply {
            adapter = adapterHewan
            setHasFixedSize(true)
        }
        prepare()
        addItem()
    }

    private fun prepare()
    {
        namaHewan = resources.getStringArray(R.array.namaHewan)
        photoHewan = resources.obtainTypedArray(R.array.gambar)
        kriteria = resources.getStringArray(R.array.kriteria)
        lokasiHewan = resources.getStringArray(R.array.namaPulau)
        pasalHewan = resources.getStringArray(R.array.pasalHewan)
        namaObject = resources.getStringArray(R.array.namaObject)
        siklusHewan = resources.getStringArray(R.array.siklusHewan)
    }

    private fun addItem(){
        for (position in namaHewan.indices){
            val item = ModelHewan(
                namaHewan[position],
                photoHewan.getResourceId(position,-1),
                kriteria[position],
                lokasiHewan[position],
                pasalHewan[position],
                namaObject[position],
                siklusHewan[position]

            )
            list.add(item)
        }
        adapterHewan.update(list)
    }


}
