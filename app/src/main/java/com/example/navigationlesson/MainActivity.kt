package com.example.navigationlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.navigationlesson.ui.screens.IntentsOnClick
import com.example.navigationlesson.ui.screens.PageState
import com.example.navigationlesson.ui.screens.WeatherViewModel
import com.example.navigationlesson.ui.theme.NavigationLessonTheme
import com.example.navigationlesson.ui.theme.yellow_bg_card

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myViewModel = WeatherViewModel()

        setContent {
            NavigationLessonTheme {
                MainScreen(myViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: WeatherViewModel) {
    val pageState by viewModel.state.collectAsStateWithLifecycle()
    val onClick = viewModel::processIntent

    Success(pageState, onClick)

    if (pageState.isLoading) {
        Load()
    }
}

@Composable
fun Load() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Load")
    }
}

@Composable
fun Success(pageState: PageState, onClick: (IntentsOnClick) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = yellow_bg_card),
                onClick = {
                    onClick(IntentsOnClick.BackPage)
                }) {
                Text("Back")
            }
            Button(
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = yellow_bg_card),
                onClick = {
                    onClick(IntentsOnClick.NextPage)
                }) {
                Text("Next Page")
            }

        }

        LazyColumn {
            items(pageState.info.data) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = yellow_bg_card,
                        contentColor = Color.White
                    )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "${item.breed}",
                            style = TextStyle(fontSize = 20.sp)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Text(
                                "Country: ${item.country}",
                                style = TextStyle(fontSize = 15.sp)
                            )
                            Text(
                                "Origin: ${item.origin}",
                                style = TextStyle(fontSize = 15.sp)
                            )
                            Text(
                                "Pattern: ${item.pattern}",
                                style = TextStyle(fontSize = 15.sp)
                            )
                            Text(
                                "Coat: ${item.coat}",
                                style = TextStyle(fontSize = 15.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}
