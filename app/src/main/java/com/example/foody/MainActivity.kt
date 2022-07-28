package com.example.foody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.foody.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView()
        selectionListener()
    }

    private fun mapView() {
        bottomNavigationView = findViewById(R.id.btn_navigator)
    }

    private fun selectionListener() {
        bottomNavigationView.setOnItemReselectedListener {
            when(it.itemId) {
                R.id.recipes -> {
                    loadFragment(RecipesFragment())
                    return@setOnItemReselectedListener
                }

                R.id.favorites -> {
                    loadFragment(FavoritesFragment())
                    return@setOnItemReselectedListener
                }

                R.id.joker -> {
                    loadFragment(JokerFragment())
                    return@setOnItemReselectedListener
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