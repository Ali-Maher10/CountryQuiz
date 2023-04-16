package com.example.quizapp

data class Question(
    val id:Int,
    val question: String,
    val Image:Int,
    val OptionOne:String,
    val OptionTwo:String,
    val OptionThree:String,
    val OptionFour:String,
    val CorrectAnswer:Int
)
