package com.example.escaneronjetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.escaneronjetpackcompose.ui.navigation.Routes
import com.example.escaneronjetpackcompose.ui.screen.MainEscanner
import com.example.escaneronjetpackcompose.ui.screen.MyQrCodeComposable
import com.example.escaneronjetpackcompose.ui.screen.viewModel.MainEscannerViewModel
import com.example.escaneronjetpackcompose.ui.theme.EscanerOnJetpackComposeTheme
import com.google.zxing.integration.android.IntentIntegrator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EscanerOnJetpackComposeTheme {
                val navigationController = rememberNavController()
                val mainEscannerViewModel: MainEscannerViewModel = hiltViewModel()
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.MainEscanner.route
                ) {

                    composable(Routes.MainEscanner.route) {
                        MainEscanner(navigationController,mainEscannerViewModel)
                    }
                    composable(Routes.MyQrCodeComposable.route){
                        MyQrCodeComposable()
                    }

                }
        }
    }}
    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
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

