package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mselectedOptionPosition: Int = 0
    private var mUserName:String? = null
    private var mCorrectAnswers: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var imageView: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions2)
        progressBar = findViewById(R.id.tv_progressBar)
        tvProgress = findViewById(R.id.tv_textprogress)
        tvQuestion = findViewById(R.id.tv_question)
        imageView = findViewById(R.id.Iv_Image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.tv_btn)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mQuestionList = Constants.getQuestion()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        imageView?.setImageResource(question.Image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${mQuestionList?.size  }"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.OptionOne
        tvOptionTwo?.text = question.OptionTwo
        tvOptionThree?.text = question.OptionThree
        tvOptionFour?.text = question.OptionFour
        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }
        for (option in options) {

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mselectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.tv_option_one -> {
                tvOptionOne?.let { selectedOptionView(it, 1) }
            }
            R.id.tv_option_two -> {
                tvOptionTwo?.let { selectedOptionView(it, 2) }
            }
            R.id.tv_option_three -> {
                tvOptionThree?.let { selectedOptionView(it, 3) }

            }
            R.id.tv_option_four -> {
                tvOptionFour?.let { selectedOptionView(it, 4) }
            }
            R.id.tv_btn ->{
                if(mselectedOptionPosition==0){
                    mCurrentPosition++
                when
                {
                    mCurrentPosition<=mQuestionList!!.size ->{
                    setQuestion()
                    } else -> {
                        val intent=Intent(this,MainActivity3::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                        startActivity(intent)
                        finish()
                }

                }
                }else {
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.CorrectAnswer != mselectedOptionPosition){
                        answerView(mselectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.CorrectAnswer,R.drawable.correct_option_border_bg)
                    if (mCurrentPosition==mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }else{
                        btnSubmit?.text="Go To Next Question"

                    }
                    mselectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer: Int,drawableView: Int){
        when(answer){
            1 ->{
            tvOptionOne?.background=ContextCompat.getDrawable(this, drawableView)
                 }
            2 ->{
                tvOptionTwo?.background=ContextCompat.getDrawable(this, drawableView)
            }

            3 ->{
                tvOptionThree?.background=ContextCompat.getDrawable(this, drawableView)
            }

            4 ->{
                tvOptionFour?.background=ContextCompat.getDrawable(this, drawableView)
            }

        }
    }
}
