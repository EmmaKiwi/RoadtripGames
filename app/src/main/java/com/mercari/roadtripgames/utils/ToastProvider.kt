package com.mercari.roadtripgames.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import javax.inject.Inject

class ToastProvider @Inject constructor(private val context: Context) {

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showToastOnTop(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).apply {
            this.setGravity(Gravity.TOP, 0, TOAST_MARGIN)
        }.show()
    }

    companion object {
        private const val TOAST_MARGIN = 24
    }
}