package com.example.assigment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView :ListView= findViewById(R.id.stsudents_list_view)
        listView.adapter= StudentsAdapter()
    }
    class StudentsAdapter(): BaseAdapter(){
        override fun getCount(): Int {
            return 10
        }

        override fun getItem(position: Int): Any {
            return 0
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflator= LayoutInflater.from(parent?.context)
            val view= convertView?: inflator.inflate(R.layout.student_list_row,parent,false)

            val nameTextView : TextView = view.findViewById(R.id.sudent_row_name_text_view)
            val idTextView : TextView= view.findViewById(R.id.sudent_row_id_text_view)
            val checkBoc : CheckBox= view.findViewById(R.id.sudent_row_check_box)

            nameTextView.text= "Ben Cohen"
            idTextView.text="123456"
            return view
        }

    }


}