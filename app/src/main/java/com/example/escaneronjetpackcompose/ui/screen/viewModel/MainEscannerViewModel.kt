package com.example.escaneronjetpackcompose.ui.screen.viewModel

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.zxing.integration.android.IntentIntegrator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainEscannerViewModel @Inject constructor(): ViewModel() {
    fun showScanner(context:Context){
        val integrator= IntentIntegrator(context as Activity)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("scan your code in the rectangle")
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }
}