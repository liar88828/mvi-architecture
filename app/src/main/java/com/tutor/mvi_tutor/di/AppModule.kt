package com.tutor.mvi_tutor.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsModule {
	@Provides
	fun repositoryProvider(): MyRepository {
		return MyRepositoryImpl()

	}

}