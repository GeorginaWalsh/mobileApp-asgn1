package org.setu.gwalsh.console.main

import mu.KotlinLogging
import org.setu.gwalsh.console.controllers.StudentController
import org.setu.gwalsh.console.models.StudentMemStore
import org.setu.gwalsh.console.models.StudentModel
import org.setu.gwalsh.console.views.StudentView

val logger = KotlinLogging.logger {}

val students = StudentMemStore()
val studentView = StudentView()
val controller = StudentController()

fun main(args: Array<String>) {
    val neutralMenuBlue = "\u001b[34m"
    val reset = "\u001b[0m"

    println( neutralMenuBlue + "Assignment 1: Kotlin App: Student Recorder Version 1.0.1" + reset )
    StudentController().start()
}
