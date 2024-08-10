package com.tutor.mvi_tutor.persentation.state

import com.tutor.mvi_tutor.data.model.Tasks

data class HomeState(
	val loading: Boolean = false,
	val showDialog: Boolean = false,
	val openTaskDialog: Boolean = false,
	val selectTask: Tasks? = null,
	val tasks: MutableList<Tasks> = mutableListOf(),
	val completeTaskList: MutableList<Tasks> = mutableListOf(),
	val showError: Boolean = false,
	val errorMessage: String = ""

)