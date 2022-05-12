package com.example.myapplication.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setStatuses")
fun setStatus(view: TextView, status: Int){
    when(status){
        0 -> {
            view.text = "High Priority"
        }
        1 -> {
            view.text = "Middle Priority"
        }
        2 -> {
            view.text = "Low Priority"
        }
    }
}