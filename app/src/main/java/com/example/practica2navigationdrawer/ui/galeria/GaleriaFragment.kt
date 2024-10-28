package com.example.practica2navigationdrawer.ui.galeria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.practica2navigationdrawer.R

class GaleriaFragment : Fragment(R.layout.fragment_galeria) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Referencia al ViewPager2
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        // Lista de imágenes (puedes reemplazar los IDs de drawable con las imágenes que desees)
        val images = listOf(
            R.drawable.proyecto1,
            R.drawable.proyecto2,
            R.drawable.proyecto3
        )

        // Configurar el adaptador
        viewPager.adapter = ImageAdapter(images)
    }
}
