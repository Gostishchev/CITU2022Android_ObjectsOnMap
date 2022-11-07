package com.example.myapplication.lesson1.models

class CObject(
     var name : String,
     var description : String
    )

{  var comments : MutableList<String> = mutableListOf()

    override fun toString(): String{
        return "name: $name, description: $description"


    }
}