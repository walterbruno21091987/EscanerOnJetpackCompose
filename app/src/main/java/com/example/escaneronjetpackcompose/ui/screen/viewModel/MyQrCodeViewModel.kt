package com.example.escaneronjetpackcompose.ui.screen.viewModel

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyQrCodeViewModel @Inject constructor():ViewModel(){
    fun getQrCodeBitMap(qrCodeContent:String): ImageBitmap {
        val size=1024
        val hints= hashMapOf<EncodeHintType,Int>().also{
            it[EncodeHintType.MARGIN]=1
        }
        val bits= QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE,size,size,hints)
        val bitmap= Bitmap.createBitmap(size,size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size){
                for(y in 0 until size){
                    val color = if (bits[x, y]) Color.White else Color.Black
                    it.setPixel(x, y, color.toArgb())
                }
            }}
        return bitmap.asImageBitmap()}
}