package com.example.myapplication.fragments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel
import com.example.myapplication.Room.MedicalCard


@Composable
fun Frame_Add_Medical_Card(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

        var patient by remember { mutableStateOf(TextFieldValue("")) }
        var medical_report by remember { mutableStateOf(TextFieldValue("")) }

        Spacer(modifier = Modifier.height(30.dp))
        Text("Введите id пациента")
        TextField(
            value = patient,
            onValueChange = { newText ->
                patient = newText
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text("Введите Диагноз пациента")
        TextField(
            value = medical_report,
            modifier = Modifier.defaultMinSize(minHeight = 120.dp, minWidth = 360.dp),
            onValueChange = { newText ->
                medical_report = newText
            },
        )

        Button(onClick = {
            viewModel.insertMedicalCard(MedicalCard(patient.text,medical_report.text))
            navController.popBackStack()

        }) {
            Text(text = "Добавить")
        }
    }
}