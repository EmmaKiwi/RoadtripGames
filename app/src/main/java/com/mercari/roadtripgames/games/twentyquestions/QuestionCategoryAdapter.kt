package com.mercari.roadtripgames.games.twentyquestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory

class QuestionCategoryAdapter(
    private val categories: List<QuestionCategory>
): RecyclerView.Adapter<QuestionCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_question_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val title by lazy { view.findViewById<TextView>(R.id.question_title) }
        private val subtitle by lazy { view.findViewById<TextView>(R.id.question_subtitle) }

        fun bind(category: QuestionCategory) {
            title.text = category.title
            subtitle.text = category.subtitle
        }
    }
}