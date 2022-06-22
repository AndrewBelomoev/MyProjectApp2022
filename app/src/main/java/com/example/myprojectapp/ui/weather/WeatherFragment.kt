package com.example.myprojectapp.ui.weather

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.myprojectapp.databinding.FragmentWeatherBinding
import com.example.myprojectapp.model.LceState
import com.example.myprojectapp.model.weather.WeatherResponse
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel by viewModel<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentWeatherBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.lceFlow
            .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { lce ->
                binding.progressCircular.isVisible = lce == LceState.Loading
                when (lce) {
                    is LceState.Content -> {
                        bindWeather(lce.data)
                    }
                    is LceState.Error -> {
                        Snackbar.make(
                            view,
                            lce.throwable.message ?: "State_Error",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    }
                    LceState.Loading -> {
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

    }

    @SuppressLint("SetTextI18n")
    private fun bindWeather(weatherResponse: WeatherResponse) {
        with(binding) {
            println(weatherResponse)
            city.text = weatherResponse.location?.region
            temperature.text = weatherResponse.current?.temperature.toString() + "°C"
            fellsLike.text = "Feels like: " + weatherResponse.current?.feelsLike
            weatherDescriptions.text = weatherResponse.current?.weatherDescriptions.toString()
            cloudCover.text = "Cloud cover: " + weatherResponse.current?.cloudCover
            precipitation.text = "Precipitation: " + weatherResponse.current?.precipitation
            windSpeed.text = "Wind speed: " + weatherResponse.current?.windSpeed
            windDegree.text = "Wind degree: " + weatherResponse.current?.windDegree
            windDirection.text = "Wind direction: " + weatherResponse.current?.windDir
            pressure.text = "Pressure " + weatherResponse.current?.pressure
            humidity.text = "Humidity " + weatherResponse.current?.humidity
            weatherResponse.current?.weatherIcons?.map {
                weatherIcon.load(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}