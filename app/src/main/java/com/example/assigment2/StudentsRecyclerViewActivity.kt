package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment2.model.Model
import com.example.assigment2.model.Student
import com.idz.colman24class2.adapter.StudentsRecyclerAdapter


interface OnItemClickListener {
    fun onItemClick(student: Student?)
}

class StudentsRecyclerViewActivity : AppCompatActivity() {

    private var students: MutableList<Student>? = null
    private lateinit var adapter: StudentsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_recycler_view)

        students = Model.shared.students
        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Initialize the adapter
        adapter = StudentsRecyclerAdapter(students, object : OnItemClickListener {
            override fun onItemClick(student: Student?) {
                val intent = Intent(this@StudentsRecyclerViewActivity, StudentDetailsActivity::class.java)
                intent.putExtra("student", student)
                startActivityForResult(intent, REQUEST_CODE_EDIT_STUDENT)
            }
        })

        recyclerView.adapter = adapter
    }

    fun onAddStudentClick(view: View) {
        val intent = Intent(this, AddStudentActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE_ADD_STUDENT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_ADD_STUDENT) {
                students = Model.shared.students
                adapter.set(students)
            } else if (requestCode == REQUEST_CODE_EDIT_STUDENT) {
                val updatedStudent = data?.getParcelableExtra<Student>("updated_student")
                updatedStudent?.let {
                    val index = students?.indexOfFirst { it.id == updatedStudent.id }
                    index?.let { idx ->
                        students?.set(idx, updatedStudent)
                        adapter.notifyItemChanged(idx)
                    }
                }
            }
        }
    }

    companion object {
        const val REQUEST_CODE_ADD_STUDENT = 2
        const val REQUEST_CODE_EDIT_STUDENT = 1
    }
}
