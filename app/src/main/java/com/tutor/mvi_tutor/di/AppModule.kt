package com.tutor.mvi_tutor.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

interface MyRepository {

}

@Module
@InstallIn(
	SingletonComponent::class
)
class AppModule {
	@Provides
	@Singleton
	fun provideMyRepository(): MyRepository {
		return MyRepositoryImpl()
	}
}