package com.mercari.roadtripgames.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.games.numberplate.NumberPlateActivity
import com.mercari.roadtripgames.games.twentyquestions.TwentyQuestionsActivity
import javax.inject.Inject

class HomeNavigator @Inject constructor(private val activity: AppCompatActivity) : HomeContract.Navigator {

    override fun openNumberPlateGame() {
        val intent = Intent(activity, NumberPlateActivity::class.java)
        activity.startActivityForResult(intent, NumberPlateRequestCode)
    }

    override fun openTwentyQuestions() {
        val intent = Intent(activity, TwentyQuestionsActivity::class.java)
        activity.startActivityForResult(intent, TwentyQuestionsRequestCode)
    }

    companion object {
        const val NumberPlateRequestCode = 10000
        const val TwentyQuestionsRequestCode = 10001
    }
}
