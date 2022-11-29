package com.example.myapplication

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.fragments.*

@SuppressLint("StaticFieldLeak")
    var _navController: NavHostController? = null

    @Composable
    fun NavigationApp(viewModel: MainViewModel) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "Fragment_Login"
        ) {
            composable("Fragment_Login") {
                Frame_Login(navController = navController, viewModel)
            }
            composable("Fragment_Registration") {
                Frame_Registration(navController = navController,viewModel)
            }

            composable("Fragment_User_Add") {
                Frame_User_Add( navController ,viewModel )
            }
            composable("Fragment_Admin_Panel") {
                Frame_Admin_Panel(navController = navController,viewModel)
            }
            composable("Fragment_Guest_Panel") {
                Frame_Guest_Panel( navController ,viewModel )
            }
            composable("Fragment_Doc_Panel") {
                Frame_Doc_Panel( navController ,viewModel )
            }
        }
    }