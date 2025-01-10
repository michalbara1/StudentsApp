package com.idz.colman24class2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment2.OnItemClickListener
import com.example.assigment2.R
import com.example.assigment2.model.Student
import com.idz.colman24class2.viewholder.StudentViewHolder

class StudentsRecyclerAdapter(private var students: MutableList<Student>?, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<StudentViewHolder>() {

    // Function to update the list of students and notify the adapter
    fun set(students: MutableList<Student>?) {
        this.students = students
        notifyDataSetChanged()  // Notify that the data has changed
    }

    override fun getItemCount(): Int = students?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students?.get(position), position)
    }
}
