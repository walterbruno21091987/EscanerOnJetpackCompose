package com.example.escaneronjetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.escaneronjetpackcompose.ui.Screen.MainEscanner
import com.example.escaneronjetpackcompose.ui.theme.EscanerOnJetpackComposeTheme
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EscanerOnJetpackComposeTheme {
                MainEscanner(this)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result= IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result!=null){
            if(result.contents==null){
                Toast.makeText(this,"Cancelado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"El valor escaneado es: ${result.contents}", Toast.LENGTH_LONG).show()
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)}

    }
}

