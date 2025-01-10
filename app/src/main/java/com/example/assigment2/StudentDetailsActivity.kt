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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentNameTextView = findViewById(R.id.student_name)
        studentIdTextView = findViewById(R.id.student_id)
        studentPhoneTextView = findViewById(R.id.student_phone)
        studentAddressTextView = findViewById(R.id.student_address)
        studentCheckedCheckBox = findViewById(R.id.student_checked_checkbox)

        val student: Student? = intent.getParcelableExtra("student")

        student?.let {
            studentNameTextView.text = "Name: ${it.name}"
            studentIdTextView.text = "ID: ${it.id}"
            studentPhoneTextView.text = "Phone: ${it.phone}"
            studentAddressTextView.text = "Address: ${it.address}"

            studentCheckedCheckBox.isChecked = it.isChecked
        }

        val editButton: Button = findViewById(R.id.button_edit_student)
        editButton.setOnClickListener {
            onEditStudentClick()
        }
    }
    fun onEditStudentClick() {
        val student: Student? = intent.getParcelableExtra("student")
        val intent = Intent(this, EditStudentActivity::class.java)

        intent.putExtra("STUDENT_ID", student?.id)
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
                studentNameTextView.text = "Name: ${it.name}"
                studentIdTextView.text = "ID: ${it.id}"
                studentPhoneTextView.text = "Phone: ${it.phone}"
                studentAddressTextView.text = "Address: ${it.address}"
                studentCheckedCheckBox.isChecked = it.isChecked
            }
        }
    }
}

