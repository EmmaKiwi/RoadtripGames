package com.mercari.roadtripgames.utils

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class ToastProvider @Inject constructor(private val context: Context) {

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}