package com.mercari.roadtripgames.games.twentyquestions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import javax.inject.Inject

class TwentyQuestionsActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: TwentyQuestionsViewModel

    private val categoryAdapter = QuestionCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twenty_questions)

        setupDi()
        setupQuestionList()
    }

    private fun setupDi() {
        (this.application as RoadTripApplication)
            .appComponent
            .newTwentyQuestionsComponent()
            .activity(this)
            .build()
            .inject(this)
    }

    private fun setupQuestionList() {
        findViewById<RecyclerView>(R.id.question_categories_list).apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(this@TwentyQuestionsActivity, 2)
        }
        viewModel.questionCategories.observe(this, Observer {
            if (it.isNotEmpty()) {
                categoryAdapter.setCategories(it)
            }
        })
    }
}