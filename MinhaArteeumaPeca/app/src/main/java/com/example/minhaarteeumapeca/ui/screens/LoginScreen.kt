package com.example.minhaarteeumapeca.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minhaarteeumapeca.ui.theme.Cinza
import com.example.minhaarteeumapeca.ui.theme.Fundo
import com.example.minhaarteeumapeca.ui.theme.VerdeClaro
import com.example.minhaarteeumapeca.ui.theme.VerdeEscuro
import com.example.minhaarteeumapeca.ui.theme.VerdePrincipal

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onCadastroClick: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var senha by remember {
        mutableStateOf("")
    }

    var mostrarSenha by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fundo)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Nome do aplicativo
        Text(
            text = "Minha Arte é uma Peça",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeEscuro
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Arte, história e cultura em um só lugar.",
            fontSize = 16.sp,
            color = Cinza
        )

        Spacer(modifier = Modifier.height(55.dp))

        // Título
        Text(
            text = "Bem-vindo!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeEscuro
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Entre para continuar",
            fontSize = 17.sp,
            color = Cinza
        )

        Spacer(modifier = Modifier.height(28.dp))

        // E-mail
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(
                    text = "E-mail",
                    color = Cinza
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "E-mail",
                    tint = VerdeEscuro
                )
            },
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VerdePrincipal,
                unfocusedBorderColor = VerdePrincipal,
                focusedContainerColor = VerdeClaro,
                unfocusedContainerColor = VerdeClaro
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Senha
        OutlinedTextField(
            value = senha,
            onValueChange = {
                senha = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Senha",
                    color = Cinza
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Senha",
                    tint = VerdeEscuro
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        mostrarSenha = !mostrarSenha
                    }
                ) {
                    Icon(
                        imageVector = if (mostrarSenha) {
                            Icons.Default.VisibilityOff
                        } else {
                            Icons.Default.Visibility
                        },
                        contentDescription = "Mostrar senha",
                        tint = VerdeEscuro
                    )
                }
            },
            visualTransformation = if (mostrarSenha) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VerdePrincipal,
                unfocusedBorderColor = VerdePrincipal,
                focusedContainerColor = VerdeClaro,
                unfocusedContainerColor = VerdeClaro
            )
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Botão Entrar
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdePrincipal
            )
        ) {
            Text(
                text = "Entrar",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        // Cadastro
        androidx.compose.foundation.layout.Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Ainda não tem uma conta? ",
                fontSize = 15.sp,
                color = Cinza
            )

            androidx.compose.material3.TextButton(
                onClick = onCadastroClick
            ) {
                Text(
                    text = "Cadastre-se",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = VerdeEscuro
                )
            }
        }
    }
}

