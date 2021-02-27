package com.example.assignment.repository

import com.example.assignment.domain.model.Job
import com.example.assignment.network.RetrofitService
import com.example.assignment.network.model.JobDtoMapper

class JobRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val mapper: JobDtoMapper
) : JobRepository {
    override suspend fun get(): List<Job> {
        return mapper.toDomainList(retrofitService.get())
    }

    override suspend fun getItem(id: String): Job {
        return mapper.mapToDomainModel(retrofitService.getItem(id = id))
    }
}