package com.example.minhaarteeumapeca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.minhaarteeumapeca.navigation.AppNavigation
import com.example.minhaarteeumapeca.ui.theme.MinhaArteeumaPecaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MinhaArteeumaPecaTheme {
                AppNavigation()
            }
        }
    }
}
