package com.example.racketapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.racketapp.R
import com.example.racketapp.data.RocketDataItem

class RocketAdapter(private val context: Context,private var rocketDataItem:ArrayList<RocketDataItem>, private var listener : OnItemClickListener):
    RecyclerView.Adapter<RocketAdapter.rocketViewHolder>() {

    fun setData(rocketDataItem: ArrayList<RocketDataItem>){
        this.rocketDataItem = rocketDataItem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rocketViewHolder {
        return rocketViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row_rocket, null))
    }

    override fun onBindViewHolder(holder: rocketViewHolder, position: Int) {
        val rocketData: RocketDataItem = rocketDataItem[position]
       Glide.with(context).asBitmap().load(rocketData.flickr_images[0]).into(holder.userImage)
        holder.name.text = rocketData.name
        holder.country.text = rocketData.country
        holder.engines.text = rocketData.engines.number.toString()
    }

    override fun getItemCount(): Int = rocketDataItem.size

    inner class rocketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val name: TextView = itemView.findViewById(R.id.name)
        val country: TextView = itemView.findViewById(R.id.country)
        val engines: TextView = itemView.findViewById(R.id.engines)
        val userImage: ImageView = itemView.findViewById(R.id.iv_images)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = layoutPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(rocketDataItem.get(position))
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(rockDataItem: RocketDataItem)
    }
}