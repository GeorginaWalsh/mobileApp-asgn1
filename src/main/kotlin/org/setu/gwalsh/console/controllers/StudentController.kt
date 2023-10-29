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

    val neutralMenuBlue = "\u001b[34m"
    val badInputRed = "\u001b[31m"
    val goodInputGreen = "\u001b[32m"
    val reset = "\u001b[0m"

    init {
        logger.info { neutralMenuBlue + "Launching Student Recording Console App" + reset}
    }

    fun start() {

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
                -1 -> println(goodInputGreen + "Exiting App")
                else -> println(badInputRed + "Invalid Option" + reset)
            }
            println()
        } while (input != -1)
        org.setu.gwalsh.console.main.logger.info { goodInputGreen + "Shutting Down Student Recording Console App" }
    }

    fun menu() :Int { return studentView.menu() }

    fun add(){
        var addStudent = StudentModel()

        if (studentView.addStudentData(addStudent)) {
            students.create(addStudent)
            println(goodInputGreen + "Student Added" + reset)
        } else
            logger.info(badInputRed + "Student Not Added" + reset)
    }

    fun list() {
        println(goodInputGreen + "Listing Students" + reset)
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
                logger.info(goodInputGreen + "Student Information Updated : [ $updateStudent ]" + reset)
            }
            else
                logger.info(badInputRed + "Student Information Not Updated" + reset)
        }
        else
            println(badInputRed + "Student Information Not Updated..." + reset)
    }

    fun search() {
        val searchStudent = search(studentView.getId())!!
        println(goodInputGreen + "Searching for Student: " + reset)
        studentView.showStudent(searchStudent)
    }

    fun search(id: Long) : StudentModel? {
        var foundStudent = students.findOne(id)
        println(goodInputGreen + "Searching for Student: " + reset)
        return foundStudent
    }

    fun delete() {
        studentView.listStudents(students)
        var searchStudentId = studentView.getId()
        val deleteStudent = search(searchStudentId)

        if(deleteStudent != null) {
            students.delete(deleteStudent)
            println(goodInputGreen + "Student Information Deleted..." + reset)
            studentView.listStudents(students)
        }
        else
            println(badInputRed + "Student Information Not Deleted..." + reset)
    }


    fun dummyData() {
        students.create(StudentModel(
            id = 999,
            studentId = 666,
            name = "Lucifer Morningstar",
            course = "Philosophy",
            year = 2,
            completed = false,
//            courseModules = arrayOf("class1", "class2")
            ))
    }
}
