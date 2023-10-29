package org.setu.gwalsh.tests

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.setu.gwalsh.console.controllers.StudentController
import org.setu.gwalsh.console.main.studentView
import org.setu.gwalsh.console.models.StudentModel
import org.setu.gwalsh.console.views.StudentView

class StudentViewTest {

    val neutralMenuBlue = "\u001b[34m"
    val badInputRed = "\u001b[31m"
    val goodInputGreen = "\u001b[32m"
    val reset = "\u001b[0m"

    @BeforeEach
    fun setup() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun menu() {
    }

    @Test
    fun listStudents() {
    }

    @Test
    fun showStudent() {
    }

    val testSample: StudentView = StudentView()
    val test1 = StudentModel(1, 1, "Klaus Hargreeves", "Theology", 4, false)
    @Test
    fun addStudentData() {
        var testing = studentView.addStudentData(test1)
        assertTrue(testSample.addStudentData(StudentModel(1, 1, "Klaus Hargreeves", "Theology", 4, false)))
    }

    @Test
    fun updateStudentData() {
    }

    @Test
    fun getId() {
    }
}