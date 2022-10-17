package com.example.myapplication.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cmain)
        val obj = CObject("Это Имя", "Это описание")

        val button1 : Button = findViewById(R.id.button1);
        val buttonAdd : Button = findViewById(R.id.buttonAdd);
        val buttonMinus : Button = findViewById(R.id.buttonMinus);
        val buttonMulty : Button = findViewById(R.id.buttonMulty);
        val buttonDiv : Button = findViewById(R.id.buttonDiv);
        val editTextInput : EditText = findViewById(R.id.editTextInput);
        val editTextInput2 : EditText = findViewById(R.id.editTextInput2);
        val textViewOutut : TextView = findViewById(R.id.textViewOutput);
        button1.setOnClickListener {
            editTextInput.setText("123")
            obj.name = "Это наименование"
            obj.comments.add(editTextInput.text.toString())

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            textViewOutut.text = "" + obj.comments.size
        }

        //1 +
        //2-
        //3*
        //4/

        buttonAdd.setOnClickListener {
            var val1 : Int = editTextInput.text.toString().toInt()
            var val2 : Int = editTextInput2.text.toString().toInt()
            var action : Int = 1
            obj.comments.add(editTextInput.text.toString())
            val act = CActivtyAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            textViewOutut.text = act.actinButton(action,val1,val2).toString()
        }
        buttonMinus.setOnClickListener {
            var val1 : Int = editTextInput.text.toString().toInt()
            var val2 : Int = editTextInput2.text.toString().toInt()
            var action : Int = 2
            obj.comments.add(editTextInput.text.toString())
            val act = CActivtyAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            textViewOutut.text = act.actinButton(action,val1,val2).toString()
        }
        buttonMulty.setOnClickListener {
            var val1 : Int = editTextInput.text.toString().toInt()
            var val2 : Int = editTextInput2.text.toString().toInt()
            var action : Int = 3
            obj.comments.add(editTextInput.text.toString())
            val act = CActivtyAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            textViewOutut.text = act.actinButton(action,val1,val2).toString()
        }
        buttonDiv.setOnClickListener {
            var val1 : Int = editTextInput.text.toString().toInt()
            var val2 : Int = editTextInput2.text.toString().toInt()
            var action : Int = 4
            obj.comments.add(editTextInput.text.toString())
            val act = CActivtyAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            textViewOutut.text = act.actinButton(action,val1,val2).toString()
        }



    }
}