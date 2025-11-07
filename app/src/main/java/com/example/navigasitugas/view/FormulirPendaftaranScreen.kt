package com.example.navigasitugas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasitugas.R

@Composable
fun FormulirPendaftaranScreen(
    onSubmitBtnClick: (String, String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val genderList = listOf(
        stringResource(id = R.string.gender_male),
        stringResource(id = R.string.gender_female)
    )
    val statusList = listOf(
        stringResource(id = R.string.status_janda),
        stringResource(id = R.string.status_lajang),
        stringResource(id = R.string.status_duda)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF3E5F5))
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF9575CD))
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.form_title),
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Form Card
        ElevatedCard(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Nama
                Text(text = stringResource(R.string.label_nama), fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text(stringResource(R.string.nama)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Jenis Kelamin
                Text(text = stringResource(R.string.label_jenis_kelamin), fontWeight = FontWeight.Bold)
                genderList.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.selectable(
                            selected = jenisKelamin == item,
                            onClick = { jenisKelamin = item }
                        )
                    ) {
                        RadioButton(
                            selected = jenisKelamin == item,
                            onClick = { jenisKelamin = item }
                        )
                        Text(text = item)
                    }
                }

                // Status
                Text(text = stringResource(R.string.label_status), fontWeight = FontWeight.Bold)
                statusList.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.selectable(
                            selected = status == item,
                            onClick = { status = item }
                        )
                    ) {
                        RadioButton(
                            selected = status == item,
                            onClick = { status = item }
                        )
                        Text(text = item)
                    }
                }

                // Alamat
                Text(text = stringResource(R.string.label_alamat), fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text(stringResource(R.string.alamat)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Tombol Submit
                Button(
                    onClick = { onSubmitBtnClick(nama, jenisKelamin, status, alamat) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.submit),
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}
