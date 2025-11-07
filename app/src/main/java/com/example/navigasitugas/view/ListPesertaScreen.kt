package com.example.navigasitugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListPesertaScreen(
    nama: String,
    jenisKelamin: String,
    status: String,
    alamat: String,
    onGoHomeClick: () -> Unit,
    onFormClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Data Peserta", fontSize = 22.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Nama: $nama", fontSize = 18.sp)
        Text("Jenis Kelamin: $jenisKelamin", fontSize = 18.sp)
        Text("Status: $status", fontSize = 18.sp)
        Text("Alamat: $alamat", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onGoHomeClick, modifier = Modifier.fillMaxWidth()) {
            Text("Kembali ke Home")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onFormClick, modifier = Modifier.fillMaxWidth()) {
            Text("Isi Form Lagi")
        }
    }
}
