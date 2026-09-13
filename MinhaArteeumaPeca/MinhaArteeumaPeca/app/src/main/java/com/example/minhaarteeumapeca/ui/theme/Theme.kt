package com.example.minhaarteeumapeca.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = VerdePrincipal,
    secondary = VerdeEscuro,
    tertiary = VerdeClaro,

    background = Fundo,
    surface = Fundo,

    onPrimary = androidx.compose.ui.graphics.Color.White,
    onSecondary = androidx.compose.ui.graphics.Color.White,
    onTertiary = Texto,

    onBackground = Texto,
    onSurface = Texto
)

private val DarkColorScheme = darkColorScheme(
    primary = VerdePrincipal,
    secondary = VerdeClaro,
    tertiary = VerdeEscuro,

    background = Texto,
    surface = Texto,

    onPrimary = androidx.compose.ui.graphics.Color.White,
    onSecondary = Texto,
    onTertiary = androidx.compose.ui.graphics.Color.White,

    onBackground = androidx.compose.ui.graphics.Color.White,
    onSurface = androidx.compose.ui.graphics.Color.White
)

@Composable
fun MinhaArteeumaPecaTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}