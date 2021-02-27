package com.example.assignment.di

import com.example.assignment.network.RetrofitService
import com.example.assignment.network.model.JobDtoMapper
import com.example.assignment.repository.JobRepository
import com.example.assignment.repository.JobRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(
            retrofitService: RetrofitService,
            jobDtoMapper: JobDtoMapper
    ): JobRepository {
        return JobRepositoryImpl(retrofitService, jobDtoMapper)
    }
}