package com.example.minhaarteeumapeca.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minhaarteeumapeca.ui.theme.Texto
import com.example.minhaarteeumapeca.ui.theme.VerdePrincipal
import com.example.minhaarteeumapeca.ui.theme.VerdeEscuro
import com.google.firebase.auth.FirebaseAuth

@Composable
fun CadastroScreen(
    onCadastroConcluido: () -> Unit,
    onVoltarLogin: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var senha by remember {
        mutableStateOf("")
    }

    var mensagemErro by remember {
        mutableStateOf("")
    }

    var cadastrando by remember {
        mutableStateOf(false)
    }

    val auth = FirebaseAuth.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Logo provisória
        Text(
            text = "🎨",
            fontSize = 65.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Cadastro",
            fontSize = 28.sp,
            color = Texto
        )

        Spacer(modifier = Modifier.height(25.dp))

        // EMAIL
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                mensagemErro = ""
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Email")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        // SENHA
        OutlinedTextField(
            value = senha,
            onValueChange = {
                senha = it
                mensagemErro = ""
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Senha")
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // MENSAGEM DE ERRO
        if (mensagemErro.isNotEmpty()) {
            Text(
                text = mensagemErro,
                color = Color.Red,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        // BOTÃO CADASTRAR
        Button(
            onClick = {

                if (email.isBlank() || senha.isBlank()) {

                    mensagemErro = "Preencha todos os campos."

                } else {

                    cadastrando = true
                    mensagemErro = ""

                    auth.createUserWithEmailAndPassword(
                        email.trim(),
                        senha
                    ).addOnCompleteListener { task ->

                        cadastrando = false

                        if (task.isSuccessful) {

                            // Cadastro realizado no Firebase
                            onCadastroConcluido()

                        } else {

                            mensagemErro =
                                task.exception?.message
                                    ?: "Erro ao realizar cadastro."
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdePrincipal
            ),
            enabled = !cadastrando
        ) {
            Text(
                text = if (cadastrando) {
                    "Cadastrando..."
                } else {
                    "Cadastrar"
                },
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // VOLTAR
        Button(
            onClick = {
                onVoltarLogin()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = VerdeEscuro
            )
        ) {
            Text(
                text = "Voltar para o Login"
            )
        }
    }
}