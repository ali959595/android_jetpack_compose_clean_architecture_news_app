package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    //Edited By Ali Mahmoudi(It was Purple200)
    primary = CustomPurple,
    primaryVariant = Purple700,
    //Edited By Ali Mahmoudi(It was Teal200)
    secondary = CustomTeal
)

private val LightColorPalette = lightColors(
    //Edited By Ali Mahmoudi(It was Purple500)
    primary = CustomPurple,
    primaryVariant = Purple700,
    //Edited By Ali Mahmoudi(It was Teal200)
    secondary = CustomTeal

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun FirstProfessionalJetpackComposeApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}