package com.fcascan.clase4.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.fcascan.clase4.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment : NavHostFragment
    private lateinit var bottomNavView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_bar)
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)
    }
    override fun onStart() {
        super.onStart()

        bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeIcon -> {
                    navHostFragment.navController.navigate(R.id.fragmentHome)
                    true
                }
                R.id.toolsIcon -> {
                    navHostFragment.navController.navigate(R.id.fragmentTools)
                    true
                }
                R.id.settingsIcon -> {
                    navHostFragment.navController.navigate(R.id.fragmentSettings)
                    true
                }
                else -> false
            }
        }
    }
}