package com.tutor.mvi_tutor.persentation.event

import com.tutor.mvi_tutor.data.model.Tasks

sealed interface HomeEvent {
	data object ToggleDialog : HomeEvent
	data object CloseDialog : HomeEvent
	data class AddTask(val task: Tasks) : HomeEvent
	data class CompleteTask(val index: Int) : HomeEvent
	data class OpenDialog(val task: Tasks) : HomeEvent
}