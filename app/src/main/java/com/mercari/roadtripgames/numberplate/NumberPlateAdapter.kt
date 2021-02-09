package com.mercari.roadtripgames.numberplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
import kotlinx.android.synthetic.main.layout_number_plate.view.*

class NumberPlateAdapter: RecyclerView.Adapter<NumberPlateAdapter.ViewHolder>() {

    private val numberPlates = NumberPlateType.values()

    override fun getItemCount(): Int = numberPlates.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val numberPlateType = numberPlates[position]
        holder.setStateTitle(numberPlateType.stateName)
        holder.setSlogan(numberPlateType.slogan)
        numberPlateType.image?.let { holder.setImage(it) }
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

        fun setStateTitle(title: String) {
            stateTitle.text = title
        }

        fun setSlogan(sloganTitle: String) {
            slogan.text = sloganTitle
        }

        fun setImage(img: Int) {
            image.setImageResource(img)
        }
    }
}
