package org.setu.gwalsh.console.models

data class StudentModel(
    var studentId: Long = 0,
    var name: String = "",
    var course: String = "",
    var year: Int = 0,
    var completed: Boolean = false,
//    var courseModules: Array<String> = arrayOf()
)