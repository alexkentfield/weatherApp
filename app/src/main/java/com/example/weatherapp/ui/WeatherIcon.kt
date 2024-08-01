import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Scale

@Composable
fun WeatherIcon(iconId: String) {
    val url = "https://openweathermap.org/img/wn/$iconId.png"

    val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = url).apply(block = fun ImageRequest.Builder.() {
                scale(Scale.FIT) // Scale the image to fit into the layout
            }).build()
        )

    Box(modifier = Modifier.size(50.dp)) {
        Image(
            painter = painter,
            contentDescription = null, // Content description is not needed for weather icons
            modifier = Modifier.fillMaxSize()
        )
    }
}
