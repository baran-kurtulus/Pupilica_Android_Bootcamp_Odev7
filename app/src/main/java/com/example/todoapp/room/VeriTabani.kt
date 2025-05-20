package com.example.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.entity.Todo

@Database(entities = [Todo::class], version = 1)
abstract class VeriTabani : RoomDatabase(){
    abstract fun getTodoDao() : TodoDao
}