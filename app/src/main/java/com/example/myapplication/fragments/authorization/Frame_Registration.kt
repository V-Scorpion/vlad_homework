package com.example.myapplication.fragments

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel
import com.example.myapplication.Room.User

@Composable
fun Frame_Registration(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Text("Логин")
        var login by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = login,
            onValueChange = { newText ->
                login = newText
            }
        )
        Text("Пароль")
        TextField(
            value = password,
            onValueChange = { newText1 ->
                password = newText1
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            viewModel.insertUser(
                User(
                    login.text,
                    password.text,
                   "Пациент"
                )
            )
            navController.popBackStack()
        }) {
            Text(text = "Зарегистрироватся")
        }
    }
}