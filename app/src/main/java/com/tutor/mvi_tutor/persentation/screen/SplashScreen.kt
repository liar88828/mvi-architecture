package com.tutor.mvi_tutor.persentation.screen

import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.mvi_tutor.R
import com.tutor.mvi_tutor.ui.theme.PrimaryLightColor

@Suppress("DEPRECATION")
@Composable
fun SplashScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.background(PrimaryLightColor),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {

		Image(
			painter = painterResource(
				R.drawable.ic_launcher_foreground
			),
			contentDescription = "Logo",
			modifier = modifier
				.size(200.dp)
				.shadow(
					elevation = 50.dp,
					shape = CircleShape
				)
		)

		Text(
			text = "Splash Screen", color = PrimaryLightColor
		)
//		LaunchedEffect(key1 = true) {
//			delay(5000)
//			navController.navigate(Navigation.homeScreen)
//		}

		android.os.Handler(Looper.getMainLooper())
			.postDelayed({
				navController.navigate(Navigation.homeScreen)
			}, 3000)
	}
}

@Preview
@Composable
private fun SplashScreenPrev() {
	SplashScreen(
		navController = NavHostController(LocalContext.current)

	)

}
