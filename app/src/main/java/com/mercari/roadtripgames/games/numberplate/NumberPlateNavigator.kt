package com.mercari.roadtripgames.games.numberplate

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.games.numberplate.game.NumberPlateGameFragment
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
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, NumberPlateGameFragment.getInstance(), "Game")
            .addToBackStack("Game")
            .commit()
    }

    override fun back() {
        if (activity.supportFragmentManager.backStackEntryCount > 0) {
            activity.supportFragmentManager.popBackStack()
        } else {
            activity.finish()
        }
    }
}