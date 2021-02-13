package com.mercari.roadtripgames.numberplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
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
        holder.setPlateFoundListener { found ->
            plate.isFound = found
            onPlateFoundListener?.invoke(plate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_number_plate, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val stateTitle: TextView = view.state_title
        private val slogan: TextView = view.state_slogan
        private val image: ImageView = view.state_image
        private val checkBox: AppCompatCheckBox = view.state_found

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
            checkBox.isChecked = found
        }

        fun setPlateFoundListener(listener: (Boolean) -> Unit) {
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (buttonView.isPressed) {
                    listener.invoke(isChecked)
                }
            }
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
