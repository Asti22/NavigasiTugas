package com.example.navigasitugas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasitugas.R

@Composable
fun ListPesertaScreen(
    nama: String,
    jenisKelamin: String,
    status: String,
    alamat: String,
    onGoHomeClick: () -> Unit,
    onFormClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF3E5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.list_title),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A148C)
        )

        Spacer(modifier = Modifier.height(24.dp))

        ElevatedCard(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("${stringResource(R.string.list_nama)} $nama", fontWeight = FontWeight.Bold)
                Text("${stringResource(R.string.list_jenis_kelamin)} $jenisKelamin")
                Text("${stringResource(R.string.list_status)} $status")
                Text("${stringResource(R.string.list_alamat)} $alamat")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onGoHomeClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(stringResource(R.string.go_home), fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onFormClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9575CD)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(stringResource(R.string.back_to_form), fontSize = 18.sp, color = Color.White)
        }
    }
}
