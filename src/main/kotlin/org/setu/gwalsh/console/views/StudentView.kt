package org.setu.gwalsh.console.views

import org.setu.gwalsh.console.models.StudentModel
import org.setu.gwalsh.console.models.StudentJSONStore


class StudentView {

    val neutralMenuBlue = "\u001b[34m"
    val badInputRed = "\u001b[31m"
    val goodInputGreen = "\u001b[32m"
    val reset = "\u001b[0m"

    fun menu() : Int {

        var option : Int
        var input: String?

        println(neutralMenuBlue + "MAIN MENU")
        println(" 1. Add Student")
        println(" 2. Update Student Information")
        println(" 3. List All Students")
        println(" 4. Search for Student")
        println(" 5. Delete Student")
        println("-1. Exit")
        println()
        print("Enter Option : " + reset)
        input = readln()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listStudents(students: StudentJSONStore) {

        println( neutralMenuBlue +  "List All Students")
        println()
        students.logAll()
        println(reset)
    }

    fun showStudent(student : StudentModel) {
        if(student != null)
            println( neutralMenuBlue + "Student Details [ $student ]" + reset)
        else
            println( badInputRed + "Student Not Found..." + reset)
    }

    fun addStudentData(student : StudentModel) : Boolean {

        println()
        print(neutralMenuBlue + "Enter student ID : " + reset)
        student.studentId = readln().toLong()!!
        print(neutralMenuBlue + "Enter student name : " + reset)
        student.name = readln()!!
        print(neutralMenuBlue + "Enter student course name : " + reset)
        student.course = readln()!!
        print(neutralMenuBlue + "Enter what year the student is in : " + reset)
        student.year = readln().toInt()!!
        print(neutralMenuBlue + "Enter if the student has finished the course (true/false) : " + reset)
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
            print(neutralMenuBlue + "Note: Student ID's cannot be updated.\n\n")
            print("Updating student: " + student + "\n\n" + reset)

            print(neutralMenuBlue + "Enter an updated name. Previous value: [ " + student.name + " ] : " + reset)
            tempName = readln()!!
            if (!tempName.isNullOrEmpty() && !tempName.contains("^[0-9!\"'£$%^&*()_\\-+=<>?{}\\[\\]/\\\\]") ) {
                student.name = tempName
            } else {
                print(badInputRed + "Previous entry invalid (Note: Numbers and special characters are not permitted). " + neutralMenuBlue +
                    "\nEnter an updated name. Previous value: [ " + student.name + " ] : " + reset)
                tempName = readln()!!
                if (!tempName.isNullOrEmpty() && !tempName.contains("^[0-9!\"'£$%^&*()_\\-+=<>?{}\\[\\]/\\\\]") ) {
                    student.name = tempName
                } else {
                    print(badInputRed + "\nRepeated invalid entry - Name unable to be updated.\n" + reset)
                }
            }
            print( neutralMenuBlue + "Enter an updated course name. Previous value: [ " + student.course+ " ] : " + reset)
            tempCourse = readln()!!
            if (!tempCourse.isNullOrEmpty() &&  !tempCourse.contains("^[0-9!\"'£$%^&*()_\\-+=<>?{}\\[\\]/\\\\]")) {
                student.course = tempCourse
            } else {
                print( badInputRed + "Previous entry invalid (Note: Numbers and special characters are not permitted)." + neutralMenuBlue +
                        "\nEnter an updated course. Previous value: [ " + student.course + " ] : " + reset)
                tempCourse = readln()!!
                if (!tempCourse.isNullOrEmpty() && !tempCourse.contains("^[0-9!\"'£$%^&*()_\\-+=<>?{}\\[\\]/\\\\]") ) {
                    student.course = tempCourse
                } else {
                    print( badInputRed + "\nRepeated invalid entry - Course name unable to be updated.\n" + reset)
                }
            }

            print( neutralMenuBlue + "Enter an updated number for the student's year within their course. Previous value: [ " + student.year + " ] : " + reset)
            tempYear = readln()!!
            if (tempYear.contains("[1-4]".toRegex())) {
                student.year = tempYear.toInt()
            } else {
                print( badInputRed + "Previous entry invalid (Note: Number must be from 1 to 4)." + neutralMenuBlue +
                        " \nEnter an updated year. Previous value: [ " + student.year + " ] : " + reset)
                tempYear = readln()!!
                if (tempYear.contains("[1-4]".toRegex())) {
                    student.year = tempYear.toInt()
                } else {
                    print( badInputRed + "\nRepeated invalid entry - Year unable to be updated.\n" + reset)
                }
            }

            print( neutralMenuBlue + "Enter an updated completion status. Previous value: [ " + student.completed + " ] (true/false): " + reset)
            tempCompleted = readln()!!
            if (tempCompleted.toBoolean() == true || tempCompleted.toBoolean() == false) {
                student.completed = tempCompleted.toBoolean()
            } else {
                print( badInputRed + "Previous entry invalid (Note: Status must be written as true or false)." + neutralMenuBlue +
                        " \nEnter an updated completion status. Previous value: [ " + student.completed + " ] : (true/false)" + reset)
                tempCompleted = readln()!!
                if (tempCompleted.toBoolean() == true || tempCompleted.toBoolean() == false ) {
                    student.completed = tempCompleted.toBoolean()
                } else {
                    print( badInputRed + "\nRepeated invalid entry - Completion status unable to be updated.\n" + reset)
                }
            }
            return true
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print( neutralMenuBlue + "Enter id to Search/Update : " + reset)
        strId = readln()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

}

