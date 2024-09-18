package com.example.escaneronjetpackcompose.ui.navigation

sealed class Routes(val route : String){
    data object MainEscanner : Routes("MainEscanner")

    data object MyQrCodeComposable : Routes("MyQrCodeComposable")

}
