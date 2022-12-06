package com.example.myapplication.fragments

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel
import com.example.myapplication.Room.MedicalCard
import com.example.myapplication.Room.Meeting
import com.example.myapplication.Static_Var



@Composable
fun Frame_Add_Medical_Card(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {


        Button(onClick = {
            viewModel.insertMedicalCard(MedicalCard(1,"",""))


            navController.popBackStack()

        }) {
            Text(text = "Добавить")
        }
    }
}