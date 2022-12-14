package com.example.myapplication.lesson1.activitias

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.lesson1.R

import com.example.myapplication.lesson1.adapters.CRecyclerViewAdapterObjects
import com.example.myapplication.lesson1.databinding.ActivityListBinding
import com.example.myapplication.lesson1.models.CObject
import java.io.File

class CActivityList : AppCompatActivity()

{
    private lateinit var binding: ActivityListBinding
    private lateinit var resultLauncherObjectEdit : ActivityResultLauncher<Intent>
    private lateinit var resultLauncherObjectAdd : ActivityResultLauncher<Intent>
    private lateinit var resultLauncherPermission: ActivityResultLauncher<Array<String>>  //лаунчер допусков

    private  var test =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = mutableListOf<CObject>()
        items.add(CObject("11","111111"))
        items.add(CObject("Слово2","Описание 2"))
        items.add(CObject("Слово3","Описание 3"))

        binding.rvObjects.layoutManager = LinearLayoutManager(this)

        binding.rvObjects.adapter = CRecyclerViewAdapterObjects(items,

            { index, item ->
           //Вызов активности с информацией по объекту, передача туда параметром
            var intent =            Intent(this,CActivityObjectInfo::class.java)
            intent.putExtra("KEY_INDEX",index)
            intent.putExtra("KEY_OBJECT_NAME",item.name)
            intent.putExtra("KEY_OBJECT_DESCRIPTION",item.description)
            resultLauncherObjectEdit.launch(intent)

        },//Удаление объекта
            { index, _ ->
                items.removeAt(index)
                binding.rvObjects.adapter?.notifyItemRemoved(index)
            }
        )
        /*********************
        /обработчик события завершения активности с информацией по нему (возврата с открытой от сюда формы)
         * в режиме редактирования существующего бъекта
        ***********************************/

        resultLauncherObjectEdit = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Получение параметров из дочерней ктивности
                val data: Intent? = result.data
                val name = data?.getStringExtra("KEY_OBJECT_NAME")?:""
                val description = data?.getStringExtra("KEY_OBJECT_DESCRIPTION")?:""
                val index = data?.getIntExtra("KEY_INDEX",-1)?:-1
                //если какие то проблемы с передачей данных, то выводим сообщение или обрабатываем
                if (index<0)
                {
                    //todo Сообщение о проблеме передачи данных
                }
                else{
                    items[index].name=name
                    items[index].description=description
                    (binding.rvObjects.adapter as CRecyclerViewAdapterObjects).notifyItemChanged(index)
                }

                val x = 123

                //  doSomeOperations() //операция которая выполняется когда дочерняя активность завершается
            }
        }

        /*********************
        /обработчик события завершения активности с информацией по нему (возврата с открытой от сюда формы)
         * в режиме здания нового объекта
         ***********************************/

        resultLauncherObjectAdd = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Получение параметров из дочерней ктивности
                val data: Intent? = result.data
                val name = data?.getStringExtra("KEY_OBJECT_NAME")?:""
            //Добавляем объект в список данных
                   items.add(CObject(name,"тест"))
               //Говорим адаптеру, что конкретная еденица списка добавлена
               (binding.rvObjects.adapter as CRecyclerViewAdapterObjects).notifyItemInserted(items.size-1)

                //  doSomeOperations() //операция которая выполняется когда дочерняя активность завершается
            }
        }


        binding.fab.setOnClickListener{
            //Вызов активности с информацией по объекту, передача туда параметром
            var intent = Intent(this,CActivityObjectInfo::class.java)
            //intent.putExtra("KEY_INDEX",index)   вот только ичего не передаем. так что это комментируем
            resultLauncherObjectAdd.launch(intent)
        }

        /*********************
        /Проверка наличия разрешений
         ***********************************/

        // Register the permissions callback, which handles the user's response to the
        // system permissions dialog. Save the return value, an instance of
        // ActivityResultLauncher. You can use either a val, as shown in this snippet,
        // or a lateinit var in your onAttach() or onCreate() method.
         resultLauncherPermission            =
            registerForActivityResult(
                ActivityResultContracts.RequestMultiplePermissions()
            ) { map: Map <String, Boolean> ->
                if (map[Manifest.permission.ACCESS_FINE_LOCATION]==true) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                    test = 1

                } else {
                    // Explain to the user that the feature is unavailable because the
                    // feature requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                    test = 2
                }
            }

        //checkAndRequestPermission()

        /************
         * Запись файла
         */
        // Создаем файл и записываем в нем текст из списка
        //Индивидуальный раздел памяти для приложения data/data/NAME/files
       // val file = File(applicationContext.filesDir, "123.txt")
        //Создаем в другой папке. что указано в Environment
       val file = File(applicationContext.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "123.txt")
//
//        val text = listOf("54543","123 dsf12","123")
//        file.createNewFile()
//            file.printWriter().use {out->
//                text.forEach{
//                   out.println(it)
//               }
//           }
//
//        /************
//         * Чтение файла
//         */
//
//       val text = file.readLines().toList()
//        Log.d("TEST",text.joinToString ("/n"))
//

   val pref =  PreferenceManager.getDefaultSharedPreferences(applicationContext)
        //вызываем относительно всего приложегния

//        with (pref.edit()) {
//            putInt("KEY_INT",123)
//            putString("KEY_STRING","test test 100500")
//            apply()
//        }

        val text  = pref.getString("KEY_STRING","default value")
        var chisl  = pref.getInt("KEY_INT",99999)
        chisl = chisl +0

    }//Конец OnCreate

    private fun checkAndRequestPermission ()
    {

        //Список всех необходимых допусков
        val allPermissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )

        //Проходим по полному списку разрешений, и если у них нет разрешения, то только по ним и спрашиваем разрешение

        val permissionsToAsk = allPermissions
            .filter {
                        return@filter ContextCompat.checkSelfPermission(
                this,
                   it
            ) == PackageManager.PERMISSION_DENIED
            }
        if (permissionsToAsk.isNotEmpty())
            resultLauncherPermission.launch(
                permissionsToAsk.toTypedArray()
            )

    }

}