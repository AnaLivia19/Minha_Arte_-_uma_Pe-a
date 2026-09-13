package com.example.minhaarteeumapeca.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minhaarteeumapeca.ui.theme.Fundo
import com.example.minhaarteeumapeca.ui.theme.Texto
import com.example.minhaarteeumapeca.ui.theme.VerdeClaro
import com.example.minhaarteeumapeca.ui.theme.VerdeEscuro

@Composable
fun HomeScreen(
    onArtistaClick: () -> Unit,
    onPeriodoClick: () -> Unit
) {

    var periodoAberto by remember {
        mutableStateOf(false)
    }

    var artistaAberto by remember {
        mutableStateOf(false)
    }

    var periodoSelecionado by remember {
        mutableStateOf("Período")
    }

    var artistaSelecionado by remember {
        mutableStateOf("Artista")
    }

    val periodos = listOf(
        "Renascimento",
        "Barroco",
        "Romantismo",
        "Impressionismo",
        "Modernismo"
    )

    val artistas = listOf(
        "Vincent Van Gogh",
        "Leonardo da Vinci",
        "Pablo Picasso",
        "Claude Monet"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fundo)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(45.dp))

        // LOGO
        Text(
            text = "🎨",
            fontSize = 65.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Minha Arte é uma Peça",
            fontSize = 16.sp,
            color = Texto
        )

        Spacer(modifier = Modifier.height(30.dp))

        // MENUS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box {

                BotaoDropdown(
                    texto = periodoSelecionado,
                    onClick = {
                        periodoAberto = true
                    }
                )

                DropdownMenu(
                    expanded = periodoAberto,
                    onDismissRequest = {
                        periodoAberto = false
                    }
                ) {

                    periodos.forEach { periodo ->

                        DropdownMenuItem(
                            text = {
                                Text(periodo)
                            },
                            onClick = {

                                periodoSelecionado = periodo
                                periodoAberto = false

                                onPeriodoClick()
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(10.dp))


            Box {

                BotaoDropdown(
                    texto = artistaSelecionado,
                    onClick = {
                        artistaAberto = true
                    }
                )

                DropdownMenu(
                    expanded = artistaAberto,
                    onDismissRequest = {
                        artistaAberto = false
                    }
                ) {

                    artistas.forEach { artista ->

                        DropdownMenuItem(
                            text = {
                                Text(artista)
                            },
                            onClick = {

                                artistaSelecionado = artista
                                artistaAberto = false

                                onArtistaClick()
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(45.dp))

        // FRASE
        Text(
            text = "\"Os espelhos são usados para ver o rosto;\nA arte para ver a Alma.\"",
            fontSize = 17.sp,
            color = Texto,
            lineHeight = 27.sp
        )
    }
}

@Composable
fun BotaoDropdown(
    texto: String,
    onClick: () -> Unit
) {

    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = Modifier
            .width(135.dp)
            .height(42.dp),
        shape = RoundedCornerShape(20.dp),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = VerdeClaro,
            contentColor = VerdeEscuro
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = texto,
                fontSize = 13.sp,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "▼",
                fontSize = 10.sp
            )
        }
    }
}