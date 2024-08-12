package com.tutor.mvi_tutor.persentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tutor.mvi_tutor.data.model.Tasks

@Composable
fun TaskItem(
	item: Tasks,
	onCompleted: (Boolean) -> Unit = {},
	onDialog: () -> Unit,
	modifier: Modifier = Modifier,
) {
	val checkState = remember {
		mutableStateOf(false)
	}

	Row(
		modifier
			.fillMaxWidth()
			.padding(horizontal = 10.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Checkbox(
			checked = checkState.value,
			onCheckedChange = {
				checkState.value = checkState.value.not()
			}
		)
		Text(
			text = item.name,
			color = Color.Black
		)
		IconButton({}) {
			Icon(
				imageVector = Icons.Default.FileOpen,
				contentDescription = "File Icon"
			)
		}
	}
}