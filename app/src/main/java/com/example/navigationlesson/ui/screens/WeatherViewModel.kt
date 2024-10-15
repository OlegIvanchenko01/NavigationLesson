package com.example.navigationlesson.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.BreedsModel
import com.example.data.repository.BreedsRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch




data class PageState(
    val page: Int = 1,
    val isLoading: Boolean = true,
    val info:  BreedsModel = BreedsModel.empty()
)

sealed class IntentsOnClick {
    data object NextPage : IntentsOnClick()
    data object BackPage : IntentsOnClick()
}

class WeatherViewModel : ViewModel() {
    private val breedsRepositoryInterface : BreedsRepositoryInterface = TODO()
    private val _state: MutableStateFlow<PageState> = MutableStateFlow(PageState())
    val state: StateFlow<PageState>
        get() = _state

    fun processIntent(intent: IntentsOnClick) {
        when (intent) {
            IntentsOnClick.NextPage -> {
                if (_state.value.page == 4)
                    return
                _state.update {
                    it.copy(
                        page = it.page + 1
                    )

                }
                getWeatherApi()
            }

            IntentsOnClick.BackPage -> {
                if (_state.value.page == 1)
                    return
                _state.update {
                    it.copy(
                        page = it.page - 1
                    )

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
            WeatherApi.retrofitService.getPhotos(state.value.page.toString())
                .onSuccess { response ->
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

