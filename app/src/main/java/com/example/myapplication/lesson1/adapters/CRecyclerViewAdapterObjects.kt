package com.example.myapplication.lesson1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.lesson1.databinding.RecycleviewobjectsItemBinding
import com.example.myapplication.lesson1.models.CObject

class CRecyclerViewAdapterObjects
/**
 * Конструктор
 * @param item - список элементов данных , информацию по которым нужно выводить на экран
 */

    (
    private  val items : MutableList<CObject>,
    private  val listener  :(Int,CObject) -> Unit
            ) : RecyclerView.Adapter<CRecyclerViewAdapterObjects.CViewHolderObject>()

{
   /*********************************************************************
    * Вспомогательный класс , отвечающий за визуальное отображение одного элемента
    ******************************************************/
    inner  class CViewHolderObject

   /**
    * Конструктор
    * @param binding - объект, кхранящий ссылки на элемент интерфейса, у которых указан идентификатор
    */
   (
        private val binding             :RecycleviewobjectsItemBinding,
        private  val listener           :(Int,CObject) -> Unit
         )                              : RecyclerView.ViewHolder(binding.root)


    {
        private lateinit var item : CObject
        private  var index: Int = -1

        init{
            binding.linearLayoutObject.setOnClickListener {listener(index , item )}
        }
        /**********************************************
        * Метод описывает логику вывода элемента данных в строку списка
        * @param  newItem - элемент данных для вывода
        ***********************************************/
        fun bind (
            newItem         :CObject,
            position:           Int
        ) {
            index = position
            item = newItem
            binding.textViewName.text  = newItem.name
            binding.textViewDescription.text = newItem.description
        }



    }

    /***
     * Метод возвращает актуальное количество элементов в списке
     * @return общее количество элементов данных в списке
     */

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CViewHolderObject {
        val binding = RecycleviewobjectsItemBinding.inflate(
            LayoutInflater.from(parent.context) , parent, false
        )
        return CViewHolderObject((binding),listener)
    }


    /****
     * Метод вызывается в момент назначения элемента данных с порядковым номером  podsition на выводе
     * строке списка Holder
     * @param holder - строка списка с управляющими графическими эллементами
     * @return position -порядковый номер элемента данных
     */

    override fun onBindViewHolder(holder: CViewHolderObject, position: Int) {
        holder.bind(items[position] ,position)
    }







}