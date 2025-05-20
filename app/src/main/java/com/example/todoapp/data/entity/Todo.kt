package com.example.todoapp.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todo")
data class Todo(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id") @NonNull val id: Int,
                @ColumnInfo(name = "name") @NonNull val name: String) : Serializable {
}