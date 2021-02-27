package com.example.assignment.presentation.ui.list

import com.example.assignment.domain.model.Job

interface StateHandler {
    fun onSuccess(job: Job)
    fun onFailure()
}