package com.mercari.roadtripgames.games.numberplate.game

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import com.mercari.roadtripgames.games.numberplate.NumberPlateAdapter
import kotlinx.android.synthetic.main.fragment_number_plate_game.*
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
import javax.inject.Inject

class NumberPlateGameFragment(): Fragment(R.layout.fragment_number_plate_game) {

    @Inject
    lateinit var viewModel: NumberPlateViewModel
    private val numberPlateAdapter = NumberPlateAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as RoadTripApplication)
            .appComponent
            .newNumberPlateGameComponent()
            .build()
            .inject(this)

        setupToolbar()
        setupSearch()
        setupRecyclerView()
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
        search.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) { clearSearchFocus() }
        }
        search_layout.setEndIconOnClickListener {
            search.text?.clear()
            clearSearch()
        }
    }

    private fun setupRecyclerView() {
        numberPlateAdapter.setOnPlateFoundListener {
            clearSearchFocus()
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

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).run {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun clearSearchFocus() {
        search.clearFocus()
        (requireActivity().getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(search.windowToken, 0)
    }



    private fun searchStates(text: String) {
        viewModel.filterPlates(text)
    }

    private fun clearSearch() {
        viewModel.clearSearch()
    }

    companion object {
        fun getInstance() = NumberPlateGameFragment()
    }
}