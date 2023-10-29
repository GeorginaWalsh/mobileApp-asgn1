package org.setu.gwalsh.console.main

import mu.KotlinLogging
import org.setu.gwalsh.console.controllers.StudentController
import org.setu.gwalsh.console.models.StudentMemStore
import org.setu.gwalsh.console.views.StudentView

import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters

import java.io.File
import java.math.BigInteger
import java.nio.file.Files
import java.security.MessageDigest
import java.util.concurrent.Callable


val logger = KotlinLogging.logger {}

val students = StudentMemStore()
val studentView = StudentView()
val controller = StudentController()

@Command(name = "Main", mixinStandardHelpOptions = true, version = ["Student Recorder CLI 1.1.0"],
    description = ["Records basic student information:\n " +
            "-Student ID number\n " +
            "-Student name\n " +
            "-Student course name\n " +
            "-Student year\n " +
            "Student course completion status"])
class Main : Callable<Int> {

    @Parameters(index = "0", description = ["The file whose checksum to calculate."])
    lateinit var file: File

    @Option(names = ["-a", "--algorithm"], description = ["MD5, SHA-1, SHA-256, ..."])
    var algorithm = "MD5"

    override fun call(): Int {
        val fileContents = Files.readAllBytes(file.toPath())
        val digest = MessageDigest.getInstance(algorithm).digest(fileContents)
        println(("%0" + digest.size * 2 + "x").format(BigInteger(1, digest)))
        return 0
    }
}
fun main(args: Array<String>) {
//    println("Assignment 1: Kotlin App Version 1.0")
    StudentController().start()
}
