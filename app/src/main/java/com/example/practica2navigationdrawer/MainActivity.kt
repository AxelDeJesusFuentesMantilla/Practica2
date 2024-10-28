package com.example.practica2navigationdrawer

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.practica2navigationdrawer.databinding.ActivityMainBinding
import com.example.practica2navigationdrawer.ui.galeria.GaleriaFragment
import com.example.practica2navigationdrawer.ui.inicio.InicioFragment
import com.example.practica2navigationdrawer.ui.presentacion.PresentacionFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mantén esta línea para tener acceso a navView, pero sin asignar el ancho
        val navView: NavigationView = binding.navView

        // Configurar la barra de herramientas como ActionBar
        setSupportActionBar(binding.appBarMain.toolbar)

        // Configurar el botón de acción flotante (FAB)
        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout

        // Configurar el ActionBarDrawerToggle para el ícono de menú
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Configurar el NavigationView para la navegación manual
        navView.setNavigationItemSelectedListener { menuItem ->
            // Manejar la navegación según el ítem seleccionado
            when (menuItem.itemId) {
                R.id.nav_inicio -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, InicioFragment())
                        .commit()
                }
                R.id.nav_galeria -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, GaleriaFragment())
                        .commit()
                }
                R.id.nav_presentacion -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, PresentacionFragment())
                        .commit()
                }
            }
            drawerLayout.closeDrawers() // Cierra el drawer después de la selección
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}
