package com.example.myapplication.fragments

import android.util.Log
import androidx.compose.foundation.layout.*
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
import com.example.myapplication.Room.Meeting
import com.example.myapplication.Static_Var

var time :String="9:00"
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Frame_Add_Meeting(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        var date by remember { mutableStateOf(TextFieldValue("")) }

        Text("Введите Дату")


        val pattern = remember { Regex("^\\d+\$") }

        TextField(
            value = date,
            onValueChange = { newText ->
                    date = newText
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text("Время")

        Spacer(modifier = Modifier.height(20.dp))
        val options = listOf(
            "9:00",
            "9:30",
            "10:00",
            "10:30",
            "11:00",
            "11:30",
            "12:00",
            "12:30",
            "13:00",
            "13:30",
            "14:00",
            "14:30",
            "15:00",
            "15:30",
            "16:00",
            "16:30",
            "17:00",
            "17:30",
            "18:00",
            "18:30",
            "19:30",
            "20:00"
        )
        var expanded by remember { mutableStateOf(false) }
        var selectedOptionText by remember { mutableStateOf(options[0]) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("Время Записи") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                            time = selectionOption
                            Log.e("TAG", "Frame_User_Add: " + time)
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }

        Button(onClick = {
            viewModel.insertMeet(
                Meeting(
                    Static_Var.Current_GUEST_ID.toString(), date.text, time.toString()
                )
            )
            navController.popBackStack()

        }) {
            Text(text = "Добавить")
        }
    }


}
