package com.example.assigment2

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assigment2.model.Student

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var studentNameTextView: TextView
    private lateinit var studentIdTextView: TextView
    private lateinit var studentPhoneTextView: TextView
    private lateinit var studentAddressTextView: TextView
    private lateinit var studentCheckedCheckBox: CheckBox // Added CheckBox for isChecked

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentNameTextView = findViewById(R.id.student_name)
        studentIdTextView = findViewById(R.id.student_id)
        studentPhoneTextView = findViewById(R.id.student_phone)
        studentAddressTextView = findViewById(R.id.student_address)
        studentCheckedCheckBox = findViewById(R.id.student_checked_checkbox)

        // Use getParcelable() for better compatibility
        val student: Student? = intent.getParcelableExtra("student")

        student?.let {
            // Set the student details to the TextViews
            studentNameTextView.text = "Name: ${it.name}"
            studentIdTextView.text = "ID: ${it.id}"
            studentPhoneTextView.text = "Phone: ${it.phone}"
            studentAddressTextView.text = "Address: ${it.address}"

            // Set the CheckBox state based on isChecked
            studentCheckedCheckBox.isChecked = it.isChecked
        }
    }
}
