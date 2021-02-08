package com.mercari.roadtripgames.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.numberplate.NumberPlateActivity
import javax.inject.Inject

class HomeNavigator @Inject constructor(private val activity: AppCompatActivity) : HomeContract.Navigator {

    override fun openNumberPlateGame() {
        val intent = Intent(activity, NumberPlateActivity::class.java)
        activity.startActivityForResult(intent, NumberPlateRequestCode)
    }

    companion object {
        const val NumberPlateRequestCode = 10000
    }
}
