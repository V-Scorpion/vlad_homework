package com.example.myapplication.fragments

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel
import com.example.myapplication.Room.User


var access_rule: String=" "
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Frame_User_Add(navController: NavHostController, viewModel: MainViewModel) {
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
        val options = listOf("Администратор", "Врач", "Пациент")
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
                label = { Text("Роль") },
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
                            access_rule = selectionOption
                            Log.e("TAG", "Frame_User_Add: " + access_rule)
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
        Button(onClick = {
            viewModel.insertUser(
                User(
                    login.text,
                    password.text,
                    access_rule.toString()
                )
            )
            Log.e("TAG", "Frame_User_Add: "+access_rule )
        }) {
            Text(text = "Добавить")
        }
    }
}