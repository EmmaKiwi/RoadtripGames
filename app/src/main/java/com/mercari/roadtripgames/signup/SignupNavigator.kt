package com.mercari.roadtripgames.signup

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.user.User
import javax.inject.Inject

class SignupNavigator @Inject constructor(
    private val activity: AppCompatActivity
): SignupContract.Navigator {

    override fun signup(user: User) {
        activity.setResult(Activity.RESULT_OK)
        activity.finish()
    }
}