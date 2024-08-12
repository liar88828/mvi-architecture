package com.tutor.mvi_tutor.persentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tutor.mvi_tutor.persentation.screen.home.HomeScreen
import com.tutor.mvi_tutor.persentation.viewmodel.HomeViewModel

object Navigation {
	val splashScreen = "SplashScreen"
	val homeScreen = "HomeScreen"
	val loginScreen = "LoginScreen"
	val registerScreen = "RegisterScreen"
	val forgotPasswordScreen = "ForgotPasswordScreen"
	val mainScreen = "MainScreen"
}

@Composable
fun OnBoarding(
	viewModel: HomeViewModel,
	modifier: Modifier,

	) {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = Navigation.splashScreen,
		modifier = modifier
	) {
		composable(
			route = Navigation.splashScreen
		) {
			SplashScreen(navController)
		}
		composable(
			route = Navigation.homeScreen
		) {
			val homeState by viewModel.homeState.collectAsState()
			HomeScreen(
				navController,
				homeState = homeState,
				onEvent =  viewModel::homeEvent

			)
		}
	}

}

