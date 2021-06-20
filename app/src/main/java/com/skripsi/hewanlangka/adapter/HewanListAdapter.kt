package com.skripsi.hewanlangka.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skripsi.hewanlangka.ui.DetailActivity
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_KRITERIA
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_LOKASI
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_NAMA
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_OBJECT
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_PASAL
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_PHOTO
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_SIKLUS
import com.skripsi.hewanlangka.R
import com.skripsi.hewanlangka.model.ModelHewan
import kotlinx.android.synthetic.main.item_list_hewan.view.*

class HewanListAdapter : RecyclerView.Adapter<HewanListAdapter.ItemViewHolder>() {
    private val mListHewan  : MutableList<ModelHewan> = ArrayList()

    fun update(list : List<ModelHewan> ){
        mListHewan.clear()
        mListHewan.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_hewan,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.apply {
            mListHewan[position].apply {
                tvJudulHewan.text = namaHewan
                tvPulauHewan.text = lokasiHewan
                ivHewan.setImageResource(photoHewan)
            }
            setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(EXTRA_NAMA,mListHewan[position].namaHewan)
                intent.putExtra(EXTRA_KRITERIA,mListHewan[position].kriteria)
                intent.putExtra(EXTRA_PHOTO,mListHewan[position].photoHewan)
                intent.putExtra(EXTRA_LOKASI,mListHewan[position].lokasiHewan)
                intent.putExtra(EXTRA_PASAL,mListHewan[position].pasalHewan)
                intent.putExtra(EXTRA_OBJECT,mListHewan[position].namaObject)
                intent.putExtra(EXTRA_SIKLUS,mListHewan[position].siklusHewan)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return mListHewan.size
    }

    inner class ItemViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

    }
}