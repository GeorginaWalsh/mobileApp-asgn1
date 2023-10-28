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
//        print("Enter modules the student is completing : ")
//        student.courseModules = readln()!!

        return !student.studentId.equals(0) && student.name.isNotEmpty()
    }

    fun updateStudentData(student : StudentModel) : Boolean {

        var tempName: String?
        var tempCourse: String?
        var tempYear: String?
        var tempCompleted: String?

        if (student != null) {
            print("Note: Student ID's cannot be updated.\n\n")
            print("Updating student: " + student + "\n\n")

            print("Enter an updated name. Previous value: [ " + student.name + " ] : ")
            tempName = readln()!!
            if (!tempName.isNullOrEmpty() && !tempName.contains("^[0-9!\"'£$%^&*()_\\-+=<>?{}\\[\\]/\\\\]") ) {
                student.name = tempName
            } else {
                print("Previous entry invalid (Note: Numbers and special characters are not permitted). \nEnter an updated name. Previous value: [ " + student.name + " ] : ")
                tempName = readln()!!
                if (!tempName.isNullOrEmpty() && !tempName.contains("^[0-9!\"'£$%^&*()_\\-+=<>?{}\\[\\]/\\\\]") ) {
                    student.name = tempName
                } else {
                    print("\nRepeated invalid entry - Name unable to be updated.\n")
                }
            }
            print("Enter an updated course name. Previous value: [ " + student.course+ " ] : ")
            tempCourse = readln()!!
            if (!tempCourse.isNullOrEmpty() &&  "[a-zA-Z]+".toRegex().matches(tempCourse)) {
                student.course = tempCourse
            } else {
                print("Previous entry invalid (Note: Numbers are not permitted). \nEnter an updated course. Previous value: [ " + student.course + " ] : ")
                tempCourse = readln()!!
                if (!tempCourse.isNullOrEmpty() && "[a-zA-Z]+".toRegex().matches(tempCourse) ) {
                    student.course = tempCourse
                } else {
                    print("\nRepeated invalid entry - Course name unable to be updated.\n")
                }
            }

            print("Enter an updated number for the student's year within their course. Previous value: [ " + student.year + " ] : ")
            tempYear = readln()!!
            if (tempYear.contains("[1-4]".toRegex())) {
                student.year = tempYear.toInt()
            } else {
                print("Previous entry invalid (Note: Number must be from 1 to 4). \nEnter an updated year. Previous value: [ " + student.year + " ] : ")
                tempYear = readln()!!
                if (tempYear.contains("[1-4]".toRegex())) {
                    student.year = tempYear.toInt()
                } else {
                    print("\nRepeated invalid entry - Year unable to be updated.\n")
                }
            }

            print("Enter an updated completion status. Previous value: [ " + student.completed + " ] (true/false): ")
            tempCompleted = readln()!!
            if (tempCompleted.toBoolean() == true || false) {
                student.completed = tempCompleted.toBoolean()
            } else {
                print("Previous entry invalid (Note: Status must be written as true or false). \nEnter an updated completion status. Previous value: [ " + student.completed + " ] : (true/false)")
                tempCompleted = readln()!!
                if (tempCompleted .toBoolean() == true || false ) {
                    student.completed = tempCompleted.toBoolean()
                } else {
                    print("\nRepeated invalid entry - Completion status unable to be updated.\n")
                }
            }
            return true
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

