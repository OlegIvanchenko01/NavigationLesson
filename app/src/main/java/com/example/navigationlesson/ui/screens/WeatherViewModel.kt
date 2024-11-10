package com.example.navigationlesson.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.RepositoryModule
import com.example.data.models.BreedsModel
import com.example.data.models.WeatherModel
import com.example.data.repository.BreedsRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class PageState(
    val page: String = "Madrid",
    val isLoading: Boolean = false,
//    val info: BreedsModel = BreedsModel.empty()
    val info: WeatherModel = WeatherModel.empty()
)

sealed class IntentsOnClick {
    data class UpLoad(val city : String) : IntentsOnClick()
}

class WeatherViewModel : ViewModel() {
    private val breedsRepositoryInterface: BreedsRepositoryInterface =
        RepositoryModule.getInterface()
    private val _state: MutableStateFlow<PageState> = MutableStateFlow(PageState())
    val state: StateFlow<PageState>
        get() = _state

    fun processIntent(intent: IntentsOnClick) {
        when (intent) {
            is IntentsOnClick.UpLoad -> {
                _state.update {
                    it.copy(page = intent.city)
                }
                getWeatherApi()
            }

        }

    }

    init {
//        getWeatherApi()
    }

    private fun getWeatherApi() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            breedsRepositoryInterface.getWeather(state.value.page)
                .onSuccess {response ->

                _state.update {
                    it.copy(
                        info = response,
                        isLoading = false
                    )
                }
            }.onFailure {
                _state.update {
                    it.copy(

                        isLoading = false
                    )
                }
            }

        }
    }
}



