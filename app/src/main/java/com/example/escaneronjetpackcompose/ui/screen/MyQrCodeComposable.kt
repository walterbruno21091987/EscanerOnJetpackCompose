package com.example.escaneronjetpackcompose.ui.screen

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter

@Composable
fun MyQrCodeComposable() {



    fun getQrCodeBitMap(qrCodeContent:String): ImageBitmap {
        val size=1024
        val hints= hashMapOf<EncodeHintType,Int>().also{
            it[EncodeHintType.MARGIN]=1
        }
        val bits= QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE,size,size,hints)
        val bitmap= Bitmap.createBitmap(size,size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size){
                for(y in 0 until size){
                    val color = if (bits[x, y]) Color.Black else Color.White
                    it.setPixel(x, y, color.toArgb())
                }
            }}
        return bitmap.asImageBitmap()}
    Scaffold {


        Column(modifier = Modifier.padding(it).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(bitmap=getQrCodeBitMap("no se que poner"),"My qr code")
        }
    }
}