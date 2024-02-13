package com.example.experement_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.experement_android.databinding.FirstFragmentOneBinding

class FirstFragmentOne : Fragment() {
    private var _binding: FirstFragmentOneBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FirstFragmentOneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOne.setOnClickListener {
            findNavController().navigate(R.id.firstFragmentTwo)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}