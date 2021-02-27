package com.example.assignment.network

import com.example.assignment.network.model.JobDto
import com.example.assignment.network.response.JobResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("api/read")
    suspend fun get(): JobResponse

    @GET("api/read/{id}")
    suspend fun getItem(
        @Path("id") id: String
    ): JobDto
}