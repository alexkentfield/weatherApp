import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale

@Composable
fun WeatherIcon(iconId: String) {
    val url = "https://openweathermap.org/img/wn/$iconId.png"

    val painter = rememberImagePainter(
        data = url,
        builder = {
            scale(Scale.FIT) // Scale the image to fit into the layout
        }
    )

    Box(modifier = Modifier.size(50.dp)) {
        Image(
            painter = painter,
            contentDescription = null, // Content description is not needed for weather icons
            modifier = Modifier.fillMaxSize()
        )
    }
}
