package org.setu.gwalsh.console.models

data class StudentModel(
    var id: Long=0,
    var studentId: Long = 0,
    var name: String = "",
    var course: String = "",
    var year: Int = 1,
    var completed: Boolean = false,
//    var courseModules: Array<String> = arrayOf()
)