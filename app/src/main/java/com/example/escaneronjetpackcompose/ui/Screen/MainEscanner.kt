package com.example.escaneronjetpackcompose.ui.Screen

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.escaneronjetpackcompose.R
import com.example.escaneronjetpackcompose.ui.Component.ButtonWithBackgroundImage
import com.google.zxing.integration.android.IntentIntegrator


@Composable
fun MainEscanner(context: Context){
    Column(modifier = Modifier.fillMaxSize().background(color = Color.Black), verticalArrangement = Arrangement.Center) {
    ButtonWithBackgroundImage(
        imageResId = R.drawable.button_scanner,
        onClick = {

                val integrator= IntentIntegrator(context as Activity?)
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
                integrator.setPrompt("scan your code in the rectangle")
                integrator.setBeepEnabled(true)
                integrator.initiateScan()

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
