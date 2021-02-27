package com.example.assignment.repository

import com.example.assignment.domain.model.Job

interface JobRepository {
    suspend fun get(): List<Job>
    suspend fun getItem(id: String): Job
}