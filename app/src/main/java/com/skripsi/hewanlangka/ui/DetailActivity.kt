package com.skripsi.hewanlangka.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.a.b.a.a.a.e
import com.google.android.gms.common.api.Api
import com.skripsi.hewanlangka.R
import com.skripsi.hewanlangka.ShowObjectActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_back.view.*
import org.json.JSONObject
import java.net.MalformedURLException
import java.net.URL

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_LOKASI = "extra_lokasi"
        const val EXTRA_KRITERIA = "extra_kriteria"
        const val EXTRA_PASAL = "extra_pasal"
        const val EXTRA_OBJECT = "extra_object"
        const val EXTRA_SIKLUS = "extra_siklus"
        const val EXTRA_MARKER = "extra_marker"
        const val EXTRA_SUARA = "extra_suara"
        const val EXTRA_VIDEO = "extra_video"
    }

    private var isPlay : Boolean = false
    private var audio : MediaPlayer = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        showVideo()



        val namaHewan = intent.getStringExtra(EXTRA_NAMA)
        val photoHewan = intent.getIntExtra(EXTRA_PHOTO,0)
        val kriteria = intent.getStringExtra(EXTRA_KRITERIA)
        val lokasi = intent.getStringExtra(EXTRA_LOKASI)
        val pasal = intent.getStringExtra(EXTRA_PASAL)
        val namaObject = intent.getStringExtra(EXTRA_OBJECT)
        val siklus = intent.getStringExtra(EXTRA_SIKLUS)
        val marker = intent.getStringExtra(EXTRA_MARKER)
        val suaraHewan = intent.getIntExtra(EXTRA_SUARA,0)
        val urlVideo = intent.getStringExtra(EXTRA_VIDEO)

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

        btnPetaSebaran.setOnClickListener {
            val intent = Intent(this, PetaSebaranHewanActivity::class.java)
            intent.putExtra("status",namaObject)
            startActivity(intent)
        }

        toolbarDetail.btnBack.setOnClickListener {
            onBackPressed()
        }



        btnSuaraHewanDetail.setOnClickListener {
            if(btnSuaraHewanDetail.isChecked){
                audio = MediaPlayer.create(this,suaraHewan)
                audio.start()
            }else{
                audio.release()
//                audio.stop()
            }
        }
    }

    private fun showVideo(){
        val namaHewan = intent.getStringExtra(EXTRA_NAMA)
        val urlVideo = intent.getStringExtra(EXTRA_VIDEO)
        val videoId = extractYoutubeId(urlVideo!!)
        val imgUrl = "https://img.youtube.com/vi/$videoId/0.jpg"


        tv_judul_video.text = namaHewan

        Glide
            .with(this)
            .load(imgUrl)
            .error(R.drawable.ic_launcher_background)
            .placeholder(R.drawable.ic_launcher_background)
            .transition(DrawableTransitionOptions.withCrossFade(200))
            .into(thumbnail_video)

        thumbnail_video.setOnClickListener {
            watchYoutubeVideo(this,videoId)
        }
    }

    @Throws(MalformedURLException::class)
    fun extractYoutubeId(url: String): String? {
        val query = URL(url).query
        val param = query.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var id: String? = null
        for (row in param) {
            val param1 = row.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (param1[0] == "v") {
                id = param1[1]
            }
        }
        return id
    }



    private fun watchYoutubeVideo(context: Context, id: String?) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$id")
        )
        try {
            context.startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            context.startActivity(webIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        btnSuaraHewanDetail.isChecked = false
        audio.release()
    }

    override fun onPause() {
        super.onPause()
        btnSuaraHewanDetail.isChecked = false
        audio.release()
    }
}