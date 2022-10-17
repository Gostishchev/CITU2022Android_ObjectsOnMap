package com.example.myapplication.lesson1

class CActivtyAction
{
    fun actinButton (action : Int,
                     val1 : Int,
                     val2 : Int):Int =
       when(action) {
            1 -> val1 + val2
           2 -> val1 - val2
           3 -> val1 * val2
           4 -> val1 / val2
           else  -> 0


        }


}