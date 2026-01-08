package com.jclavijo.picoplaca.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.jclavijo.picoplaca.ui.theme.PicoPlacaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PicoPlacaTheme {
                Text(text = "Pico y Placa - Fase 2.1")
            }
        }
    }
}
