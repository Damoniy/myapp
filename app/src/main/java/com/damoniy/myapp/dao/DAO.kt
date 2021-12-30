package com.damoniy.myapp.dao

interface DAO<T>{
    fun save(t: T)
    fun edit(t: T)
    fun getObjectList(): List<T>
}