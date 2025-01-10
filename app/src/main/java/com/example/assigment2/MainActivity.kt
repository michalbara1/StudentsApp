//package com.example.assigment2
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        val addStudentButton: Button = findViewById(R.id.main_activity_add_student_button)
//        val viewStudentsButton: Button = findViewById(R.id.main_activity_view_students_button)
//
//        addStudentButton.setOnClickListener {
//            val intent = Intent(this, AddStudentActivity::class.java)
//            startActivity(intent)
//        }
//
//        viewStudentsButton.setOnClickListener {
//            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}
