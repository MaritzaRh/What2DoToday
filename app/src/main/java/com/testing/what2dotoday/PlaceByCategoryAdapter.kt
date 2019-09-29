package com.testing.what2dotoday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceByCategoryAdapter(val placesList: ArrayList<PlaceRowModel>): RecyclerView.Adapter<PlaceByCategoryAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.place_row_template,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row: PlaceRowModel = placesList[position]
        holder.placeImage.setImageResource(row.placeImage)
        holder.placeTitle.text = row.placeTitle
        holder.placeDescription.text = row.placeDescription
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var placeImage = itemView.findViewById(R.id.place_image) as ImageView
        var placeTitle = itemView.findViewById(R.id.place_title) as TextView
        var placeDescription = itemView.findViewById(R.id.place_description) as  TextView
    }
}