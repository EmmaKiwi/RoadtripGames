package com.mercari.roadtripgames.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.home.HomeActivity
import com.mercari.roadtripgames.login.signup.SignupActivity
import com.mercari.roadtripgames.auth.user.User
import javax.inject.Inject

class LoginNavigator @Inject constructor(
    private val activity: AppCompatActivity
) : LoginContract.Navigator {

    override fun login(user: User) {
        val intent = Intent(activity, HomeActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    override fun signup() {
        val intent = Intent(activity, SignupActivity::class.java)
        activity.startActivityForResult(intent, SIGNUP_REQUEST_CODE)
    }

    override fun openHomeWithoutLogin() {
        val intent = Intent(activity, HomeActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    companion object {
        const val SIGNUP_REQUEST_CODE = 12000
    }
}