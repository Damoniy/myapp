package com.damoniy.myapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.entity.Student
import com.damoniy.myapp.persistence.Persistence
import com.damoniy.myapp.ui.activities.views.listeners.StudentFormularyButtonListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListActivity: AppCompatActivity() {

    private lateinit var arrayAdapter: ArrayAdapter<Student>
    private val studentDAO = Persistence.studentDAO

    private val ACTIVITY_TITLE = "Student's List"

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
        when(item.itemId) {
            R.id.activity_student_list_menu_remove -> this.removeStudent(captureStudent(item))
            R.id.activity_student_list_menu_edit -> this.editStudent(captureStudent(item))
        }

        return super.onContextItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        update()
    }

    private fun captureStudent(item: MenuItem): Student {
        val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val student: Student = arrayAdapter.getItem(menuInfo.position)!!
        return student
    }

    private fun update() {
        this.arrayAdapter.clear()
        this.arrayAdapter.addAll(studentDAO.getObjectList())
    }

    private fun createButton() {
        val button: FloatingActionButton = findViewById(R.id.activity_student_list_add_btn)
        button.setOnClickListener(StudentFormularyButtonListener(this))
    }

    private fun configureListView() {
        val studentsListView: ListView = findViewById(R.id.activity_student_list)
        initAdapter(studentsListView)
        registerForContextMenu(studentsListView)
    }


    private fun initAdapter(studentsListView: ListView) {
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1)
        studentsListView.adapter = arrayAdapter
    }

    private fun editStudent(student: Student) {
        val intent = Intent(this, StudentFormActivity::class.java)
        intent.putExtra("student", student)
        startActivity(intent)
    }

    private fun removeStudent(student: Student) {
        Persistence.studentDAO.remove(student)
        this.arrayAdapter.remove(student)
    }
}