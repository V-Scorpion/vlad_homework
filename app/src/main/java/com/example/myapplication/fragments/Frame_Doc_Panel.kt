package com.example.myapplication.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel

@Composable
fun Frame_Doc_Panel(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {navController.navigate("Fragment_User_Add") }) {
            Text(text = "Панель доктора")
        }
    }
}