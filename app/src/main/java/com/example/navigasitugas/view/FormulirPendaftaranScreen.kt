package com.example.navigasitugas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigasitugas.R

@Composable
fun FormulirPendaftaranScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

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
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
    ) {
        // 🔹 Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB39DDB))
                .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.form_title),
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        // 🔹 Card Form
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            contentAlignment = Alignment.Center
        ) {
            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                Column(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // 🔸 Nama Lengkap
                    Text(text = stringResource(R.string.label_nama), fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        label = { Text(stringResource(R.string.nama)) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 🔸 Jenis Kelamin
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

                    // 🔸 Status
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

                    // 🔸 Alamat
                    Text(text = stringResource(R.string.label_alamat), fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        label = { Text(stringResource(R.string.alamat)) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 🔹 Tombol Submit → Navigasi ke List Peserta
                    Button(
                        onClick = {
                            navController.navigate(
                                "listPeserta/$nama/$jenisKelamin/$status/$alamat"
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(id = R.dimen.button_height)),
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
}
