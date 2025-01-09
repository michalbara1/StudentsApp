import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment2.OnItemClickListener
import com.example.assigment2.R
import com.example.assigment2.model.Student

class StudentViewHolder(
    itemView: View,
    listener: OnItemClickListener?
): RecyclerView.ViewHolder(itemView) {

    private var nameTextView: TextView? = null
    private var idTextView: TextView? = null
    private var checkBox: CheckBox? = null
    private var student: Student? = null

    init {
        nameTextView = itemView.findViewById(R.id.sudent_row_name_text_view)
        idTextView = itemView.findViewById(R.id.sudent_row_id_text_view)
        checkBox = itemView.findViewById(R.id.sudent_row_check_box)

        // Handle checkbox state change
        checkBox?.apply {
            setOnCheckedChangeListener { _, isChecked ->
                student?.isChecked = isChecked // Update the student object with checkbox status
            }
        }

        itemView.setOnClickListener {
            listener?.onItemClick(adapterPosition)
            listener?.onItemClick(student)
        }
    }

    fun bind(student: Student?, position: Int) {
        this.student = student
        nameTextView?.text = student?.name
        idTextView?.text = student?.id
        checkBox?.apply {
            isChecked = student?.isChecked ?: false
        }
    }
}
