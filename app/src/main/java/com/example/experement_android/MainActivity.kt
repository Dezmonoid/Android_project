package com.example.experement_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.experement_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController1: NavController
    private lateinit var navController2: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        initUiMenu()
    }


    private fun initUiMenu() {

        navController1 = findNavController(R.id.main_fragment)
        navController2 = findNavController(R.id.first_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_one, R.id.nav_two
            ), binding.drawerLayout
        )
        setupActionBarWithNavController(navController1, appBarConfiguration)
        binding.navView.setupWithNavController(navController1)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}