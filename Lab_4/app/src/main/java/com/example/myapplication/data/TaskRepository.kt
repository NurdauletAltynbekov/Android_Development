package com.example.myapplication.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    val readAllData: LiveData<List<TaskEntity>> = taskDao.readAllData()

    suspend fun addTask(taskEntity: TaskEntity){
        taskDao.addTask(taskEntity)
    }

}