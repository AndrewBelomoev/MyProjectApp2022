package com.example.myprojectapp.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprojectapp.model.LceState
import com.example.myprojectapp.model.weather.WeatherResponse
import com.example.myprojectapp.usecase.GetCurrentWeatherUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
) : ViewModel() {

    private val _lceFlow = MutableStateFlow<LceState<WeatherResponse>>(LceState.Loading)
    val lceFlow: Flow<LceState<WeatherResponse>> = _lceFlow.asStateFlow()

    private val _searchFlow = MutableStateFlow("moscow")
    private val searchQueryFlow = _searchFlow.asStateFlow()

    init {
        viewModelScope.launch {
            getCurrentWeatherUseCase.invoke(searchQueryFlow.value).onSuccess {
                _lceFlow.tryEmit(LceState.Content(data = it))
            }
        }
    }

    fun onQueryTextChanged(query: String) {
        _searchFlow.value = query
    }

}