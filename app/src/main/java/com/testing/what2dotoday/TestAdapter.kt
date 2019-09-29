package com.testing.what2dotoday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class TestAdapter(val answerList: ArrayList<TestRowModel>): RecyclerView.Adapter<TestAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.test_answer_template,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return answerList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row: TestRowModel = answerList[position]
        holder.leftImage.setImageResource(row.leftAns)
        holder.rightImage.setImageResource(row.rightAns)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var leftImage = itemView.findViewById(R.id.answerL) as ImageView
        var rightImage = itemView.findViewById(R.id.answerR) as ImageView
    }
}