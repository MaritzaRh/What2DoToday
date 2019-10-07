package com.testing.what2dotoday

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.LinearLayout.VERTICAL


class Places : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places)
        val recyclerView = findViewById(R.id.places_by_category_recyclyerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)

        val rows = ArrayList<PlaceRowModel>()

        rows.add(PlaceRowModel(R.drawable.forest, "Bosque Title", "Bosque descripción"))
        rows.add(PlaceRowModel(R.drawable.beach, "Playa Title", "Playa descripción"))

        val adapter = PlaceByCategoryAdapter(rows)
        recyclerView.adapter = adapter

    }
}
