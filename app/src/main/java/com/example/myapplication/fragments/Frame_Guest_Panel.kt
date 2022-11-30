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
import com.example.myapplication.Static_Var

@Composable
fun Frame_Guest_Panel(navController: NavHostController, viewModel: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {navController.navigate("Fragment_Meet_Add") }) {
            Text(text = "Записатся на прием")
        }
        val allMeet by viewModel.allGuestMeeting.observeAsState(listOf())
        viewModel.findMeet(Static_Var.Current_GUEST_ID.toString())
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val list = allMeet

            item {
                TitleRow_Meet( head3 = "Дата", head4 = "Время")
            }

            items(list) { user ->
                MeetRow(
                    date = user.date, time = user.time
                )
            }
        }
    }
}


@Composable
fun TitleRow_Meet( head3: String, head4: String) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(head3, color = Color.White,
            modifier = Modifier.weight(0.2f))
        Text(head4, color = Color.White,
            modifier = Modifier.weight(0.2f))
    }
}

@Composable
fun MeetRow( date: String, time:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(date.toString(), modifier = Modifier.weight(0.2f))
        Text(time.toString(), modifier = Modifier.weight(0.2f))
    }
}