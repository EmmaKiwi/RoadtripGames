package com.mercari.roadtripgames.games.numberplate.home

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame
import kotlinx.android.synthetic.main.fragment_number_plate_home.*
import javax.inject.Inject

class NumberPlateHomeFragment: Fragment(R.layout.fragment_number_plate_home) {

    @Inject
    lateinit var viewModel: NumberPlateHomeViewModel
    @Inject
    lateinit var navigator: NumberPlateContract.Navigator

    private val gameAdapter = NumberPlateHomeAdapter()

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
        observeGames()
    }

    private fun observeGames() {
        viewModel.games.observe(viewLifecycleOwner, Observer { games ->
            if (games.isEmpty()) {
                showEmptyGameView()
            } else {
                showGames(games)
            }
        })
    }

    private fun showGames(games: List<NumberPlateGame>) {
        requireView().apply {
            findViewById<View>(R.id.empty_game_layout).isVisible = false
            findViewById<View>(R.id.game_list_layout).isVisible = true
            findViewById<RecyclerView>(R.id.game_list).apply {
                this.adapter = gameAdapter
            }
        }
        gameAdapter.setGames(games)
    }

    private fun showEmptyGameView() {
        requireView().apply {
            findViewById<View>(R.id.empty_game_layout).isVisible = true
            findViewById<View>(R.id.game_list_layout).isVisible = false
        }
    }

    private fun openNewGameDialog() {
        val suggestedTitle = viewModel.generateNewGameTitle()
        val dialogView = LayoutInflater.from(requireContext())
            .inflate(R.layout.dialog_new_number_plate_game, null, false)
        dialogView.findViewById<TextView>(R.id.number_plate_title_text_entry).setText(suggestedTitle, TextView.BufferType.EDITABLE)
        val dialog = AlertDialog.Builder(requireContext()).apply {
            this.setView(dialogView)
            this.setPositiveButton(R.string.number_plate_done) { dialog, _ ->
                val name = dialogView.findViewById<EditText>(R.id.number_plate_title_text_entry).text.toString()
                viewModel.addNewGame(name)
                dialog.dismiss()
            }
            this.setNegativeButton(R.string.number_plate_cancel) { dialog, _ ->
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    private fun setupListeners() {
        new_game_button.setOnClickListener {
            openNewGameDialog()
        }
    }

    private fun setupToolbar() {
        requireView().findViewById<Toolbar>(R.id.toolbar).apply {
            inflateMenu(R.menu.menu_number_plate_home)
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.new_game -> {
                        openNewGameDialog()
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

    companion object {
        fun getInstance() = NumberPlateHomeFragment()
    }
}