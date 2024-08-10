package com.tutor.mvi_tutor.persentation.viewmodel

import androidx.lifecycle.ViewModel
import com.tutor.mvi_tutor.di.MyRepository
import com.tutor.mvi_tutor.persentation.event.HomeEvent
import com.tutor.mvi_tutor.persentation.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
			is HomeEvent.AddTask -> TODO()
			is HomeEvent.CompleteTask -> TODO()
			is HomeEvent.OpenDialog -> TODO()
			HomeEvent.ToggleDialog -> TODO()
			HomeEvent.CloseDialog -> TODO()
		}
	}

	override fun onCleared() {
		super.onCleared()

	}

}