package com.damoniy.myapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.persistence.Persistence
import com.damoniy.myapp.view.adapter.StudentListAdapter
import com.damoniy.myapp.view.listener.StudentFormularyButtonListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListActivity: AppCompatActivity() {

    private lateinit var adapter: StudentListAdapter
    private val studentDAO = Persistence.studentDAO

    private val ACTIVITY_TITLE = "Student's List"
    private val STUDENT_KEY = "student"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = ACTIVITY_TITLE
        this.setContentView(R.layout.activity_student_list)
        this.createButton()
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
        this.update()
    }

    private fun setMenuItemBehavior(item: MenuItem) {
        when (item.itemId) {
            R.id.activity_student_list_menu_remove -> this.removeStudent(captureStudent(item))
            R.id.activity_student_list_menu_edit -> this.editStudent(captureStudent(item))
        }
    }

    private fun captureStudent(item: MenuItem): Student {
        val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val student: Student = adapter.getItem(menuInfo.position)
        return student
    }

    private fun update() {
        this.adapter.update(studentDAO.getObjectList())
    }

    private fun createButton() {
        val button: FloatingActionButton = findViewById(R.id.activity_student_list_add_btn)
        button.setOnClickListener(StudentFormularyButtonListener(this))
    }

    private fun configureListView() {
        val studentsListView: ListView = findViewById(R.id.activity_student_list)
        this.initAdapter(studentsListView)
        this.registerForContextMenu(studentsListView)
    }

    private fun initAdapter(studentsListView: ListView) {
        this.adapter = StudentListAdapter(this)
        studentsListView.adapter = adapter
    }

    private fun editStudent(student: Student) {
        val intent = Intent(this, StudentFormActivity::class.java)
        intent.putExtra(STUDENT_KEY, student)
        this.startActivity(intent)
    }

    private fun removeStudent(student: Student) {
        studentDAO.remove(student)
        this.adapter.remove(student)
    }
}