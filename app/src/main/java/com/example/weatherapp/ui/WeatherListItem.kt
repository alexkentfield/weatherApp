import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.WeatherResponse
import com.example.weatherapp.data.Weather

@Composable
fun WeatherListItem(response: WeatherResponse) {
    // TODO Made list item to support multiple responses from API in case of duplicate cities, for now only supports 1
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeatherIcon(iconId = response.weather.first().icon)
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = response.name, color = Color.White)
            Text(text = response.weather.first().main +" - " + response.weather.first().description, color = Color.White)
            Text(text = "Current temp = " + kelvinToFahrenheit(response.main.temp) + "F", color = Color.White)
            Text(text = "Temp range = " + kelvinToFahrenheit(response.main.temp_min) + "F" + " - " + kelvinToFahrenheit(response.main.temp_max) + "F", color = Color.White)
            Text(text = "Humidity = " + response.main.humidity +"%", color = Color.White)
        }
    }
}

fun kelvinToFahrenheit(kelvin: Float): Int {
    return ((kelvin - 273.15) * 9 / 5 + 32).toInt()
}
