package com.mercari.roadtripgames.numberplate

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.numberplate.di.DaggerNumberPlateComponent
import com.mercari.roadtripgames.numberplate.di.NumberPlateModule
import kotlinx.android.synthetic.main.activity_number_plate.*
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
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

        setupToolbar()
        setupSearch()
        setupRecyclerView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupSearch() {
        search.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    searchStates(v.text.toString())
                    true
                }
                else -> false
            }
        }
    }

    private fun setupRecyclerView() {
        numberPlateAdapter.setOnPlateFoundListener {
            viewModel.onPlateUpdated(it)
            if (it.isFound) {
                onPlateFound()
            }
        }
        number_plate_list.apply {
            adapter = numberPlateAdapter
        }
        viewModel.numberPlates.observe(this, Observer {
            numberPlateAdapter.submitList(it)
        })
        viewModel.isAllPlatesFound.observe(this, Observer { gameComplete ->
            if (gameComplete) {
                complete_layout.visibility = View.VISIBLE
                play_again_button.setOnClickListener {
                    playAgain()
                }
            }
        })
    }

    private fun searchStates(text: String) {
        viewModel.filterPlates(text)
    }

    private fun playAgain() {
        complete_layout.visibility = View.GONE
        viewModel.resetPlates()
    }

    private fun onPlateFound() {
        showConfetti()
        animateMessage()
    }

    private fun animateMessage() {
        congratulations_layout.apply {
            visibility = View.VISIBLE
            postDelayed({
                visibility = View.GONE
            }, 1000)
        }
    }

    private fun showConfetti() {
        viewKonfetti.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12))
            .setPosition(
                (viewKonfetti.width / 2).toFloat(),
                (viewKonfetti.width / 2).toFloat(),
                (viewKonfetti.height / 2).toFloat(),
                (viewKonfetti.height / 2).toFloat())
            .burst(3000)
    }
}
