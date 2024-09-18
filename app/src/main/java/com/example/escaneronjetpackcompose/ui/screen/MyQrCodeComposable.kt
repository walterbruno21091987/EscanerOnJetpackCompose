package com.example.escaneronjetpackcompose.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.Font

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.escaneronjetpackcompose.R
import com.example.escaneronjetpackcompose.ui.screen.viewModel.MyQrCodeViewModel

@Composable
fun MyQrCodeComposable(myQrCodeViewModel: MyQrCodeViewModel= hiltViewModel()) {




    Scaffold {


        Column(modifier = Modifier.background(Color.Black)
            .padding(it)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(width = 0.dp, height =50.dp))

            Text(text = "READ THE CODE",color=Color.White,fontSize = 40.sp, fontFamily = FontFamily(Font(R.font.creepster_regular)) )
            Spacer(modifier = Modifier.size(width = 0.dp, height = 180.dp))
            Image(bitmap=myQrCodeViewModel.getQrCodeBitMap("no se que poner"),"My qr code")
        }
    }
}