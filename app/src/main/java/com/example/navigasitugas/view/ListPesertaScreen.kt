package com.example.navigasitugas.view

import androidx.compose.runtime.Composable

@Composable
fun ListPesertaScreen(
    navController: NavController,
    nama: String,
    jenisKelamin: String,
    status: String,
    alamat: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB39DDB))
                .padding(vertical = dimensionResource(R.dimen.padding_medium)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.daftar_peserta_title),
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))
        ElevatedCard(
            shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius)),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Text(
                    text = "${stringResource(R.string.label_nama)}: $nama",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${stringResource(R.string.label_jenis_kelamin)}: $jenisKelamin",
                    fontSize = 18.sp
                )
                Text(
                    text = "${stringResource(R.string.label_status)}: $status",
                    fontSize = 18.sp
                )
                Text(
                    text = "${stringResource(R.string.label_alamat)}: $alamat",
                    fontSize = 18.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

        // 🔹 Tombol ke Selamat Datang
        Button(
            onClick = { navController.navigate("selamatDatang") },
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.button_height)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = stringResource(R.string.btn_beranda),
                fontSize = 18.sp,
                color = Color.White
            )
        }

    }
}