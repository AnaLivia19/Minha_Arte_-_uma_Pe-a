package com.example.minhaarteeumapeca.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minhaarteeumapeca.ui.theme.Fundo
import com.example.minhaarteeumapeca.ui.theme.Texto

@Composable
fun ObrasScreen() {

    val obras = listOf(
        "Noite\nEstrelada",
        "Girassóis",
        "O Quarto",
        "Terraço do Café",
        "Autorretrato",
        "Os Comedoreas\nde Batata"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fundo)
            .verticalScroll(
                rememberScrollState()
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        // LOGO
        Text(
            text = "🎨",
            fontSize = 60.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Vincent Van Gogh",
            fontSize = 17.sp,
            color = Texto
        )

        Spacer(modifier = Modifier.height(30.dp))

        // PRIMEIRA LINHA
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {

            QuadroObra(
                titulo = obras[0]
            )

            QuadroObra(
                titulo = obras[1]
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // SEGUNDA LINHA
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {

            QuadroObra(
                titulo = obras[2]
            )

            QuadroObra(
                titulo = obras[3]
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // TERCEIRA LINHA
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {

            QuadroObra(
                titulo = obras[4]
            )

            QuadroObra(
                titulo = obras[5]
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}


@Composable
fun QuadroObra(
    titulo: String
) {

    Column(
        modifier = Modifier.size(
            width = 145.dp,
            height = 185.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // MOLDURA EXTERNA
        Box(
            modifier = Modifier
                .size(
                    width = 130.dp,
                    height = 145.dp
                )
                .background(
                    color = Color(0xFFB8864A),
                    shape = RoundedCornerShape(4.dp)
                )
                .border(
                    width = 5.dp,
                    color = Color(0xFF6D4C2A),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {

            // PARTE INTERNA DO QUADRO
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color(0xFFE8E0D2)
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFF8D6E63)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "🖼️",
                    fontSize = 35.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // NOME DA OBRA
        Text(
            text = titulo,
            fontSize = 12.sp,
            color = Texto,
            lineHeight = 16.sp
        )
    }
}