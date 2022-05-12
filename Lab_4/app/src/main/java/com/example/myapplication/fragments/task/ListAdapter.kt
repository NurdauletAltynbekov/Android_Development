package com.example.myapplication.fragments.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.TaskEntity
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var taskList = emptyList<TaskEntity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.itemView.task_id.text = currentItem.id.toString()
        holder.itemView.task_title.text = currentItem.title
        holder.itemView.task_descriprion.text = currentItem.description
        holder.itemView.task_status.text = currentItem.status.toString()
        holder.itemView.task_category.text = currentItem.category.toString()
        holder.itemView.task_duration.text = currentItem.duration.toString()
    }

    fun setData(task: List<TaskEntity>){
        this.taskList = task
        notifyDataSetChanged()
    }
}