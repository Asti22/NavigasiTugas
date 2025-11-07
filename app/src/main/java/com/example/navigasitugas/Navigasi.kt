package com.example.navigasitugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            // 🔹 Formulir → ke List Peserta
            composable(route = Navigasi.Formulir.name) {
                FormulirPendaftaranScreen(
                    onSubmitBtnClick = { nama, jenisKelamin, status, alamat ->
                        navController.navigate(
                            "${Navigasi.ListPeserta.name}/$nama/$jenisKelamin/$status/$alamat"
                        )
                    }
                )
            }

            // 🔹 List Peserta → ke Selamat Datang & ke Formulir
            composable(
                route = "${Navigasi.ListPeserta.name}/{nama}/{jenisKelamin}/{status}/{alamat}",
                arguments = listOf(
                    androidx.navigation.navArgument("nama") { defaultValue = "" },
                    androidx.navigation.navArgument("jenisKelamin") { defaultValue = "" },
                    androidx.navigation.navArgument("status") { defaultValue = "" },
                    androidx.navigation.navArgument("alamat") { defaultValue = "" }
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

            // 🔹 Selamat Datang → ke List Peserta
            composable(route = Navigasi.SelamatDatang.name) {
                SelamatDatangScreen(
                    onSubmitClick = {
                        navController.navigate(Navigasi.ListPeserta.name + "/Pascal Pahlevi Pasha/Pria/Lajang/Sleman")
                    }
                )
            }
        }
    }
}
