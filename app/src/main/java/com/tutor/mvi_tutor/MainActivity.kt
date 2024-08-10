package com.tutor.mvi_tutor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import com.tutor.mvi_tutor.persentation.screen.OnBoarding
import com.tutor.mvi_tutor.ui.theme.MVIpatternTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			MVIpatternTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Text("Hello World")
//					OnBoarding(modifier = Modifier.padding(innerPadding))
				}
			}
		}
	}
}

