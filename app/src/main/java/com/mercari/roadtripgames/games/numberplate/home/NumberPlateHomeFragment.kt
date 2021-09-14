package com.mercari.roadtripgames.games.numberplate.home

import android.content.Context
import androidx.fragment.app.Fragment
import com.mercari.roadtripgames.R

class NumberPlateHomeFragment(): Fragment(R.layout.fragment_number_plate_home) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    companion object {
        fun getInstance() = NumberPlateHomeFragment()
    }
}