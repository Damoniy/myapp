package com.damoniy.myapp.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.model.factory.AbstractFactory
import com.damoniy.myapp.model.factory.StudentFactory
import com.damoniy.myapp.persistence.Persistence

class StudentFormActivity : AppCompatActivity() {

    private val keyExtra: String = "student"
    private val titleEditStudent: String = "Editar aluno"
    private val titleNewStudent: String = "Cadastrar novo aluno"
    private val factory: AbstractFactory<StudentFormActivity> = StudentFactory()

    var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_student_form)
        this.update()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.activity_student_formulary_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.activity_student_formulary_menu_save -> finishFormulary()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun finishFormulary() {
        val studentDAO = Persistence.studentDAO
        factory.create(this)

        if(this.student!!.hasValidId()) {
            studentDAO.edit(this.student!!)
        } else {
            studentDAO.save(this.student!!)
        }

        this.finish()
    }

    private fun update() {
        if(intent.hasExtra(keyExtra)) {
            student = intent.getSerializableExtra(keyExtra) as Student
            fillFields()
            this.title = titleEditStudent
        } else {
            student = Student()
            this.title = titleNewStudent
        }
    }

    private fun fillFields() {
        val name: TextView = findViewById(R.id.activity_student_form_name)
        val email:TextView = findViewById((R.id.activity_student_form_email))
        val tel:TextView = findViewById((R.id.activity_student_form_tel))

        name.text = student!!.name
        email.text = student!!.email
        tel.text = student!!.tel
    }
}