package com.damoniy.myapp.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListView
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.model.builder.FloatingActionButtonBuilder
import com.damoniy.myapp.persistence.Persistence
import com.damoniy.myapp.ui.activity.StudentFormActivity
import com.damoniy.myapp.ui.adapter.StudentListAdapter
import com.damoniy.myapp.ui.listener.StudentFormularyButtonListener

class StudentsView(private val context: Activity) {
    private val adapter: StudentListAdapter = StudentListAdapter(context)
    private val studentDAO = Persistence.studentDAO
    private val studentKey = "student"

    fun confirmRemoval(student: Student) {
        AlertDialog.Builder(context).setTitle("Remover aluno")
            .setMessage("Tem certeza?")
            .setPositiveButton("Sim") { _: DialogInterface, _: Int -> this.removeStudent(student) }
            .setNegativeButton("Não", null)
            .show()
    }

    fun update() {
        this.adapter.update(studentDAO.getObjectList())
    }

    fun createButton() {
        FloatingActionButtonBuilder.Builder(context, R.id.activity_student_list_add_btn).instance.
        setOnClickListener(StudentFormularyButtonListener(context))
    }

    private fun removeStudent(student: Student) {
        studentDAO.remove(student)
        this.adapter.remove(student)
    }

    private fun attachAdapter(studentsListView: ListView) {
        studentsListView.adapter = adapter
    }

    fun captureStudent(item: MenuItem): Student {
        val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return adapter.getItem(menuInfo.position)
    }

    fun editStudent(student: Student) {
        val intent = Intent(context, StudentFormActivity::class.java)
        intent.putExtra(studentKey, student)
        context.startActivity(intent)
    }

    fun configureListView() {
        val studentsListView: ListView = context.findViewById(R.id.activity_student_list)
        this.attachAdapter(studentsListView)
        context.registerForContextMenu(studentsListView)
    }

    fun setMenuItemBehavior(item: MenuItem) {
        when (item.itemId) {
            R.id.activity_student_list_menu_remove ->
                this.confirmRemoval(this.captureStudent(item))
            R.id.activity_student_list_menu_edit ->
                this.editStudent(this.captureStudent(item))
        }
    }
}