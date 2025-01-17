package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
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

        val studentId = intent.getStringExtra("STUDENT_ID")
        student = Model.shared.students.find { it.id == studentId }

        if (student != null) {
            val nameEditText = findViewById<EditText>(R.id.student_name_edit_text)
            val idEditText = findViewById<EditText>(R.id.student_id_edit_text)
            val phoneEditText = findViewById<EditText>(R.id.student_phone_edit_text)
            val addressEditText = findViewById<EditText>(R.id.student_address_edit_text)
            val checkedCheckBox = findViewById<CheckBox>(R.id.student_checked_checkbox)

            nameEditText.setText(student?.name)
            idEditText.setText(student?.id)
            phoneEditText.setText(student?.phone)
            addressEditText.setText(student?.address)
            checkedCheckBox.isChecked = student?.isChecked ?: false
        }
    }

    fun saveChanges(view: android.view.View) {
        val nameEditText = findViewById<EditText>(R.id.student_name_edit_text)
        val idEditText = findViewById<EditText>(R.id.student_id_edit_text)
        val phoneEditText = findViewById<EditText>(R.id.student_phone_edit_text)
        val addressEditText = findViewById<EditText>(R.id.student_address_edit_text)
        val checkedCheckBox = findViewById<CheckBox>(R.id.student_checked_checkbox)

        val updatedName = nameEditText.text.toString()
        val updatedId = idEditText.text.toString()
        val updatedPhone = phoneEditText.text.toString()
        val updatedAddress = addressEditText.text.toString()
        val isChecked = checkedCheckBox.isChecked

        if (updatedName.isNotEmpty() && updatedId.isNotEmpty() && updatedPhone.isNotEmpty() && updatedAddress.isNotEmpty()) {
            student?.name = updatedName
            student?.id = updatedId
            student?.phone = updatedPhone
            student?.address = updatedAddress
            student?.isChecked = isChecked

            student?.let {
                val studentIndex = Model.shared.students.indexOfFirst { it.id == student?.id }
                if (studentIndex != -1) {
                    Model.shared.students[studentIndex] = it
                    Toast.makeText(this, "Student Updated!", Toast.LENGTH_SHORT).show()
                }
            }

            val resultIntent = Intent()
            resultIntent.putExtra("updated_student", student)
            setResult(RESULT_OK, resultIntent)

            finish()
        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    fun cancelChanges(view: android.view.View) {
        setResult(RESULT_CANCELED)
        finish()
    }
}
