package com.example.weatherapp.ui

import WeatherListItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    var query by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = query,
            onValueChange = {
                query = it
                if (query.text.length > 2) {
                    viewModel.fetchWeatherData(it.text)
                }
            },
            label = { Text("Enter city or zip code") },
            modifier = Modifier.fillMaxWidth()
        )

        val weatherData by viewModel.uiState.collectAsState()

        weatherData?.let {
            LazyColumn {
                items(listOf(it)) {
                    WeatherListItem(response = it)
                }
            }
        } ?: run {
            Text(text = "Please enter a correct city name")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        WeatherScreen()
    }
}