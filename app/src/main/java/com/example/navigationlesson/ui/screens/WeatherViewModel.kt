package com.example.navigationlesson.ui.screens

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.ExampleJson2KtKotlin
import com.example.example.ExampleJson2KtKotlinModel
import com.example.navigationlesson.network.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



//sealed class WeatherUiState {
//    data class Success(val example : ExampleJson2KtKotlin) : WeatherUiState()
//    data object Loading : WeatherUiState()
//}

data class PageState(
    val page: Int = 1,
    val isLiading : Boolean = true,
    val info : ExampleJson2KtKotlinModel = ExampleJson2KtKotlinModel.empty()
)

sealed class IntentsOnClick{
    data object NextPage :IntentsOnClick()
    data object BackPage :IntentsOnClick()

}

class WeatherViewModel: ViewModel(){


    private val _state: MutableStateFlow<PageState> = MutableStateFlow(PageState())
    val state: StateFlow<PageState>
        get()=_state

    fun procesIntent(intent : IntentsOnClick){
        when(intent){
            IntentsOnClick.NextPage -> {
                if (_state.value.page==4)
                    return
                _state.update {
                    it.copy(
                        page = it.page+1
                    )

                }
                getWeatherApi()
            }

            IntentsOnClick.BackPage -> {
                if (_state.value.page==1)
                    return
                _state.update {
                    it.copy(
                        page =  it.page-1
                    )

                }
                getWeatherApi()
            }
        }

    }


    init {
        getWeatherApi()
    }

    private fun getWeatherApi(){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLiading = true
                )
            }
            WeatherApi.retrofitService.getPhotos(state.value.page.toString()).onSuccess { response ->
                _state.update {
                    it.copy(
                        info = response.toModels(),
                        isLiading = false
                    )
                }

            }.onFailure {
                _state.update {
                    it.copy(
                        isLiading = false
                    )
                }
            }


        }

    }

}

