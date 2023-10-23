package org.setu.gwalsh.console.views

import org.setu.gwalsh.console.models.StudentModel
import org.setu.gwalsh.console.models.StudentJSONStore

class StudentView {
    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Student")
        println(" 2. Update Student Information")
        println(" 3. List All Students")
        println(" 4. Search for Student")
        println(" 5. Delete Student")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readln()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listStudents(students: StudentJSONStore) {
        println("List All Students")
        println()
        students.logAll()
        println()
    }

    fun showStudent(student : StudentModel) {
        if(student != null)
            println("student Details [ $student ]")
        else
            println("Student Not Found...")
    }

    fun addStudentData(student : StudentModel) : Boolean {

        println()
        print("Enter student ID : ")
        student.studentId = readln().toLong()!!
        print("Enter student name : ")
        student.name = readln()!!
        print("Enter student course name : ")
        student.course = readln()!!
        print("Enter what year the student is in : ")
        student.year = readln().toInt()!!
        print("Enter if the student has finished the course (true/false) : ")
        student.completed = readln().toBoolean()!!
        print("Enter modules the student is completing : ")
//        student.courseModules = readln()!!

        return !student.studentId.equals(0) && student.name.isNotEmpty()
    }

    fun updateStudentData(student : StudentModel) : Boolean {

        var tempName: String?
        var tempCourse: String?

        if (student != null) {
            print("Enter a new Name for [ " + student.name + " ] : ")
            tempName = readln()!!
            print("Enter a new Course Name for [ " + student.course + " ] : ")
            tempCourse = readln()!!

            if (!tempName.isNullOrEmpty() && !tempCourse.isNullOrEmpty()) {
                student.name = tempName
                student.course = tempCourse
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readln()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

}

