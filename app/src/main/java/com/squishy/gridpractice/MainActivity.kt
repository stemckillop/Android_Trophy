package com.squishy.gridpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squishy.gridpractice.adapter.MyGridAdapter
import com.squishy.gridpractice.models.Model

class MainActivity : AppCompatActivity() {

    lateinit var grid : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grid = findViewById(R.id.main_cyl_grid)

        var list = arrayListOf(
                Model(1, "", "Personal Records", ""),
                Model(2, "", "4 of 6", ""),
                Model(0, "", "Longest Run", "00:00"),
                Model(0, "", "Highest Elevation", "2095 ft"),
                Model(0, "", "Fastest 5K", "00:00"),
                Model(0, "", "10K", "00:00:00"),
                Model(0, "", "Half Marathon", "00:00"),
                Model(0, "", "Marathon", "Not Yet", false),
                Model(1, "", "Virtual Races", ""),
                Model(2, "", "", ""),
                Model(0, "", "Virtual Half Marathon Race", "00:00"),
                Model(0, "", "Tokyo-Hakone Ekiden 2020", "00:00:00"),
                Model(0, "", "Virtual 10K Race", "00:00:00"),
                Model(0, "", "Hakone Ekiden", "00:00:00"),
                Model(0, "", "Mizuno Singapore Ekiden 2015", "00:00:00"),
                Model(0, "", "Virtual 5K Race", "23:07"))
        grid.adapter = MyGridAdapter(this, list)
        grid.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)

    }
}