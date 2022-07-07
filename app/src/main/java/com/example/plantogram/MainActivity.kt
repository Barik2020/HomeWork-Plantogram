package com.example.plantogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantogram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var plantSelectorList = listOf<Selector>(
        Selector(1, "First"),
        Selector(2,  "Second")
    )

    private var imageIdList1 = listOf<Plant>(
        Plant(
            R.drawable.plant1,
            title = "Whatever plant I found, but smaller.",
        ), Plant(
            R.drawable.plant2,
            title = "Whatever plant I found, but smaller."
        ), Plant(
            R.drawable.plant3,
            title = "Other Plant, but like, taller..."
        )
    )

    private var imageIdList2 = listOf<Plant>(
        Plant(
            R.drawable.plant4,
            title = "Yeah, they committed suicide"
        ),Plant(
            R.drawable.plant5,
            title = "This one is just ugly?"
        ),Plant(
            R.drawable.plant6,
            title = "Double trouble"
        )
    )

    private val selectorAdapter = com.example.assighnment.SelectorAdapter(plantSelectorList)
    private var adapter = PlantAdapter(imageIdList1)


   // private val adapter2  = SelectorAdapter(plantSelectorList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init() = with(binding){
        recyclerSelector.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerSelector.adapter = selectorAdapter

        selectorAdapter.iCanStartActivity = {
            if (it == 1) adapter.submitList(imageIdList1)
            else adapter.submitList(imageIdList2)
        }




        recyclerMain.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerMain.adapter = adapter
    }

}