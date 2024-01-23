package com.example.experement_android.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.experement_android.R
import com.example.experement_android.databinding.ActivityMainBinding
import com.example.experement_android.presentation.forecast.ForecastFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            initFragment()
        }
    }

    private fun initFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.weatherFragment, ForecastFragment())
            .commit()
    }
}