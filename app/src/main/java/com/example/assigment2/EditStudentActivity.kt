package com.example.assigment2

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assigment2.model.Model
import com.example.assigment2.model.Student

class EditStudentActivity : AppCompatActivity() {

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("STUDENT_ID") // Get student ID passed from previous activity
        student = Model.shared.students.find { it.id == studentId }

        if (student != null) {
            val nameEditText = findViewById<EditText>(R.id.student_name_edit_text)
            val idEditText = findViewById<EditText>(R.id.student_id_edit_text)

            nameEditText.setText(student?.name)
            idEditText.setText(student?.id)
        }
    }

    fun saveChanges(view: android.view.View) {
        val nameEditText = findViewById<EditText>(R.id.student_name_edit_text)
        val idEditText = findViewById<EditText>(R.id.student_id_edit_text)

        val updatedName = nameEditText.text.toString()
        val updatedId = idEditText.text.toString()

        if (updatedName.isNotEmpty() && updatedId.isNotEmpty()) {
            student?.name = updatedName
            student?.id = updatedId
            Toast.makeText(this, "Student Updated!", Toast.LENGTH_SHORT).show()
            finish() // Close the activity and go back
        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }
}
