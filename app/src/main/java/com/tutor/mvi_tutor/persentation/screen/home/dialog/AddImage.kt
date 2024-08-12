package com.tutor.mvi_tutor.persentation.screen.home.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tutor.mvi_tutor.R
import com.tutor.mvi_tutor.data.model.Tasks

@Composable
fun AddImage(
	onAddRequest: () -> Unit,
	launcher: () -> Unit,
	task: MutableState<Tasks>, modifier: Modifier = Modifier
//	onEvent: (HomeEvent) -> Unit,
//	tasks: MutableList<Tasks>,
) {

	Row(modifier = modifier.fillMaxWidth()) {
		if (task.value.files.size < 3) {
			AddImageButton({ launcher() })
		}
			LazyRow() {
				items(task.value.files.size) { index ->
					ImageCard(
						url = task.value.files[index],
						onRemove = { removeImage(task, index) },
					)
				}
				item {
					ThemePrimaryButton(
						text = "Add",
						onClick = { onAddRequest() },
						modifier = modifier
					)
				}
		}
	}
}

@Composable
private fun AddImageButton(
	launcher: () -> Unit,
	modifier: Modifier = Modifier,
) {
	OutlinedCard(
		modifier = modifier
			.size(50.dp)
			.padding(5.dp)
			.background(color = Color.Transparent)
			.clickable { launcher() },
		colors = CardDefaults.cardColors(containerColor = Color.Transparent)
	) {
		Icon(
			imageVector = Icons.Default.Add,
			contentDescription = "Icon Add",
			modifier
				.fillMaxWidth()
				.padding(10.dp)
		)
	}
}

@Composable
private fun ImageCard(
	url: String,
	onRemove: () -> Unit,
	modifier: Modifier = Modifier
) {
	val test = true

	Card(
		modifier
			.size(50.dp)
			.padding(5.dp), colors = CardDefaults.cardColors(containerColor = Color.Transparent)
	) {
		Box(
			modifier = modifier.fillMaxWidth(),
			contentAlignment = Alignment.Center
		) {

			if (test) {
//				AsyncImage(
//					model = url,
//					contentDescription = "Image"
//				)
				ThemeImageView(
					url = url,
					modifier = modifier.fillMaxWidth(),

				)
			}
			if (test) {
				Image(
					painter = painterResource(R.drawable.ic_launcher_foreground),
					contentDescription = "Image",
					modifier = modifier.fillMaxWidth()

				)
			}

			Icon(imageVector = Icons.Default.Close,
				contentDescription = "Close Icon",
				modifier = modifier
					.size(20.dp)
//					.padding(end = 4.dp, top = 4.dp)
					.clickable {
						onRemove()
					})

		}

	}

}

//@Preview
//@Composable
//private fun AddImagePrev() {
//	AddImage(
//		onAddRequest = {},
//		launcher = {},
//		task = remember {
//			mutableStateOf(
//				Tasks(
//					taskId = 0, name = "", detail = "", date = "", files = mutableListOf()
//				)
//			)
//		}
////		onEvent = {},
////		tasks = mutableListOf()
//	)
//}