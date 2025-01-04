package com.example.assigment2.model

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()

    companion object{
        val shared= Model()
    }

    init{
        for(i in 0..20){
            val students= Student(
                name="Name $i"
            )

        }
    }
}