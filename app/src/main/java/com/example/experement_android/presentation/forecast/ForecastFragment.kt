package com.example.experement_android.presentation.forecast

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.experement_android.databinding.WeatherFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastFragment : Fragment() {
    private var _binding: WeatherFragmentBinding? = null
    private val viewModel by viewModels<ForecastViewModel>()
    private val binding get() = _binding!!
    private val adapter = ForecastAdapter { message: String ->
        shareMessage(message)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WeatherFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.liveData.observe(viewLifecycleOwner) { forecast ->
            adapter.submitList(forecast)
        }
    }

    private fun initRecyclerView() {
        binding.weatherRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.weatherRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun shareMessage(message: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}