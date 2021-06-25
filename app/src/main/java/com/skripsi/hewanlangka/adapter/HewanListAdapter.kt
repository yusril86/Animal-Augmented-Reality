package com.skripsi.hewanlangka.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
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
import com.skripsi.hewanlangka.ui.DetailActivity.Companion.EXTRA_MARKER
import kotlinx.android.synthetic.main.item_list_hewan.view.*

class HewanListAdapter : RecyclerView.Adapter<HewanListAdapter.ItemViewHolder>() {
    private val mListHewan  : MutableList<ModelHewan> = ArrayList()
    private var mFilterHewan: MutableList<ModelHewan> = ArrayList()

    fun update(list : List<ModelHewan> ){
        /*mListHewan.clear()
        mListHewan.addAll(list)
        notifyDataSetChanged()*/

        if (mListHewan == null){
            mListHewan.addAll(list)
            mFilterHewan.addAll(list)
            notifyItemChanged(0,mFilterHewan.size)
        }else{
            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback(){
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return mListHewan.get(oldItemPosition).sebaranIndonesia===list[newItemPosition].sebaranIndonesia
                }

                override fun getOldListSize(): Int {
                    return mListHewan.size
                }

                override fun getNewListSize(): Int {
                    return  list.size
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val newDataModel = mListHewan.get(oldItemPosition)
                    val oldDataModel = list[newItemPosition]
                    return newDataModel.sebaranIndonesia === oldDataModel.sebaranIndonesia
                }
            })
            mListHewan.addAll(list)
            mFilterHewan.addAll(list)
            result.dispatchUpdatesTo(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_hewan,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.apply {
            mFilterHewan[position].apply {
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
                intent.putExtra(EXTRA_MARKER,mListHewan[position].markerMaps)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (mListHewan != null){
            mFilterHewan.size
        }else{
            0
        }
    }

    fun clearFilter()
    {
        mFilterHewan.clear()
    }

    fun clear()
    {
        mListHewan.clear()
    }

    inner class ItemViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

    }
}