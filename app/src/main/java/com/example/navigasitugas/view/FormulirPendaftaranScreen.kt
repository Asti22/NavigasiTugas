package com.example.navigasitugas.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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

    }
