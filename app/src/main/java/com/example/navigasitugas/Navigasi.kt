package com.example.navigasitugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.navigasitugas.view.FormulirPendaftaranScreen
import com.example.navigasitugas.view.ListPesertaScreen
import com.example.navigasitugas.view.SelamatDatangScreen

enum class Navigasi {
    Formulir,
    ListPeserta,
    SelamatDatang
}

@Composable
fun DataApp(
    navController: androidx.navigation.NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.SelamatDatang.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            // 🔹 Halaman Selamat Datang
            composable(route = Navigasi.SelamatDatang.name) {
                SelamatDatangScreen {
                    navController.navigate(Navigasi.Formulir.name)
                }
            }

            // 🔹 Halaman Formulir
            composable(route = Navigasi.Formulir.name) {
                FormulirPendaftaranScreen { nama, jenisKelamin, status, alamat ->
                    navController.navigate(
                        "${Navigasi.ListPeserta.name}/$nama/$jenisKelamin/$status/$alamat"
                    )
                }
            }

            // 🔹 Halaman List Peserta (dengan argumen)
            composable(
                route = "${Navigasi.ListPeserta.name}/{nama}/{jenisKelamin}/{status}/{alamat}",
                arguments = listOf(
                    navArgument("nama") { type = NavType.StringType },
                    navArgument("jenisKelamin") { type = NavType.StringType },
                    navArgument("status") { type = NavType.StringType },
                    navArgument("alamat") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val nama = backStackEntry.arguments?.getString("nama") ?: ""
                val jenisKelamin = backStackEntry.arguments?.getString("jenisKelamin") ?: ""
                val status = backStackEntry.arguments?.getString("status") ?: ""
                val alamat = backStackEntry.arguments?.getString("alamat") ?: ""

                ListPesertaScreen(
                    nama = nama,
                    jenisKelamin = jenisKelamin,
                    status = status,
                    alamat = alamat,
                    onGoHomeClick = {
                        navController.navigate(Navigasi.SelamatDatang.name)
                    },
                    onFormClick = {
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }
        }
    }
}
