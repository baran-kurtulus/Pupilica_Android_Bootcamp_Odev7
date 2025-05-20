package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.TodoDataSource
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.data.repo.TodoRepository
import com.example.todoapp.room.TodoDao
import com.example.todoapp.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTodoRepository(todoDataSource: TodoDataSource) : TodoRepository{
        return TodoRepository(todoDataSource)
    }

    @Provides
    @Singleton
    fun provideTodoDataSource(todoDao: TodoDao): TodoDataSource{
        return TodoDataSource(todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao{
        val veriTabani = Room.databaseBuilder(context, VeriTabani::class.java, "tododb.sqlite")
            .createFromAsset("tododb.sqlite")
            .build()

        return veriTabani.getTodoDao()
    }
}