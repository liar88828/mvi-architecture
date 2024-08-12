package com.tutor.mvi_tutor.persentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tutor.mvi_tutor.di.MyRepository
import com.tutor.mvi_tutor.persentation.event.HomeEvent
import com.tutor.mvi_tutor.persentation.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
	private val myRepository: MyRepository
) : ViewModel() {

	private val _homeState = MutableStateFlow(HomeState())
	val homeState = _homeState.asStateFlow()
	fun homeEvent(event: HomeEvent) {
		when (event) {
			is HomeEvent.AddTask -> addNewTask(event)
			is HomeEvent.CompleteTask -> completeTask(event)
			is HomeEvent.OpenTaskDialog -> openTaskDialog(event)
			is HomeEvent.OnDialog -> onDialog(event)
			is HomeEvent.AddRequest -> TODO()
			HomeEvent.CloseTaskDialog -> closeTaskDialog()

		}
	}

	private fun onDialog(event: HomeEvent.OnDialog) {
		_homeState.update { it.copy(onDialog = event.isOpen) }
	}

	private fun openTaskDialog(event: HomeEvent.OpenTaskDialog) {
		_homeState.update {
			it.copy(
				openTaskDialog = true,
				selectTask = event.task
			)
		}
	}

	private fun closeTaskDialog() {
		_homeState.update {
			it.copy(
				openTaskDialog = false,
			)
		}
	}

	private fun completeTask(event: HomeEvent.CompleteTask) {
		val taskIndex = event.index
		val taskList = _homeState.value.tasks
		val completeTaskList = _homeState.value.completeTaskList
		val task = taskList[taskIndex]

		completeTaskList.add(task)
		taskList.removeAt(taskIndex)
		_homeState.update {
			it.copy(
				tasks = taskList,
				completeTaskList = completeTaskList
			)
		}
	}

	private fun addNewTask(event: HomeEvent.AddTask) {
		val task = event.task
		val taskList = _homeState.value.tasks
		if(task.name.isEmpty()){
			Log.e("NAME_EMPTY", "addNewTask: Name is empty")
			return
		}
		if(task.detail.isEmpty()){
			Log.e("DETAIL_EMPTY", "addNewTask: Detail is empty")
			return
		}
		if(task.date.isEmpty()){
			Log.e("DATE_EMPTY", "addNewTask: Date is empty")
			return
		}

		taskList.add(task)

		_homeState.update {
			it.copy(
				tasks = taskList
			)
		}
	}

	override fun onCleared() {
		super.onCleared()

	}

}