package com.example.navigationlesson.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.data.models.ForecastdayModel
import com.example.data.models.HourModel
import com.example.data.models.WeatherModel
import com.example.navigationlesson.R
import com.example.navigationlesson.ui.theme.blue_bg

@Composable
fun Success(weather: WeatherModel, onClick: (IntentsOnClick) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = blue_bg,
                contentColor = Color.White
            )

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val filedCity = remember {
                    mutableStateOf("")
                }
                TextField(
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = blue_bg,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    onValueChange = { text ->
                        filedCity.value = text
                    },
                    maxLines = 1,
                    shape = RoundedCornerShape(8.dp),
                    value = filedCity.value,
                    singleLine = true,
                    trailingIcon = {
                        Button(
                            onClick = {
                                onClick(IntentsOnClick.UpLoad(filedCity.value))
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                        ) {
                            Text("Поиск")
                        }
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            tint = Color.White,
                            contentDescription = "image"
                        )
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)

                )
                Text(
                    "${weather.location.name}",
                    style = TextStyle(fontSize = 30.sp)

                )



                Text(
                    "${weather.current.lastUpdated}",
                    style = TextStyle(fontSize = 15.sp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    AsyncImage(
                        model = "https:${weather.current.condition.icon}",
                        contentDescription = "image2",
                        modifier = Modifier
                            .size(50.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            "${weather.current.tempC?.toInt()}C",
                            style = TextStyle()
                        )
                        Text(
                            "${weather.current.condition.text}",
                            style = TextStyle()
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Row (
                        modifier = Modifier
                            .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.wind_image),
                            contentDescription = "wind_image",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(
                                    end = 5.dp
                                ),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Text(
                            "${weather.current.windKph} km/h"
                        )
                    }
                    Row (
                        modifier = Modifier
                            .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.precip_image),
                            contentDescription = "precip_image",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(
                                    end = 5.dp
                                ),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Text(
                            "${weather.current.precipMm} mm"
                        )
                    }
                }

            }
        }
        tabs(weather.forecast.forecastday)
    }
}

@Composable
fun HourList(hour : List<HourModel>){
    LazyColumn(
        modifier = Modifier
            .padding(
                top = 5.dp,
                bottom = 5.dp
            )
    ){
        items(hour){item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 3.dp
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = blue_bg,
                    contentColor = Color.White
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text("${item.time!!.split("\\s+".toRegex())[1]}")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            "${item.tempC!!.toInt()}C",
                            style = TextStyle(fontSize = 20.sp)
                        )
                        Text(
                            "${item.condition.text}",
                            style = TextStyle(fontSize = 10.sp)
                        )
                    }
                    AsyncImage(
                        model = "https:${item.condition.icon}",
                        contentDescription = "image2",
                        modifier = Modifier
                            .size(30.dp)
                    )



                }

            }
        }
    }
}

@Composable
fun tabs(forecastday: List<ForecastdayModel>) {
    var tabIndex by remember { mutableStateOf(0) }
    var tabTitles: List<String> = arrayListOf()
    forecastday.forEach {
        tabTitles += it.date.toString()
    }

    Column { // 2.
        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp
                ),
            containerColor = blue_bg
        ) { // 3.
            tabTitles.forEachIndexed { index, title ->
                
                Tab(selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = "${title.split("-")[1]}/${title.split("-")[2]}") })
            }
        }
        when (tabIndex) { // 6.
            tabIndex -> HourList(forecastday[tabIndex].hour)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    Success(WeatherModel.empty()) {}
}