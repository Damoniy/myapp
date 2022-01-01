package com.damoniy.myapp.ui.activities

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student

class StudentListAdapter(private val activity: Activity) : BaseAdapter() {

    private val students: ArrayList<Student> = ArrayList()

    override fun getCount(): Int {
        return students.size
    }

    override fun getItem(position: Int): Student {
        return students[position]
    }

    override fun getItemId(position: Int): Long {
        return students[position].id.toLong()
    }

    fun clear() {
        students.clear()
    }

    fun addAll(list: List<Student>) {
        students.addAll(list)
    }

    fun remove(student: Student) {
        students.remove(student)
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val newView: View = view ?: LayoutInflater.from(activity).inflate(R.layout.item_student, viewGroup, false)
        val name: TextView = newView.findViewById(R.id.item_student_name)
        val email: TextView = newView.findViewById(R.id.item_student_email)
        fillFields(position, name, email)
        return newView
    }

    private fun fillFields(position: Int, name: TextView, email: TextView) {
        val student = students[position]
        name.text = student.name
        email.text = student.email
    }
}