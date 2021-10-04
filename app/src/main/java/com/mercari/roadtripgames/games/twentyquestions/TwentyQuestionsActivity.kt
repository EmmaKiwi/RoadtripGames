package com.mercari.roadtripgames.games.twentyquestions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication

class TwentyQuestionsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twenty_questions)

        setupDi()
    }

    private fun setupDi() {
        (this.application as RoadTripApplication)
            .appComponent
            .newTwentyQuestionsComponent()
            .activity(this)
            .build()
            .inject(this)
    }
}