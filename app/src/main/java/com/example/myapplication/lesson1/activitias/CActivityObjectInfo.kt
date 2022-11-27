package com.example.myapplication.lesson1.activitias

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.text.set
import com.example.myapplication.lesson1.R
import com.example.myapplication.lesson1.databinding.ActivityListBinding
import com.example.myapplication.lesson1.databinding.ActivityObjectInfoBinding
import com.example.myapplication.lesson1.databinding.RecycleviewobjectsItemBinding

class CActivityObjectInfo : AppCompatActivity()

{
    private lateinit var binding: ActivityObjectInfoBinding
    private  var index: Int=-1
    private lateinit var name : String
    private lateinit var description : String


    /******************************************
     * Обработка события создания активности объекта
     *
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_info)

        binding = ActivityObjectInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //принимаем информацию из вызывающей активности
        intent.extras?.let{
            index = it.getInt("KEY_INDEX")   //Надо б заменить названия ключей на текстовые константы из R.string.Description1.toString()
            binding.InputName.setText( it.getString("KEY_OBJECT_NAME")?:"" )
            binding.InputDescription.setText(it.getString("KEY_OBJECT_DESCRIPTION")?:"")
        }?:run{
           // Toast.makeText(this,"Параметры не доступны", Toast.LENGTH_SHORT).show()
         index = -1
            binding.InputName.setText("")
            binding.InputDescription.setText("")
        }

//        if  (intent.extras==null)
//        {
//            // Toast.makeText(this,"Параметры не доступны", Toast.LENGTH_SHORT).show()
//            index = -1
//            binding.InputName.setText("")
//            binding.InputDescription.setText("")
//        }
//        else
//        {
//            index = intent.extras!!.getInt("KEY_INDEX")   //Надо б заменить названия ключей на текстовые константы из R.string.Description1.toString()
//            binding.InputName.setText( intent.extras!!.getString("KEY_OBJECT_NAME")?:"" )
//            binding.InputDescription.setText(intent.extras!!.getString("KEY_OBJECT_DESCRIPTION")?:"")
//        }

        /***************************
         * обработка закрытия активности  и передачи данных при нажатии назад
         */
        onBackPressedDispatcher.addCallback(
            this /* lifecycle owner */,
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    // Back is pressed... Finishing the activity
                    val myIntent = Intent()
                    myIntent.putExtra("KEY_INDEX",index)
                    myIntent.putExtra("KEY_OBJECT_NAME",binding.InputName.text.toString()  )
                    myIntent.putExtra("KEY_OBJECT_DESCRIPTION",binding.InputDescription.text.toString()  )
                    setResult(RESULT_OK,myIntent)
                    finish()
                }
            }
        )
    }
}