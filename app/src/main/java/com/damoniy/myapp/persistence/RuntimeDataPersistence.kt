package com.damoniy.myapp.persistence

import com.damoniy.myapp.dao.StudentDAO

abstract class RuntimeDataPersistence {
    val studentDAO = StudentDAO()
}