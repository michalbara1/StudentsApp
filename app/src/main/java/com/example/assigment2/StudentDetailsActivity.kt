package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assigment2.model.Student


class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var studentNameTextView: TextView
    private lateinit var studentIdTextView: TextView
    private lateinit var studentPhoneTextView: TextView
    private lateinit var studentAddressTextView: TextView
    private lateinit var studentCheckedCheckBox: CheckBox

    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentNameTextView = findViewById(R.id.student_name)
        studentIdTextView = findViewById(R.id.student_id)
        studentPhoneTextView = findViewById(R.id.student_phone)
        studentAddressTextView = findViewById(R.id.student_address)
        studentCheckedCheckBox = findViewById(R.id.student_checked_checkbox)

        student = intent.getParcelableExtra("student")!!

        // Populate views with the student's current data
        studentNameTextView.text = "Name: ${student.name}"
        studentIdTextView.text = "ID: ${student.id}"
        studentPhoneTextView.text = "Phone: ${student.phone}"
        studentAddressTextView.text = "Address: ${student.address}"
        studentCheckedCheckBox.isChecked = student.isChecked

        val editButton: Button = findViewById(R.id.button_edit_student)
        editButton.setOnClickListener {
            onEditStudentClick()
        }

        // Back button behavior
        val backButton: Button = findViewById(R.id.button_back)
        backButton.setOnClickListener {
            finish()  // Finish the activity and return to the previous one
        }
    }

    fun onEditStudentClick() {
        val intent = Intent(this, EditStudentActivity::class.java)
        intent.putExtra("STUDENT_ID", student.id)
        startActivityForResult(intent, REQUEST_CODE_EDIT_STUDENT)
    }

    companion object {
        const val REQUEST_CODE_EDIT_STUDENT = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_EDIT_STUDENT && resultCode == RESULT_OK) {
            val updatedStudent = data?.getParcelableExtra<Student>("updated_student")
            updatedStudent?.let {
                // Update the student's data in the activity
                studentNameTextView.text = "Name: ${it.name}"
                studentIdTextView.text = "ID: ${it.id}"
                studentPhoneTextView.text = "Phone: ${it.phone}"
                studentAddressTextView.text = "Address: ${it.address}"
                studentCheckedCheckBox.isChecked = it.isChecked

                // Pass the updated student data back to StudentsRecyclerViewActivity
                val resultIntent = Intent()
                resultIntent.putExtra("updated_student", it)
                setResult(RESULT_OK, resultIntent)
                finish() // Close the details activity
            }
        }
    }
}
