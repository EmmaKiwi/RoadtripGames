package com.mercari.roadtripgames.games.numberplate

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.games.numberplate.home.NumberPlateHomeFragment
import javax.inject.Inject

class NumberPlateNavigator @Inject constructor(
    private val activity: AppCompatActivity
): NumberPlateContract.Navigator {

    override fun showHomeFragment() {
        activity.supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, NumberPlateHomeFragment.getInstance(), "Home")
            .commit()
    }

    override fun showGameFragment() {
        TODO("Not yet implemented")
    }
}