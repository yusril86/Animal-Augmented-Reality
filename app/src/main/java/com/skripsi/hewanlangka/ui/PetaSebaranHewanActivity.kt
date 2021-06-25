package com.skripsi.hewanlangka.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.skripsi.hewanlangka.R

class PetaSebaranHewanActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val arrayMarker : ArrayList<LatLng> = ArrayList()
    private val titleMarker : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peta_sebaran_hewan)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val status = intent.getStringExtra("status")
        when(status){
            "banteng" ->{
                markerAnimalBanteng()
            }
            "anoa" ->{
                markerAnimalAnoa()
            }
            "yaki" ->{
                markerAnimalYaki()

            }
            "anjing" -> {
                markerAnimalAjak()

            }
            "kijangkuning" ->{
                markerAnimalKijang()

            }
            "kodokmerah" ->{

                markerAnimalKodokMerah()
            }
            "kurakura" ->{
                markerAnimalKuraKura()

            }
            "penyu" ->{
                markerAnimalPenyu()

            }
            "buaya" -> {
                markerAnimalBuaya()

            }
            "sancatimor" -> {
                markerAnimalSancaTimor()

            }
            "sancahijau" -> {
                markerAnimalSancaHijau()
            }
        }


//        markerAnimalBanteng()

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
       /* val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

        for (i in arrayMarker.indices){
            mMap.addMarker(MarkerOptions().position(arrayMarker.get(i)).title(titleMarker[i]))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayMarker[i]))
        }
    }

    private fun markerAnimalBanteng(){
        val titleLocation = arrayListOf<String>("Jawa","Kalimantan","Bali")

        titleMarker.addAll(titleLocation)

        val jawa = LatLng(-7.831798207021509, 111.76349443490726)
        val kalimantan = LatLng(1.7854088044417302, 115.27696655287501)
        val bali = LatLng(-8.580942360951772, 115.3501590760896)

        arrayMarker.add(jawa)
        arrayMarker.add(kalimantan)
        arrayMarker.add(bali)
    }

    private fun markerAnimalAnoa(){
        val titleLocation = arrayListOf<String>("Sulawesi")
        val markerLocation = arrayListOf(LatLng(-4.216493323584193, 122.18351265181205))

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)

        /*val jawa = LatLng(-7.831798207021509, 111.76349443490726)
        val kalimantan = LatLng(1.7854088044417302, 115.27696655287501)
        val bali = LatLng(-8.580942360951772, 115.3501590760896)

        arrayMarker.add(jawa)
        arrayMarker.add(kalimantan)
        arrayMarker.add(bali)*/
    }

    private fun markerAnimalYaki(){
        val titleLocation = arrayListOf("Sulawesi Utara")
        val markerLocation = arrayListOf(LatLng(1.335346164926747, 124.8498030017453))

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }

    private fun markerAnimalAjak(){
        val titleLocation = arrayListOf("Sumatera","Jawa")
        val markerLocation = arrayListOf(LatLng(-0.017210243403381523, 101.60311327077999),
            LatLng(-7.557413206340266, 110.85967325457554)
        )

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }

    private fun markerAnimalKijang(){
        val titleLocation = arrayListOf("Kalimantan")
        val markerLocation = arrayListOf(LatLng(1.7877683881572413, 116.5548948477035))

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }

    private fun markerAnimalKodokMerah(){
        val titleLocation = arrayListOf("Jawa Barat")
        val markerLocation = arrayListOf(LatLng(-6.702897811350703, 106.51861562693861))

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }

    private fun markerAnimalKuraKura(){
        val titleLocation = arrayListOf("Papua Nugini","Papua Bagian Selatan")
        val markerLocation = arrayListOf(LatLng(-4.014156100203376, 144.66446087642083),
            LatLng(-8.170183194929606, 139.97538364004242)
        )

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }

    private fun markerAnimalPenyu(){

        val titleLocation = arrayListOf("Perairan Samudra Pasifik")
        val markerLocation = arrayListOf(LatLng(18.62582165227467, 160.89050429821341)
        )

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }

    private fun markerAnimalBuaya(){
        val titleLocation = arrayListOf("Hutan Bakau")
        val markerLocation = arrayListOf(LatLng(-6.11576213680521, 106.76920159668059)
        )

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }

    private fun markerAnimalSancaTimor(){
        val titleLocation = arrayListOf("Lembata","Flores","Pantar","Adonara")
        val markerLocation = arrayListOf(
            LatLng(-8.470845546431358, 123.47742087736604),
            LatLng(-8.326501569241998, 123.12992796218201),
            LatLng(-8.28127619414237, 124.2267939771182),
            LatLng(-8.24960883493471, 123.15002831045554)
        )

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)

    }

    private fun markerAnimalSancaHijau(){
        val titleLocation = arrayListOf("Kepulauan Raja Ampat")
        val markerLocation = arrayListOf(LatLng(-0.2333175999414367, 130.51666733493846)
        )

        titleMarker.addAll(titleLocation)
        arrayMarker.addAll(markerLocation)
    }
}