package com.example.escaneronjetpackcompose.ui.Screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.escaneronjetpackcompose.R
import com.example.escaneronjetpackcompose.ui.Component.ButtonWithBackgroundImage
import com.example.escaneronjetpackcompose.ui.Screen.viewModel.MainEscannerViewModel



@Composable
fun MainEscanner(mainEscannerViewModel:MainEscannerViewModel = hiltViewModel()){
   val context= LocalContext.current
    Column(modifier = Modifier.fillMaxSize().background(color = Color.Black), verticalArrangement = Arrangement.Center) {
    ButtonWithBackgroundImage(
        imageResId = R.drawable.button_scanner,
        onClick = {

             mainEscannerViewModel.showScanner(context)

        },
        modifier = Modifier.size(400.dp,100.dp)

    ) {



        Text(
            text = stringResource(id = R.string.SC),
            fontWeight = FontWeight.Bold,

            fontStyle = FontStyle.Italic,
            fontSize = 28.sp,
            color = Color.Black
        )}

}




}
