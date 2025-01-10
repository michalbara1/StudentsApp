package com.example.assigment2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assigment2.model.Model
import com.example.assigment2.model.Student


class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val saveButton: Button = findViewById(R.id.add_student_activity_save_button)
        val cancelButton: Button = findViewById(R.id.add_student_activity_cancel_button)

        val nameEditText: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val idEditText: EditText = findViewById(R.id.add_student_activity_id_edit_text)
        val phoneEditText: EditText = findViewById(R.id.add_student_activity_phone_edit_text)
        val addressEditText: EditText = findViewById(R.id.add_student_activity_address_edit_text)

        val saveMessageTextView: TextView = findViewById(R.id.add_student_activity_save_messeage_textView)

        cancelButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val address = addressEditText.text.toString()

            if (name.isNotEmpty() && id.isNotEmpty() && phone.isNotEmpty() && address.isNotEmpty()) {
                // Create a new student
                val newStudent = Student(
                    name = name,
                    id = id,
                    avatarUrl = "default_avatar_url",
                    isChecked = false,
                    phone = phone,
                    address = address
                )
                Model.shared.students.add(newStudent)

                saveMessageTextView.text = "Student: $name (ID: $id) is saved!"
                setResult(RESULT_OK)
                finish()
            } else {
                saveMessageTextView.text = "Please fill in all fields."
            }
        }
    }
}
