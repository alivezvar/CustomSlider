package com.vezvarcode.customslider

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vezvarcode.customslider.databinding.ItemSliderBinding

class SliderAdapter : RecyclerView.Adapter<SliderAdapter.CustomHolder>() {

    private val dataList = ArrayList<String>()
    var listener : AdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val binding = ItemSliderBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return CustomHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = dataList.size

    inner class CustomHolder(
        private val binding : ItemSliderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int){
            dataList[position].apply {
                Glide.with(binding.imgCover.context).load(this).into(binding.imgCover)


                binding.imgCover.setOnClickListener {
                    listener?.onItemClick(position , this)
                }

            }
        }
    }

    fun clear() {
        dataList.clear()
        notifyItemRangeRemoved(0 , dataList.size)
    }

    fun addData(list: ArrayList<String>){
        dataList.addAll(list)
        notifyItemRangeInserted(0 , dataList.size)
    }
}