package com.tutor.mvi_tutor.persentation.screen.home.dialog

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.tutor.mvi_tutor.data.model.Tasks
import com.tutor.mvi_tutor.persentation.screen.home.component.DatePickerModal
import com.tutor.mvi_tutor.ui.theme.fontItim
import com.tutor.mvi_tutor.utils.dateUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialog(
//	tasks: MutableList<Tasks>,
	onDismissRequest: () -> Unit,
	onAddRequest: (task: Tasks) -> Unit,
	modifier: Modifier = Modifier
) {
	val task = remember {
		mutableStateOf(
			Tasks(
				taskId = 0, name = "", detail = "", date = "", files = mutableListOf()
			)
		)
	}
	val TAG = "AddTaskDialog"
	val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
		var imageList = task.value.files.toMutableList()
		if (imageList.size < 3) {
			imageList.add(uri.toString())
			task.value = task.value.copy(files = imageList)
			Log.d(TAG, "HomeScreen: $uri")
		}
	}

	var dateDialog by remember { mutableStateOf(false) }

	val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)

	val millisToLocalDate = datePickerState.selectedDateMillis?.let {
		task.value = task.value.copy(date = datePickerState.selectedDateMillis.toString())
		dateUtils.convertMillisToLocalDate(it)
	}
	val dateToString = millisToLocalDate?.let {
		dateUtils.dateToString(millisToLocalDate)
	} ?: ""
	Dialog(
		onDismissRequest = onDismissRequest
	) {

		Card() {
			Column(
				modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
			) {
				Text(
					"Add ", fontFamily = fontItim, style = MaterialTheme.typography.headlineSmall
				)
				Text("${task.value} ")

				OutlinedTextField(modifier = modifier.fillMaxWidth(),
					placeholder = { Text(text = "Task Name") },
					value = task.value.name,
					onValueChange = {
						task.value = task.value.copy(
							name = it
						)
					})

				OutlinedTextField(modifier = modifier.fillMaxWidth(),
					placeholder = { Text(text = "Detail") },
					value = task.value.detail,
					onValueChange = {
						task.value = task.value.copy(
							detail = it
						)
					})
				OutlinedTextField(modifier = modifier.fillMaxWidth(),
					placeholder = { Text(text = "Date") },
					value = dateToString,
					onValueChange = { },
					trailingIcon = {
						IconButton({
							dateDialog = true
						}) {
							Icon(
								imageVector = Icons.Default.DateRange,
								contentDescription = "Date Icon"
							)
						}
					})
				if (dateDialog) {
					DatePickerModal(
						onDateSelected = {
							datePickerState.selectedDateMillis = it
							task.value = task.value.copy(
								date = dateToString
							)
						},
						onDismiss = {
							dateDialog = false
						})
				}
				Row(
					modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween
				) {

					AddImage(
						task = task,
						launcher = { launcher.launch("image/*") },
//						onEvent = {},
						onAddRequest = { onAddRequest(task.value) }
					)

					Button(onClick = {}) {
						Text(text = "Save")
						Spacer(modifier = modifier.padding(2.dp))
						Icon(
							imageVector = Icons.Default.Save,
							contentDescription = "Save Icon",
							modifier = modifier.size(18.dp)

						)
					}
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun HomeDialogPrev() {

	AddTaskDialog(
		onDismissRequest = {},
		onAddRequest = {},
//		tasks = mutableListOf()
	)
}

