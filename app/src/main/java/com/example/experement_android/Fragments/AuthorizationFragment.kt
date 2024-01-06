package com.example.experement_android.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.experement_android.databinding.AutorizationFragmentBinding

class AuthorizationFragment : Fragment() {
    private var _binding: AutorizationFragmentBinding? = null
    private val binding: AutorizationFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AutorizationFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}