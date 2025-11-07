package com.example.navigasitugas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun FormulirPendaftaranScreen(
    navController: NavController,
    modifier: Modifier = Modifier
    ){
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
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB39DDB))
                .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = stringResource(id = R.string.form_title),
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            contentAlignment = Alignment.Center
        ){
            {
                ElevatedCard (
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_small))
                ){

                }

        }
    }

    }
