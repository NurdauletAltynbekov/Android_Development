package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<TaskEntity>>
}