package com.tutor.mvi_tutor.persentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tutor.mvi_tutor.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(modifier: Modifier = Modifier) {
	TopAppBar(
		title = {
			Icon(
				imageVector = Icons.AutoMirrored.Filled.ArrowBack,
				contentDescription = "Back Icon"
			)

		},
		actions = {
			Image(
				painter = painterResource(R.drawable.ic_launcher_foreground),
				contentDescription = "Image avatar",
				modifier
					.height(50.dp)
					.background(
						color = Color.White,
						shape = CircleShape
					)
					.border(
						width = 2.dp,
						color = MaterialTheme.colorScheme.primary,
						shape = CircleShape
					)
			)
		}
	)
}