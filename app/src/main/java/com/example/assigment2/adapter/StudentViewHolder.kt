package com.idz.colman24class2.viewholder

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment2.OnItemClickListener
import com.example.assigment2.R
import com.example.assigment2.model.Student


class StudentViewHolder(itemView: View, private val listener: OnItemClickListener?) :
    RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.sudent_row_name_text_view)
    private val idTextView: TextView = itemView.findViewById(R.id.sudent_row_id_text_view)
    private val checkBox: CheckBox = itemView.findViewById(R.id.sudent_row_check_box)
    private var student: Student? = null

    init {
        itemView.setOnClickListener {
            listener?.onItemClick(student) // Send the student object when clicked
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            student?.isChecked = isChecked // Update the student's check status
        }
    }

    fun bind(student: Student?, position: Int) {
        this.student = student
        nameTextView.text = student?.name
        idTextView.text = student?.id
        checkBox.isChecked = student?.isChecked ?: false
    }
}
