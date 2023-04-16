package com.example.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val tvName :TextView=findViewById(R.id.tv_name)
        val tvScore :TextView=findViewById(R.id.tv_scoer)
        val btnFinish :Button=findViewById(R.id.tv_btn)
        tvName.text=intent.getStringExtra(Constants.USER_NAME)
        val TotalQuestion=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val CorrectAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        tvScore.text="Your score is $CorrectAnswers"
        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}