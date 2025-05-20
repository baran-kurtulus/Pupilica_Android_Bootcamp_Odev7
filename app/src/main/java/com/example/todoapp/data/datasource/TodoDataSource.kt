package com.example.todoapp.data.datasource

import com.example.todoapp.data.entity.Todo
import com.example.todoapp.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(var todoDao: TodoDao) {

    suspend fun kaydet(name: String){
        val yeniTodo = Todo(0, name)
        todoDao.kaydet(yeniTodo)
    }

    suspend fun guncelle(id: Int, name: String){
        val guncellenenTodo = Todo(id, name)
        todoDao.guncelle(guncellenenTodo)
    }

    suspend fun sil(id: Int){
        val silinenTodo = Todo(id, "")
        todoDao.sil(silinenTodo)
    }

    suspend fun todoYukle(): List<Todo> = withContext(Dispatchers.IO){
        return@withContext todoDao.todoYukle()
    }

    suspend fun todoAra(aramakelimesi: String): List<Todo> = withContext(Dispatchers.IO){
        return@withContext todoDao.ara(aramakelimesi)
    }
}