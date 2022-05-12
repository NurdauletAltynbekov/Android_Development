package com.example.myapplication.fragments.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.TaskViewModel
import kotlinx.android.synthetic.main.fragment_task.view.*

class TaskFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_task, container, false)

        //Recyclerview
        adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UserViewModel
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.readAllData.observe(viewLifecycleOwner, Observer { task -> adapter.setData(task)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_taskFragment4_to_addFragment)
        }
        return view
    }


}