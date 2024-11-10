package com.example.navigationlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.data.models.WeatherModel
import com.example.data.repository.BreedsRepositoryInterface
import com.example.navigationlesson.ui.screens.IntentsOnClick
import com.example.navigationlesson.ui.screens.PageState
import com.example.navigationlesson.ui.screens.Success
import com.example.navigationlesson.ui.screens.WeatherViewModel
import com.example.navigationlesson.ui.theme.NavigationLessonTheme
import com.example.navigationlesson.ui.theme.blue_bg
import com.example.navigationlesson.ui.theme.blue_bg_home_screen
import com.example.navigationlesson.ui.theme.yellow_bg_card

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            NavigationLessonTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: WeatherViewModel = viewModel()) {
    val pageState by viewModel.state.collectAsStateWithLifecycle()
    val onClick = viewModel::processIntent

    Success(pageState.info, onClick)

    if (pageState.isLoading) {
        Load()
    }
}

@Composable
fun Load() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Load",
            style = TextStyle(color = Color.White)
            )
    }
}



