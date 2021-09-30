package com.mercari.roadtripgames.games.numberplate.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame

class NumberPlateHomeAdapter: RecyclerView.Adapter<NumberPlateHomeAdapter.ViewHolder>() {

    private val games: MutableList<NumberPlateGame> = mutableListOf()

    fun setGames(newGames: List<NumberPlateGame>) {
        games.clear()
        games.addAll(newGames)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_number_plate_game, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game)
    }

    override fun getItemCount() = games.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val gameTitle by lazy { view.findViewById<TextView>(R.id.game_title) }
        private val gameStatus by lazy { view.findViewById<TextView>(R.id.game_status) }

        fun bind(game: NumberPlateGame) {
            gameTitle.text = game.name
            gameStatus.text = "In progress"
        }
    }
}