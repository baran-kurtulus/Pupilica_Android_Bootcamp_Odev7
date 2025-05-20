package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    suspend fun todoYukle(): List<Todo>

    @Insert
    suspend fun kaydet(todo: Todo)

    @Update
    suspend fun guncelle(todo: Todo)

    @Delete
    suspend fun sil(todo: Todo)

    @Query("SELECT * FROM todo WHERE name LIKE '%'|| :aramaKelimesi ||'%'")
    suspend fun ara(aramaKelimesi: String): List<Todo>
}