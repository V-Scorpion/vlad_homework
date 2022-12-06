package com.example.myapplication.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.MainViewModel

@Composable
fun Frame_Doc_Panel(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {navController.navigate("Fragment_Medical_Card") }) {
            Text(text = "Добавить Диагноз")
        }
        val allMeet by viewModel.allMeeting.observeAsState(listOf())
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val list = allMeet

            item {
                TitleDocRow_Meet(head2 = "Пациент",head3 = "Дата", head4 = "Время")
            }
            items(list) { user ->
                DocsMeetRow(
                    user_Id = user.user_id,
                    date = user.date,
                    time = user.time
                )
            }
        }
    }
}

@Composable
fun TitleDocRow_Meet(head2: String, head3: String, head4: String) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(head2, color = Color.White,
            modifier = Modifier.weight(0.2f))
        Text(head3, color = Color.White,
            modifier = Modifier.weight(0.2f))
        Text(head4, color = Color.White,
            modifier = Modifier.weight(0.2f))
    }
}

@Composable
fun DocsMeetRow(user_Id:String, date: String, time:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(user_Id.toString(), modifier = Modifier.weight(0.2f))
        Text(date.toString(), modifier = Modifier.weight(0.2f))
        Text(time.toString(), modifier = Modifier.weight(0.2f))
    }
}
