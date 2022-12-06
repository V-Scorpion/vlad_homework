package com.example.myapplication.fragments

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel
import com.example.myapplication.Room.User
import com.example.myapplication.Static_Var
import kotlin.math.log


@Composable
fun Frame_Login(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Text("Логин")
        var login by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        val searchResults by viewModel.searchResults.observeAsState(listOf())

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
                viewModel.findUser(login.text,password.text)
            }
        )

        Button(modifier = Modifier.width(250.dp), onClick = {
            viewModel.findUser(login.text,password.text)
            if (login.text == "admin" && password.text == "admin") {
                navController.navigate("Fragment_Admin_Panel")
            }
            else {
                try {

                    if (searchResults.get(0).password == password.text && searchResults.get(0).login == login.text) {
                        if (searchResults.get(0).access_rule.equals("Администратор"))
                            navController.navigate("Fragment_Admin_Panel")
                        if (searchResults.get(0).access_rule.equals("Врач"))
                            navController.navigate("Fragment_Doc_Panel")
                        if (searchResults.get(0).access_rule.equals("Пациент")) {
                            navController.navigate("Fragment_Guest_Panel")
                            Static_Var.Current_GUEST_ID = searchResults.get(0).id
                        }
                        Log.e(
                            "TAG",
                            "Frame_Login:" + searchResults.get(0).login + searchResults.get(0).password + " тут его роль  " + searchResults.get(
                                0
                            ).access_rule
                        )
                    }
                } catch (ex: java.lang.Exception) {
                    Log.e("TAG", "Frame_Login: Не верный пароль ",)
                    //   Log.e("TAG", "Frame_Login:" + searchResults.get(0).login + searchResults.get(0).password)
                }
            }
        }) {
            Text(text = "Войти")
        }
        Button(
            modifier = Modifier.width(250.dp),
            onClick = { navController.navigate("Fragment_Registration") }) {
            Text(text = "Зарегистрироватся")
        }
    }
}