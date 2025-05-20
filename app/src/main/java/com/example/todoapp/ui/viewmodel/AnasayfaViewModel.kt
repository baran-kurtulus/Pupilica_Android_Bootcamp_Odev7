package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var todoRepository: TodoRepository) : ViewModel() {

    val todoListesi = MutableLiveData<List<Todo>>()

    init {
        todoYukle()
    }

    fun sil(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.sil(id)
            todoYukle()
        }
    }

    fun todoYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = todoRepository.todoYukle()
        }
    }

    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = todoRepository.ara(aramaKelimesi)
        }
    }
}