package com.example.quizapp

object Constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestion():ArrayList<Question>{
        val questionlist= ArrayList<Question>()
        //1
        val que1=Question(
            1,"What conuntry dose this flag belong to ?",
            R.drawable.egypt,
            "Egypt","Tunisia","Syrian","Morocco",
            1


        )
        questionlist.add(que1)
        //2
        val que2=Question(
            2,"What conuntry dose this flag belong to ?",
            R.drawable.argentina,
            "Armenia","Argentina","Austrialia","Austria",
            2


        )
        questionlist.add(que2)
        //3
        val que3=Question(
            3,"What conuntry dose this flag belong to ?",
            R.drawable.brazil,
            "Brunei","Bulgaria","Brazil","Burma",
            3


        )
        questionlist.add(que3)
        //4
        val que4=Question(
            4,"What conuntry dose this flag belong to ?",
            R.drawable.emirate,
            "Egypt","Emirate","England","Estonia",
            2


        )
        questionlist.add(que4)
        //5
        val que5=Question(
            5,"What conuntry dose this flag belong to ?",
            R.drawable.saudio,
            "Saudi Arabia","Saint lucia","Suriname","Seychelles",
            1


        )
        questionlist.add(que5)
        //6
        val que6=Question(
            6,"What conuntry dose this flag belong to ?",
            R.drawable.algazir,
            "Austria","Andorra","Aruba","Algazir",
            4


        )
        questionlist.add(que6)
        //7
        val que7=Question(
            7,"What conuntry dose this flag belong to ?",
            R.drawable.canada,
            "Canada","Chile","Cuba","chad",
            1


        )
        questionlist.add(que7)
        //8
        val que8=Question(
            8,"What conuntry dose this flag belong to ?",
            R.drawable.palestine,
            "Syrian","peru","Palestine","panam",
            3


        )
        questionlist.add(que8)
        //9
        val que9=Question(
            9,"What conuntry dose this flag belong to ?",
            R.drawable.luxembourg,
            "Latvia","Luxembourg","Liechtenstein","libya",
            2


        )
        questionlist.add(que9)
        //10
        val que10=Question(
            10,"What conuntry dose this flag belong to ?",
            R.drawable.liechtenstein,
            "Latvia","Luxembourg","Liechtenstein","libya",
            3


        )
        questionlist.add(que10)

        return questionlist
    }
}