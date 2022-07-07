package com.example.assighnment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plantogram.R
import com.example.plantogram.Selector

class SelectorAdapter(var selectorList: List<Selector>) : RecyclerView.Adapter<SelectorAdapter.MyView>() {

    var iCanStartActivity: ((Int) -> Unit)? = null




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        //создает столько вьюхолдеров сколько поместится на экран
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_plant_selector,
            parent,
            false
        )
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        //будет вызвана тогда, когда элемент. вышедший за пределы экрана будет преиспользоваться
        holder.textView.text = selectorList[position].selectorTitle
    }

    override fun getItemCount(): Int {
        // возвращает количество элементов в списке
        return selectorList.size
    }

    inner class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<TextView>(R.id.rvButton)

        init {
            view.setOnClickListener {
                iCanStartActivity?.invoke(selectorList[adapterPosition].selectorId)
            }
        }
    }

}