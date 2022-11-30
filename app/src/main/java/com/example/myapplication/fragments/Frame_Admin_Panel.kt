package com.example.myapplication.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel
import com.example.myapplication.Room.User

@Composable
fun Frame_Admin_Panel(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Button(onClick = {navController.navigate("Fragment_User_Add") }) {
            Text(text = "Добавить пользователя")
        }

        val allUsers by viewModel.allUsers.observeAsState(listOf())

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val list = allUsers

            item {
                TitleRow(head1 = "ID", head2 = "Логин", head3 = "Пароль", head4 = "Должность")
            }

            items(list) { user ->
                UserRow(
                    id = user.id, login = user.login,
                    password = user.password, access_rule = user.access_rule
                )
            }
        }

    }
}

@Composable
fun TitleRow(head1: String, head2: String, head3: String, head4: String) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            head1, color = White,
            modifier = Modifier
                .weight(0.1f)
        )
        Text(
            head2, color = White,
            modifier = Modifier
                .weight(0.2f)
        )
        Text(
            head3, color = White,
            modifier = Modifier.weight(0.2f)
        )
        Text(
            head4, color = White,
            modifier = Modifier.weight(0.4f)
        )
    }
}

@Composable
fun UserRow(id: Int, login: String, password: String, access_rule:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(id.toString(), modifier = Modifier
            .weight(0.1f))
        Text(login, modifier = Modifier.weight(0.2f))
        Text(password.toString(), modifier = Modifier.weight(0.2f))
        Text(access_rule.toString(), modifier = Modifier.weight(0.4f))
    }
}


