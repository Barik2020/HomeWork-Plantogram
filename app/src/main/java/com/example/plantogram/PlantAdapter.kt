package com.example.plantogram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantogram.databinding.PlantItemBinding

class PlantAdapter
    (var plantList: List<Plant>): RecyclerView.Adapter <PlantAdapter.PlantHolder>() {


    fun submitList(newList: List<Plant>) {
        plantList = newList
        notifyDataSetChanged() // это тяжело
    }

    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)

        fun bind(plant: Plant) = with(binding){
            img.setImageResource(plant.imageId)
            txt.text = plant.title
        }

    }

    // Надуватель шаблона, хранит в себе класс PlantHolder который в себе ранит ссылки на данные
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.plant_item,
            parent,
            false
        )
        //Вместо использования R.layout спроси как нужно по халяльному искать айтемы
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

}