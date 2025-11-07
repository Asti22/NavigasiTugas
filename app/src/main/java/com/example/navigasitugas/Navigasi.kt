package com.example.navigasitugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    Formulir,
    ListPeserta,
    SelamatDatang
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier

){
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Navigasi.Formulir.name) {
                FormulirPendaftaranScreen(
                    onSubmitBtnClick = {
                        navController.navigate(Navigasi.ListPeserta.name)
                    }
                )
        }


}