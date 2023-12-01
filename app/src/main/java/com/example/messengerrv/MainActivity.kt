package com.example.messengerrv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.messengerrv.home.HomePageScreen
import com.example.messengerrv.subscribers.Subscribers
import com.example.messengerrv.ui.theme.MessengerRVTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessengerRVTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.White
                ) {
//                    HomePageScreen()
                    Subscribers()
                }
            }
        }
    }
}
