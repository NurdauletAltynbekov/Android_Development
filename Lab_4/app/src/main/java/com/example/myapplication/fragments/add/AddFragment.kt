package com.example.myapplication.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.TaskEntity
import com.example.myapplication.data.TaskViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        //Spinner
        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.statuses)
        )

//        val spinner: Spinner = findViewById(R.id.spinner2)
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.statuses,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

//        spinner.adapter = myAdapter

        view.add_btn.setOnClickListener{
            insertDataToDatabase(myAdapter)
        }

        return view
    }

    private fun insertDataToDatabase(myAdapter: ArrayAdapter<String>) {
        spinner.adapter = myAdapter

        val title = editTitle.text.toString()
        val description = editDescription.text.toString()
        val status = spinner.selectedItemPosition
        val category = spinner2.selectedItemPosition
        val duration = editDuration.text


        if(inputCheck(0,title,description,status,category, duration)){
            val task = TaskEntity(0, title, description, status, category, Integer.parseInt(duration.toString()))

            taskViewModel.addTask(task)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addFragment_to_taskFragment4)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(
        id: Int,
        title: String,
        description: String,
        status: Int,
        categoty: Int,
        duration: Editable
    ): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description)  && duration.isEmpty())
    }

    //&& TextUtils.isEmpty(
    //            status.toString()) && TextUtils.isEmpty(categoty.toString())
}