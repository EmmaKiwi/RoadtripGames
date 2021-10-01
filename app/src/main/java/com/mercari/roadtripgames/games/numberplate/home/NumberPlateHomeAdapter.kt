package com.mercari.roadtripgames.games.numberplate.home

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame

class NumberPlateHomeAdapter: RecyclerView.Adapter<NumberPlateHomeAdapter.ViewHolder>() {

    private val games: MutableList<NumberPlateGame> = mutableListOf()
    private var onGameClickedListener: ((NumberPlateGame) -> Unit)? = null
    private var onDeleteGameListener: ((NumberPlateGame) -> Unit)? = null

    fun setGames(newGames: List<NumberPlateGame>) {
        games.clear()
        games.addAll(newGames)
        notifyDataSetChanged()
    }

    fun setOnGameClickListener(listener: (NumberPlateGame) -> Unit) {
        onGameClickedListener = listener
    }

    fun setOnDeleteGameClickListener(listener: (NumberPlateGame) -> Unit) {
        onDeleteGameListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_number_plate_game, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = games[position]
        holder.onDeleteGameListener = {
            onDeleteGameListener?.invoke(game)
        }
        holder.bind(game, onGameClickedListener)
    }

    override fun getItemCount() = games.size

    class ViewHolder(
        private val view: View
    ): RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        private val gameTitle by lazy { view.findViewById<TextView>(R.id.game_title) }
        private val gameStatus by lazy { view.findViewById<TextView>(R.id.game_status) }

        var onDeleteGameListener: (() -> Unit)? = null

        init {
            view.setOnCreateContextMenuListener(this)
        }

        fun bind(game: NumberPlateGame, listener: ((NumberPlateGame) -> Unit)?) {
            gameTitle.text = game.name
            gameStatus.text = "In progress"
            view.setOnClickListener {
                listener?.invoke(game)
            }
        }

        override fun onCreateContextMenu(
            menu: ContextMenu,
            v: View,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            menu.add(Menu.NONE, view.id, 0, R.string.delete_game).apply {
                setOnMenuItemClickListener {
                    onDeleteGameListener?.invoke()
                    true
                }
            }
        }
    }
}