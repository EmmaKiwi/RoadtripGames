package com.mercari.roadtripgames.numberplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.numberplate.di.DaggerNumberPlateComponent
import kotlinx.android.synthetic.main.activity_number_plate.*

class NumberPlateActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_plate)

//        DaggerNumberPlateComponent.builder()
//            .build()
//            .inject(this)

        setupRecyclerView()
    }

    fun setupRecyclerView() {
        number_plate_list.apply {
            adapter = NumberPlateAdapter()
        }
    }
}
