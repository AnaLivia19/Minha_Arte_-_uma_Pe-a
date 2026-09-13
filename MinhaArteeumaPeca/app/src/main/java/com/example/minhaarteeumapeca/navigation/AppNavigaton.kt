package com.example.minhaarteeumapeca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minhaarteeumapeca.ui.screens.CadastroScreen
import com.example.minhaarteeumapeca.ui.screens.HomeScreen
import com.example.minhaarteeumapeca.ui.screens.LoginScreen
import com.example.minhaarteeumapeca.ui.screens.ObrasScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {


        composable("login") {

            LoginScreen(
                onLoginClick = {
                    navController.navigate("home")
                },

                onCadastroClick = {
                    navController.navigate("cadastro")
                }
            )
        }


        composable("cadastro") {

            CadastroScreen(
                onCadastroConcluido = {

                    navController.navigate("home") {

                        popUpTo("cadastro") {
                            inclusive = true
                        }
                    }
                },

                onVoltarLogin = {
                    navController.popBackStack()
                }
            )
        }


        composable("home") {

            HomeScreen(

                onArtistaClick = {
                    navController.navigate("obras")
                },

                onPeriodoClick = {
                    navController.navigate("obras")
                }
            )
        }

        composable("obras") {

            ObrasScreen()
        }
    }
}