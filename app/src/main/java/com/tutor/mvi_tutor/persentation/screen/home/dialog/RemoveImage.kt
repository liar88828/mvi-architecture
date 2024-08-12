package com.tutor.mvi_tutor.persentation.screen.home.dialog

import androidx.compose.runtime.MutableState
import com.tutor.mvi_tutor.data.model.Tasks

fun removeImage(task: MutableState<Tasks>, index: Int) {
	val item = task.value.files.toMutableList()

	item.removeAt(index)
	task.value = task.value.copy(files = item)

}