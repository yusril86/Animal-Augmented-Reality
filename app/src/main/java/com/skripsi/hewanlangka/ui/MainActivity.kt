package com.skripsi.hewanlangka.ui

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
    private lateinit var markerMaps : Array<String>
    private lateinit var sebaranIndonesia : Array<String>
    private lateinit var videoHewan : Array<String>
    private  val suaraHewan = arrayListOf(R.raw.banteng,R.raw.suaraanoa,R.raw.suarayaki,R.raw.suaraaningajak,R.raw.suaraaningajak,R.raw.suarakatak,R.raw.suarakurakura,R.raw.suarapenyu,R.raw.suarabuaya,R.raw.suarasancatimor,R.raw.suarasanca)

    private val adapterHewan : HewanListAdapter = HewanListAdapter()
    private var list = arrayListOf<ModelHewan>()

    private val listCountry = arrayListOf("Silhakan Pilih Category","Indonesia Timur","Indonesia Barat", "Indonesia Tengah")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvHewan.apply {
            setHasFixedSize(true)
            adapter = adapterHewan
        }
        prepare()
        addItem()

       /* val arrayAdapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            listCountry
        )
        spinnerCategory.adapter = arrayAdapter
        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == 0){
                    list.clear()
                    addItem()
                }else{
                    list.clear()
                    addItemSpinner()
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }*/
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
        markerMaps = resources.getStringArray(R.array.markerMaps)
        sebaranIndonesia = resources.getStringArray(R.array.sebaranIndonesia)
        videoHewan = resources.getStringArray(R.array.videoHewan)
    }

    private fun addItem(){
        val getIndonesiaStatus = intent.getStringExtra("indonesiaStatus")
        for (position in namaHewan.indices){
            if (getIndonesiaStatus == sebaranIndonesia[position]){
                val item = ModelHewan(
                    namaHewan[position],
                    photoHewan.getResourceId(position,-1),
                    kriteria[position],
                    lokasiHewan[position],
                    pasalHewan[position],
                    namaObject[position],
                    siklusHewan[position],
                    markerMaps[position],
                    sebaranIndonesia[position],
                    suaraHewan[position],
                    videoHewan[position]

                )
//                adapterHewan.clearFilter()
                list.add(item)
            }
        }
        adapterHewan.update(list)
    }


    /*private fun addItemSpinner(){
        for (position in namaHewan.indices){
            if (spinnerCategory.selectedItem == sebaranIndonesia[position]){
                val item = ModelHewan(
                    namaHewan[position],
                    photoHewan.getResourceId(position,-1),
                    kriteria[position],
                    lokasiHewan[position],
                    pasalHewan[position],
                    namaObject[position],
                    siklusHewan[position],
                    markerMaps[position],
                    sebaranIndonesia[position],
                    suaraHewan[position]
                )
                adapterHewan.clearFilter()
                list.add(item)
            }
        }
        adapterHewan.update(list)
    }*/

    override fun onResume() {
        super.onResume()
        adapterHewan.notifyDataSetChanged()
    }


}
