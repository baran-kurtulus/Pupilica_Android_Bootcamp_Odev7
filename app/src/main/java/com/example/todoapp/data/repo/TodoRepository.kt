package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.TodoDataSource
import com.example.todoapp.data.entity.Todo

class TodoRepository(var todoDataSource: TodoDataSource) {

    suspend fun kaydet(name: String) = todoDataSource.kaydet(name)

    suspend fun guncelle(id: Int, name: String) = todoDataSource.guncelle(id, name)

    suspend fun sil(id: Int) = todoDataSource.sil(id)

    suspend fun todoYukle() : List<Todo> = todoDataSource.todoYukle()

    suspend fun ara(aramakelimesi: String) : List<Todo> = todoDataSource.todoAra(aramakelimesi)
}