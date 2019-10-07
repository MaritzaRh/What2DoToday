package com.testing.what2dotoday

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Test : AppCompatActivity() {


    var buttonPressed: Boolean = false
    lateinit  var recyclerView: RecyclerView
    lateinit var  adapter: TestAdapter
    lateinit var question: TextView
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        question = findViewById(R.id.questionText)
        question.text = "ElIGE UN  PAISAJE"
        recyclerView = findViewById(R.id.activity_test_recyclerView)  as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)

        val rows = ArrayList<TestRowModel>()

        rows.add(TestRowModel(R.drawable.forest,R.drawable.beach,R.drawable.beach,R.drawable.forest))

        adapter = TestAdapter(rows,this)
        recyclerView.adapter = adapter

    }
}
