package com.mercari.roadtripgames.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: HomeNavigator

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        (this.application as RoadTripApplication)
            .appComponent
            .newHomeComponent()
            .activity(this)
            .build()
            .inject(this)

        setupToolbar()
        observeUser()
        setupListeners()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupListeners() {
        number_plate_game.setOnClickListener {
            navigator.openNumberPlateGame()
        }
    }

    private fun observeUser() {
        viewModel.user.observe(this, Observer { user ->
            showTitle("${user.username}'s games")
        })
        viewModel.isGuest.observe(this, Observer { isGuest ->
            if (isGuest) {
                showTitle("All games")
            }
        })
    }

    private fun showTitle(title: String) {
        supportActionBar?.title = title
    }
}
