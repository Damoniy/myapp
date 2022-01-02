package com.damoniy.myapp.ui.activity

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.ui.StudentsView

class StudentListActivity: AppCompatActivity() {
    private val activityTitle = "Lista de Estudantes"

    private val studentsView = StudentsView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = activityTitle
        this.setContentView(R.layout.activity_student_list)
        this.studentsView.createButton()
        this.studentsView.configureListView()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        this.menuInflater.inflate(R.menu.activity_student_list_view_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        this.studentsView.setMenuItemBehavior(item)
        return super.onContextItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        this.studentsView.update()
    }
}