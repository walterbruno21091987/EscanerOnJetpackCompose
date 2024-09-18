package com.example.escaneronjetpackcompose.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.escaneronjetpackcompose.ui.screen.viewModel.MyQrCodeViewModel

@Composable
fun MyQrCodeComposable(myQrCodeViewModel: MyQrCodeViewModel= hiltViewModel()) {




    Scaffold {


        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(bitmap=myQrCodeViewModel.getQrCodeBitMap("no se que poner"),"My qr code")
        }
    }
}