package com.example.assigment2.adapter

import StudentViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment2.OnItemClickListener
import com.example.assigment2.R
import com.example.assigment2.model.Student

class StudentsRecyclerAdapter(private var students: MutableList<Student>?): RecyclerView.Adapter<StudentViewHolder>() {

    var listener: OnItemClickListener? = null

    // Set the data in the adapter
    fun set(students: MutableList<Student>?) {
        this.students = students
        notifyDataSetChanged()  // Notify adapter of data change
    }

    override fun getItemCount(): Int = students?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflation = LayoutInflater.from(parent.context)
        val view = inflation.inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students?.get(position), position)
    }
}
