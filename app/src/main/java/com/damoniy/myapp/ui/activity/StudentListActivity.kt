package com.damoniy.myapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.ui.StudentsView

class StudentListActivity: AppCompatActivity() {
    private val activityTitle = "Lista de Estudantes"

    private val studentsView = StudentsView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = activityTitle
        this.setContentView(R.layout.activity_student_list)
        this.studentsView.createButton()
        this.configureListView()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        this.menuInflater.inflate(R.menu.activity_student_list_view_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        this.setMenuItemBehavior(item)
        return super.onContextItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        this.studentsView.update()
    }

    private fun setMenuItemBehavior(item: MenuItem) {
        when (item.itemId) {
            R.id.activity_student_list_menu_remove ->
                this.studentsView.confirmRemoval(this.studentsView.captureStudent(item))
            R.id.activity_student_list_menu_edit ->
                this.studentsView.editStudent(this.studentsView.captureStudent(item))
        }
    }

    private fun configureListView() {
        val studentsListView: ListView = findViewById(R.id.activity_student_list)
        this.studentsView.attachAdapter(studentsListView)
        this.registerForContextMenu(studentsListView)
    }
}