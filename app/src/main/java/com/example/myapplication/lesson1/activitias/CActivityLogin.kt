package com.example.myapplication.lesson1.activitias

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.lesson1.R

class CActivityLogin : AppCompatActivity() {
    private lateinit var resultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clogin)

         resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                val tests = data?.getStringExtra("MY_KEY_3")
                val x = 123

              //  doSomeOperations() //операция которая выполняется когда дочерняя активность завершается
            }
        }

    }

    fun onButtonClick(view: View){
        var intent = Intent(this,CActivityList::class.java)
        intent.putExtra("MY_KEY_STRING","Это тестовая строка")
        intent.putExtra("MY_KEY_DOUBLE",123.456)

       // startActivity(intent)
        resultLauncher.launch(intent)


    }


}