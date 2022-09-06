package com.example.foody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.foody.presentation.ui.favorites.FavoritesFragment
import com.example.foody.presentation.ui.joker.JokerFragment
import com.example.foody.presentation.ui.recipes.RecipesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView()
        loadFragment(RecipesFragment())
        selectionListener()
    }

    private fun mapView() {
        bottomNavigationView = findViewById(R.id.btn_navigator)
    }

    private fun selectionListener() {
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.recipes -> {
                    loadFragment(RecipesFragment())
                    true
                }

                R.id.favorites -> {
                    loadFragment(FavoritesFragment())
                    true
                }

                R.id.joker -> {
                    loadFragment(JokerFragment())
                    true
                }

                else -> {
                    loadFragment(RecipesFragment())
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}