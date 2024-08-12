package com.tutor.mvi_tutor.persentation.screen.home.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.tutor.mvi_tutor.ui.theme.PrimaryColor
import com.tutor.mvi_tutor.ui.theme.PrimaryLightColor
import com.tutor.mvi_tutor.ui.theme.fontItim

@Composable
fun ThemePrimaryButton(
	text: String,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	shape: Shape = RoundedCornerShape(10.dp),
	colors: ButtonColors = ButtonDefaults.buttonColors(
		containerColor = PrimaryColor,
		contentColor = PrimaryLightColor
	),
	elevation: ButtonElevation? = ButtonDefaults.buttonElevation(
		defaultElevation = 5.dp,
		pressedElevation = 1.dp
	),
	border: BorderStroke? = null,
) {
	Button(
		onClick = onClick,
		modifier = modifier,
		shape = shape,
		colors = colors,
		elevation = elevation
	) {
		Text(
			text = text,
			fontFamily = fontItim
		)
	}
}