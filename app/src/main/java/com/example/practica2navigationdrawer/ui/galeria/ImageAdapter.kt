package com.example.practica2navigationdrawer.ui.galeria

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2navigationdrawer.R

class ImageAdapter(private val images: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val options = BitmapFactory.Options().apply {
            inSampleSize = 2 // Cambia este valor para ajustar el tamaño, 2 reduce a la mitad.
        }
        val bitmap = BitmapFactory.decodeResource(holder.imageView.resources, images[position], options)
        holder.imageView.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int = images.size
}
