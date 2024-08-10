package com.tutor.mvi_tutor.data.model

data class Tasks(
	val taskId: Long,
	val name: String,
	val detail: String,
	val date: String,
	val files: MutableList<String> = mutableListOf()

)
