package com.testing.what2dotoday

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_test.*

class Test : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        questionText.text = "ElIGE UN  PAISAJE"
        val recyclerView = findViewById(R.id.activity_test_recyclerView)  as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)

        val rows = ArrayList<TestRowModel>()

        rows.add(TestRowModel(R.drawable.beach, R.drawable.forest))
        rows.add(TestRowModel(R.drawable.mountain, R.drawable.desert))

        val  adapter = TestAdapter(rows)
        recyclerView.adapter = adapter

    }
}
