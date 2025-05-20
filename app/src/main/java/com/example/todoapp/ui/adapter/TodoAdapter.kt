package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.ui.fragments.AnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class TodoAdapter(var context: Context, var todoListesi: List<Todo>, var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<TodoAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(context), parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(
        holder: CardTasarimTutucu,
        position: Int
    ) {
        val todo = todoListesi.get(position)
        val t = holder.tasarim

        t.twName.text = todo.name

        t.todoCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(todo)
            Navigation.gecisYap(it, gecis)
        }

        t.imageView.setOnClickListener {
            Snackbar.make(it, "Bu not silinsin mi", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(todo.id)
                }
        }
    }

    override fun getItemCount(): Int {
        return todoListesi.size
    }


}