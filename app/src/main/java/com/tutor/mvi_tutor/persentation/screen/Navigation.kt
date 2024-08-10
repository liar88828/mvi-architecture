package com.tutor.mvi_tutor.persentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Navigation {
	val splashScreen = "SplashScreen"
	val homeScreen = "HomeScreen"
	val loginScreen = "LoginScreen"
	val registerScreen = "RegisterScreen"
	val forgotPasswordScreen = "ForgotPasswordScreen"
	val mainScreen = "MainScreen"
}

@Composable
fun OnBoarding(modifier: Modifier) {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = Navigation.splashScreen,
		modifier=modifier
	) {
		composable(
			route = Navigation.splashScreen
		) {
			SplashScreen(navController)
		}
		composable(
			route = Navigation.homeScreen
		) {
			HomeScreen(navController)
		}
	}

}

