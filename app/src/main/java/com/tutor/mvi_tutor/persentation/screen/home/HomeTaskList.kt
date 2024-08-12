package com.tutor.mvi_tutor.persentation.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tutor.mvi_tutor.persentation.event.HomeEvent
import com.tutor.mvi_tutor.persentation.screen.home.dialog.AddTaskDialog
import com.tutor.mvi_tutor.persentation.state.HomeState

@Composable
fun HomeTaskList(
	homeState: HomeState, onEvent: (HomeEvent) -> Unit
) {
	LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
		if (homeState.tasks.isEmpty()) {
			item {
				Text("No Task")
			}
		} else {
			items(items = homeState.tasks, key = { it.taskId }) { it ->
				TaskItem(it,
					onDialog = { onEvent(HomeEvent.OpenTaskDialog(it)) },
					onCompleted = { check ->
						if (check) {
							onEvent(HomeEvent.CompleteTask(homeState.tasks.indexOf(it)))
						}
					})
			}
		}

		if (homeState.onDialog) {
			item {
				AddTaskDialog(
//					tasks = homeState.tasks,
					onDismissRequest = {
						onEvent(HomeEvent.OnDialog(false))
					},
					onAddRequest = {
						onEvent(HomeEvent.AddTask(it))
						onEvent(HomeEvent.OnDialog(false))
						Log.d("TAG_TASK", "HomeTaskList: $it")
					})
			}
		}
		if (homeState.openTaskDialog

		) {
		}
		if (homeState.loading

		) {
		}
		if (homeState.showError) {

		}
	}
}