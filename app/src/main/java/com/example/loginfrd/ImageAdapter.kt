package com.example.loginfrd

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val imageList: List<Int>, private val context: Context) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])

        //Listener for each item in the recycler view
        holder.itemView.setOnClickListener {
            //Open adoption activity based on the ID
            val intent = Intent(context, AdoptionActivity::class.java)
            intent.putExtra("imageResourceId", imageList[position])
            context.startActivity(intent)
        }
    }

    //Return number of items in recycler view
    override fun getItemCount(): Int {
        return imageList.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        //Function to bind image resource ot the ImageView
        fun bind(imageResId: Int) {
            imageView.setImageResource(imageResId)
        }
    }
}

