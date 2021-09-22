package com.mercari.roadtripgames.games.numberplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate
import kotlinx.android.synthetic.main.layout_number_plate.view.*

class NumberPlateAdapter: ListAdapter<NumberPlate, NumberPlateAdapter.ViewHolder>(NumberPlateDiffCallback()) {
    private var onPlateFoundListener: ((NumberPlate) -> Unit)? = null

    fun setOnPlateFoundListener(listener: (NumberPlate) -> Unit) {
        onPlateFoundListener = listener
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plate = getItem(position)
        val numberPlateType = plate.type
        holder.setStateTitle(numberPlateType.stateName)
        holder.setSlogan(numberPlateType.slogan)
        holder.setIsFound(plate.isFound)
        numberPlateType.image?.let { holder.setImage(it) }
        holder.setPlateFoundListener {
            plate.isFound = !plate.isFound
            onPlateFoundListener?.invoke(plate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_number_plate, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val stateTitle: TextView = view.state_title
        private val slogan: TextView = view.state_slogan
        private val image: ImageView = view.state_image
        private val checkbox: ImageView = view.state_found

        fun setStateTitle(title: String) {
            stateTitle.text = title
        }

        fun setSlogan(sloganTitle: String) {
            slogan.text = sloganTitle
        }

        fun setImage(img: Int) {
            image.setImageResource(img)
        }

        fun setIsFound(found: Boolean) {
            checkbox.isVisible = found
        }

        fun setPlateFoundListener(listener: () -> Unit) {
            view.setOnClickListener { listener.invoke() }
        }
    }

    class NumberPlateDiffCallback : DiffUtil.ItemCallback<NumberPlate>() {
        override fun areContentsTheSame(oldItem: NumberPlate, newItem: NumberPlate): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: NumberPlate, newItem: NumberPlate): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
