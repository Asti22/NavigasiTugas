package com.example.navigasitugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelamatDatangScreen(onSubmitClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selamat Datang di Aplikasi Pendaftaran!", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onSubmitClick, modifier = Modifier.fillMaxWidth()) {
            Text("Mulai Isi Form")
        }
    }
}
