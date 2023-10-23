package org.setu.gwalsh.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.setu.gwalsh.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "students.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<StudentModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class StudentJSONStore : StudentStore {
    var students = mutableListOf<StudentModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<StudentModel> {
        return students
    }

    override fun findOne(id: Long) : StudentModel? {
        var foundStudent: StudentModel? = students.find { s -> s.studentId == id }
        return foundStudent
    }

    override fun create(student: StudentModel) {
        student.studentId = generateRandomId()
        students.add(student)
        serialize()
    }

    override fun update(student: StudentModel) {
        var foundStudent = findOne(student.studentId!!)
        if (foundStudent != null) {
            foundStudent.name = student.name
            foundStudent.course = student.course
        }
        serialize()
    }

    internal fun logAll() {
        students.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(students, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        students = Gson().fromJson(jsonString, listType)
    }

    override fun delete(student: StudentModel) {
        students.remove(student)
        serialize()
    }
}
