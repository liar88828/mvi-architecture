package com.tutor.mvi_tutor.persentation.event

import com.tutor.mvi_tutor.data.model.Tasks

sealed interface HomeEvent {
	data class OnDialog(val isOpen: Boolean) : HomeEvent
	data class AddTask(val task: Tasks) : HomeEvent
	data class CompleteTask(val index: Int) : HomeEvent
	data class AddRequest(val task: Tasks) : HomeEvent
	data class OpenTaskDialog(val task: Tasks) : HomeEvent
	data object CloseTaskDialog : HomeEvent
}