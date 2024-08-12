package com.tutor.mvi_tutor.persentation.screen.home.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ThemePrimaryButton(
	url: String,
	modifier: Modifier = Modifier
) {

	AsyncImage(
		model = url,
		contentDescription = "Image",
	)
}