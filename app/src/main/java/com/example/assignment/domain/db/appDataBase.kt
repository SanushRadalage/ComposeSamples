package com.example.assignment.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.assignment.domain.db.converters.ObjectConverter
import com.example.assignment.domain.db.entities.JobDao
import com.example.assignment.domain.model.Job

@Database(
    entities = [Job::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ObjectConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getJobDao(): JobDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Jobs.db"
            ).build()

    }

}