package com.mercari.roadtripgames.games.numberplate.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import kotlinx.android.synthetic.main.fragment_number_plate_home.*
import javax.inject.Inject

class NumberPlateHomeFragment: Fragment(R.layout.fragment_number_plate_home) {

    @Inject
    lateinit var viewModel: NumberPlateHomeViewModel
    @Inject
    lateinit var navigator: NumberPlateContract.Navigator

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as RoadTripApplication)
            .appComponent
            .newNumberPlateHomeComponent()
            .activity(requireActivity() as AppCompatActivity)
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupListeners()
    }

    private fun setupListeners() {
        new_game_button.setOnClickListener {
            createNewGame()
        }
    }

    private fun setupToolbar() {
        requireView().findViewById<Toolbar>(R.id.toolbar).apply {
            inflateMenu(R.menu.menu_number_plate_home)
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.new_game -> {
                        createNewGame()
                        true
                    }
                    else -> false
                }
            }
            setNavigationIcon(R.drawable.outline_arrow_back_white_24)
            setNavigationOnClickListener { navigator.back() }
            setTitle(R.string.number_plate_title)
        }
    }

    private fun createNewGame() {
        viewModel.addNewGame()
        navigator.showGameFragment()
    }

    companion object {
        fun getInstance() = NumberPlateHomeFragment()
    }
}