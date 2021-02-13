package com.mercari.roadtripgames.numberplate

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.numberplate.di.DaggerNumberPlateComponent
import com.mercari.roadtripgames.numberplate.di.NumberPlateModule
import kotlinx.android.synthetic.main.activity_number_plate.*
import javax.inject.Inject

class NumberPlateActivity  : AppCompatActivity() {

    @Inject lateinit var viewModel: NumberPlateViewModel
    private val numberPlateAdapter = NumberPlateAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_plate)

        DaggerNumberPlateComponent.builder()
            .numberPlateModule(NumberPlateModule(this))
            .build()
            .inject(this)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        numberPlateAdapter.setOnPlateFoundListener { viewModel.onPlateFound(it) }
        number_plate_list.apply {
            adapter = numberPlateAdapter
        }
        viewModel.numberPlates.observe(this, Observer {
            numberPlateAdapter.submitList(it)
        })
    }
}
