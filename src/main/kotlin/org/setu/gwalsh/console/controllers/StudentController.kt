package org.setu.gwalsh.console.controllers

import mu.KotlinLogging
import org.setu.gwalsh.console.main.controller
import org.setu.gwalsh.console.models.StudentJSONStore
import org.setu.gwalsh.console.models.StudentModel
import org.setu.gwalsh.console.views.StudentView

class StudentController {

    val students = StudentJSONStore()

    val studentView = StudentView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Student Recording Console App" }
        println("Assignment 1: Kotlin App Version 1.0")
    }

    fun start() {
        org.setu.gwalsh.console.main.logger.info { "Launching Student Recording Console App" }
        println("Assignment 1: Kotlin App Version 1.0")

        var input: Int

        do {
            input = org.setu.gwalsh.console.main.studentView.menu()
            when(input) {
                1 -> controller.add()
                2 -> controller.update()
                3 -> controller.list()
                4 -> controller.search()
                5 -> controller.delete()
                -99 -> controller.dummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        org.setu.gwalsh.console.main.logger.info { "Shutting Down Student Recording Console App" }
    }

    fun menu() :Int { return studentView.menu() }

    fun add(){
        var addStudent = StudentModel()

        if (studentView.addStudentData(addStudent))
            students.create(addStudent)
        else
            logger.info("Student Not Added")
    }

    fun list() {
        studentView.listStudents(students)
    }

    fun update() {

        studentView.listStudents(students)
        var searchStudentId = studentView.getId()
        val updateStudent = search(searchStudentId)

        if(updateStudent != null) {
            if(studentView.updateStudentData(updateStudent)) {
                students.update(updateStudent)
                studentView.showStudent(updateStudent)
                logger.info("Student Information Updated : [ $updateStudent ]")
            }
            else
                logger.info("Student Information Not Updated")
        }
        else
            println("Student Information Not Updated...")
    }

    fun search() {
        val searchStudent = search(studentView.getId())!!
        studentView.showStudent(searchStudent)
    }

    fun search(id: Long) : StudentModel? {
        var foundStudent = students.findOne(id)
        return foundStudent
    }

    fun delete() {
        studentView.listStudents(students)
        var searchStudentId = studentView.getId()
        val deleteStudent = search(searchStudentId)

        if(deleteStudent != null) {
            students.delete(deleteStudent)
            println("Student Information Deleted...")
            studentView.listStudents(students)
        }
        else
            println("Student Information Not Deleted...")
    }


    fun dummyData() {
        students.create(StudentModel(
            studentId = 666,
            name = "Lucifer Morningstar",
            course = "Philosophy",
            year = 2,
            completed = false,
//            courseModules = arrayOf("class1", "class2")
            ))
    }
}
