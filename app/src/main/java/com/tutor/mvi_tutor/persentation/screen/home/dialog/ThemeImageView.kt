package com.tutor.mvi_tutor.persentation.screen.home.dialog

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun ThemeImageView(url: String, modifier: Modifier) {
	val painter: Painter = rememberAsyncImagePainter(
		model = url,
	)
	Image(
		painter = painter,
		contentDescription = "Image from URL: $url",
		contentScale = ContentScale.Crop,
		modifier = modifier
	)
}