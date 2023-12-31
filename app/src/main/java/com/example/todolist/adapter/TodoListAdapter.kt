package com.example.todolist.adapter



import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.todolist.R
import com.example.todolist.apiservice.model.TodolistItem


class TodoListAdapter (var data : List<TodolistItem?>) : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    fun setTodo(todo: List<TodolistItem?>?){
        if (todo != null) {
            data = todo
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listtodo, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTugas.text = data.get(position)?.tugas
        holder.txtDetail.text = data.get(position)?.detail

        if(data.get(position)?.status == "0"){
            holder.imgStatus.setImageResource(R.drawable.baseline_access_time_24)
        }else {
            holder.imgStatus.setImageResource(R.drawable.baseline_check_24)

        }
    }

    override fun getItemCount():Int = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtTugas = itemView.findViewById<TextView>(R.id.txtTugas)
        val txtDetail = itemView.findViewById<TextView>(R.id.txtDetail)
        val imgStatus = itemView.findViewById<ImageView>(R.id.imgStatus)
    }
}