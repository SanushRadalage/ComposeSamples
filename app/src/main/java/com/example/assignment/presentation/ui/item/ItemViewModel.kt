package com.example.assignment.presentation.ui.item

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.assignment.presentation.ui.list.StateHandler
import com.example.assignment.repository.JobRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ItemViewModel @ViewModelInject constructor(
    private val jobRepository: JobRepository,
) : ViewModel() {

    var id: String? = null

    var stateHandler: StateHandler? = null

    fun getItem() {
        CoroutineScope(IO).launch {
            try {
                val result = jobRepository.getItem(id!!)
                stateHandler!!.onSuccess(result)
            } catch (e: Exception) {
                stateHandler!!.onFailure()
            }
        }
    }
}