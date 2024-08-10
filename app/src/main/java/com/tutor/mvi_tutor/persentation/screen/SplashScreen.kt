package com.tutor.mvi_tutor.persentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.tutor.mvi_tutor.ui.theme.PrimaryLightColor

@Composable
fun SplashScreen(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.background(PrimaryLightColor),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
Text(text = "Splash Screen")

	}
}

@Preview
@Composable
private fun SplashScreenPrev() {
	SplashScreen(
		navController = NavHostController(LocalContext.current)

	)

}