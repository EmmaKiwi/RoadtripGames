package com.mercari.roadtripgames.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.home.HomeActivity
import javax.inject.Inject

class LoginNavigator @Inject constructor(
    private val activity: AppCompatActivity
) : LoginContract.Navigator {

    override fun login() {
        val intent = Intent(activity, HomeActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    override fun signup() {
        TODO("Not yet implemented")
    }
}