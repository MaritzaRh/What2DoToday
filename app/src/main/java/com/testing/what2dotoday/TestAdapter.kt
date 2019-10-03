package com.testing.what2dotoday

import android.annotation.SuppressLint
import android.content.Context.VIBRATOR_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import androidx.annotation.RequiresApi


import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import android.os.VibrationEffect as VibrationEffect1
import android.os.Vibrator as Vibrator

class TestAdapter(val answerList: ArrayList<TestRowModel>, val TestActivity:Test): RecyclerView.Adapter<TestAdapter.ViewHolder>(){

    private val splashTime = 500L
    private lateinit var myhandler: Handler
    private lateinit var vibrator:Vibrator

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.test_answer_template,parent,false)
        myhandler = Handler()
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return answerList.size
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row: TestRowModel = answerList[position]
        holder.topLeftImage.setImageResource(row.topLeftAns)
        holder.topRightImage.setImageResource(row.topRightAns)

        //Validate there ar more answers
        holder.bottomLeftImage.setImageResource(row.bottomLeftAns)
        holder.bottomRightImage.setImageResource(row.bottomRightAns)


        holder.topLeftImage.setOnClickListener{
            clicked(1);
        }
        holder.topRightImage.setOnClickListener{
            clicked(2);
        }
        holder.bottomLeftImage.setOnClickListener{
            clicked(3);
        }
        holder.bottomRightImage.setOnClickListener {
            clicked(4);
        }


    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var topLeftImage = itemView.findViewById(R.id.answerUL) as ImageView
        var topRightImage = itemView.findViewById(R.id.answerUR) as ImageView
        var bottomLeftImage = itemView.findViewById(R.id.answerBL) as ImageView
        var bottomRightImage = itemView.findViewById(R.id.answerBR) as ImageView
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun vibratePhone(){
        val effect: VibrationEffect1 = VibrationEffect1.createOneShot(1000, VibrationEffect1.DEFAULT_AMPLITUDE);
        vibrator.vibrate(effect)
    }
    @SuppressLint("WrongConstant")
    fun refresh(){
        TestActivity.question.text = "Cambie de texto"

        TestActivity.recyclerView.layoutManager = LinearLayoutManager(TestActivity.baseContext, VERTICAL, false)
        val rows = ArrayList<TestRowModel>()
        val images = ArrayList<Int>()
        images.add(R.drawable.beach)
        images.add(R.drawable.forest)
        images.add(R.drawable.desert)
        images.add(R.drawable.mountain)

        val img_1 = images.get(Random.nextInt(0,4))
        val img_2 = images.get(Random.nextInt(0,4))
        val img_3 = images.get(Random.nextInt(0,4))
        val img_4 = images.get(Random.nextInt(0,4))
        rows.add(TestRowModel(img_1, img_2,img_3, img_4))
        TestActivity.adapter = TestAdapter(rows,TestActivity)
        TestActivity.recyclerView.adapter = TestActivity.adapter

    }
    fun clicked(buttonIndex: Int){
        //vibratePhone()
        val text = "Presionaste: " + buttonIndex
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(TestActivity, text, duration)
        toast.show()

        myhandler.postDelayed({
            refresh()
        },splashTime)

    }


}
