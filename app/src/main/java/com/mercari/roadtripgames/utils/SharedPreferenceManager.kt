package com.mercari.roadtripgames.utils

import android.content.Context
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(
    private val context: Context
) {

    fun savePreference(key: String, value: Long) {
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE).apply {
            with (this.edit()) {
                putLong(key, value)
                apply()
            }
        }
    }

    fun getPreference(key: String) =
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE).getLong(key, 0L)

    companion object {
        private const val preferencesName = "RoadtripPreferences"
    }
}