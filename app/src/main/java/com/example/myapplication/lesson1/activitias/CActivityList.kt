package com.example.myapplication.lesson1.activitias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myapplication.lesson1.adapters.CRecyclerViewAdapterObjects
import com.example.myapplication.lesson1.databinding.ActivityListBinding
import com.example.myapplication.lesson1.models.CObject

class CActivityList : AppCompatActivity(),
CRecyclerViewAdapterObjects.IItemClickListener{
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = mutableListOf<CObject>()
        items.add(CObject("Слово1","Описание 1"))
        items.add(CObject("Слово2","Описание 2"))
        items.add(CObject("Слово3","Описание 3"))

        binding.rvObjects.layoutManager = LinearLayoutManager(this)
        binding.rvObjects.adapter = CRecyclerViewAdapterObjects(items ,this)
    }

    override fun onItemClick(index: Int, item: CObject) {
        Toast.makeText(this,"Click  NA ${item.name} с порядковым номером $index" ,Toast.LENGTH_SHORT).show()
    }
}