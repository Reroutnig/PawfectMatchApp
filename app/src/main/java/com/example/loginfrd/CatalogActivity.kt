package com.example.loginfrd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogActivity : AppCompatActivity() {
    private lateinit var imageRecyclerView: RecyclerView
    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog) //Setting activity layout

        imageRecyclerView = findViewById(R.id.imageRecyclerView) //Find recycler view
        adapter = ImageAdapter(getImageList(), this) //Pass the context to image adapter
        imageRecyclerView.layoutManager = GridLayoutManager(this, 2) //Grid layout to have two columns
        imageRecyclerView.adapter = adapter //Attach adapter to recycler view

        //Listener for home button
        val homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            startActivity(Intent(this@CatalogActivity, MainActivity::class.java))
            finish()
        }
    }

    //Create list of image resource IDs
    private fun getImageList(): List<Int> {
        return listOf(
            R.drawable.cat1,
            R.drawable.dog1,
            R.drawable.cat2,
            R.drawable.dog2,
            R.drawable.cat3,
            R.drawable.dog3,
            R.drawable.cat4,
            R.drawable.dog4,
            R.drawable.cat5,
            R.drawable.dog5,
        )
    }
}


