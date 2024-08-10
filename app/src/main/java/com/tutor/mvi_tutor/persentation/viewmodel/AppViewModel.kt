package com.tutor.mvi_tutor.persentation.viewmodel

import androidx.lifecycle.ViewModel
import com.tutor.mvi_tutor.di.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel
@Inject constructor(
	private val myRepository: MyRepository
) : ViewModel() {
}