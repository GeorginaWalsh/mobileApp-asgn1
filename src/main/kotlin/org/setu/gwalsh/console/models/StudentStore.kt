package org.setu.gwalsh.console.models

interface StudentStore {
    fun findAll(): List<StudentModel>
    fun findOne(id: Long): StudentModel?
    fun create(student: StudentModel)
    fun update(student: StudentModel)
    fun delete(student: StudentModel)
}