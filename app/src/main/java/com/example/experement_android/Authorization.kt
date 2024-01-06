package com.example.experement_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.experement_android.Fragments.AuthorizationFragment
import com.example.experement_android.databinding.AuthorizationMainBinding

class Authorization : AppCompatActivity() {
    lateinit var binding: AuthorizationMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = AuthorizationMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setFragment(AuthorizationFragment())
        }
    }

    fun setFragment(value: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_aut, value)
            .commit()
    }
}
