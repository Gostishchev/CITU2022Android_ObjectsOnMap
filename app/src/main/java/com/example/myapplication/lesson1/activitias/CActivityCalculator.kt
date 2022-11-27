package com.example.myapplication.lesson1.activitias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.*
import androidx.activity.OnBackPressedCallback
import com.example.myapplication.lesson1.classes.CAction
import com.example.myapplication.lesson1.models.CObject
import com.example.myapplication.lesson1.R
import com.example.myapplication.lesson1.databinding.ActivityCalculatorBinding

class CActivityCalculator : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
// передача из дочерней формы
        //или
//        val tests = intent.extras?.getString("MY_KEY_STRING"))
//        val testd = intent.extras?.getString("MY_KEY_DOUBLE"))


        //или
        intent.extras?.let{
            val tests = it.getString("MY_KEY_STRING")
            val testd = it.getString("MY_KEY_DOUBLE")
        }?:run{
            Toast.makeText(this,"Параметры не доступны", Toast.LENGTH_SHORT).show()

        }

        //или
//        if ( intent.extras == null)
//        {
//            Toast.makeText(this,"Параметры не доступны", Toast.LENGTH_SHORT).show()
//        }
//        else
//        {
//           val test_s = intent.extras!!.getString("MY_KEY_STRING")
//            val test_d = intent.extras!!.getDouble("MY_KEY_DOUBLE")
//            val x = 123
//        }


        val obj = CObject("Это Имя", "Это описание")

//        val imageViewAdd: ImageView = findViewById(R.id.imageViewAdd);
//        // val buttonAdd : Button = findViewById(R.id.buttonAdd);
//        val buttonMinus: Button = findViewById(R.id.buttonMinus);
////        val buttonMulty: Button = findViewById(R.id.buttonMulty);
//        val buttonDiv: Button = findViewById(R.id.buttonDiv);
//        val editTextInput: EditText = findViewById(R.id.editTextInput);
//        val editTextInput2: EditText = findViewById(R.id.editTextInput2);
//        val textViewOutput: TextView = findViewById(R.id.textViewOutput);

        //1 +
        //2-
        //3*
        //4/

        binding.imageViewAdd.setOnClickListener {
            val val1: Int = binding.editTextInput.text.toString().toInt()
            val val2: Int = binding.editTextInput2.text.toString().toInt()
            val action: Int = 1
            obj.comments.add(binding.editTextInput.text.toString())
            val act = CAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            binding.textViewOutput.text = act.actinButton(action, val1, val2).toString()
        }


        binding.buttonMinus.setOnClickListener{
            val val1: Int = binding.editTextInput.text.toString().toInt()
            val val2: Int = binding.editTextInput2.text.toString().toInt()
            val action: Int = 2
            obj.comments.add(binding.editTextInput.text.toString())
            val act = CAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            binding.textViewOutput.text = act.actinButton(action, val1, val2).toString()
        }
        binding.buttonMulty.setOnClickListener {
            val val1: Int = binding.editTextInput.text.toString().toInt()
            val val2: Int = binding.editTextInput2.text.toString().toInt()
            val action: Int = 3
            obj.comments.add(binding.editTextInput.text.toString())
            val act = CAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            binding.textViewOutput.text = act.actinButton(action, val1, val2).toString()
        }
        binding.buttonDiv.setOnClickListener {
            val val1: Int = binding.editTextInput.text.toString().toInt()
            val val2: Int = binding.editTextInput2.text.toString().toInt()
            val action: Int = 4
            obj.comments.add(binding.editTextInput.text.toString())
            val act = CAction()

            // Toast.makeText(applicationContext, "Результат выражения : ${obj.comments.size} ", Toast.LENGTH_SHORT).show()
            binding.textViewOutput.text = act.actinButton(action, val1, val2).toString()
        }

        //обработка закрытия активности  и передачи данных при нажатии назад
        onBackPressedDispatcher.addCallback(
            this /* lifecycle owner */,
            object : OnBackPressedCallback(true)
        {
            override fun handleOnBackPressed() {
                // Back is pressed... Finishing the activity
                val myIntent = Intent()
                myIntent.putExtra("MY_KEY_4","Это строка, которая возвращается при нажатии кнопки назад")
                setResult(RESULT_OK,myIntent)
                finish()
            }
        }
        )




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.miAbout -> {
                Toast.makeText(this,"About Нажата ",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.miAbdd -> {
                Toast.makeText(this,"ADD  Нажата ",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.miClose -> {
                val myIntent = Intent()
                myIntent.putExtra("MY_KEY_3","Это строка, которая возвращается назад")
                setResult(RESULT_OK,myIntent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Устаревший вариант
//    override fun onBackPressed() {
//        super.onBackPressed()
//    }


}