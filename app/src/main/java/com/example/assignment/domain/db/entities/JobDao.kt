package com.example.assignment.domain.db.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment.domain.model.Job

@Dao
interface JobDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(job: Job): Long

    @Query("SELECT * FROM Job WHERE jobId = 0")
    suspend fun getJob(): Job
}
