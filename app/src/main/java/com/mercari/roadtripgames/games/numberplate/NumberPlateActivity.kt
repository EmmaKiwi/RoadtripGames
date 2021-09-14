package com.mercari.roadtripgames.games.numberplate

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import javax.inject.Inject


class NumberPlateActivity  : AppCompatActivity() {

    @Inject lateinit var navigator: NumberPlateContract.Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_plate)

        (this.application as RoadTripApplication)
            .appComponent
            .newNumberPlateComponent()
            .activity(this)
            .build()
            .inject(this)

        navigator.showHomeFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}
